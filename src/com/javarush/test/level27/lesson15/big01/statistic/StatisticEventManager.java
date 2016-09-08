package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.*;

import java.util.*;

/**
 * Created by s.sergienko on 26.08.2016.
 */
public class StatisticEventManager
{
    private volatile static StatisticEventManager ourInstance;

    private final StatisticStorage statisticStorage = new StatisticStorage();

    private final int[] Calendar_Params = {Calendar.HOUR_OF_DAY, Calendar.AM_PM, Calendar.HOUR, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND};

    public static StatisticEventManager getInstance() {

        if (ourInstance == null) {
            synchronized (StatisticEventManager.class) {
                if (ourInstance == null) {
                    ourInstance = new StatisticEventManager();
                }
            }
        }

        return ourInstance;
    }

    private StatisticEventManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public Map<Date, Long> getAdvertisementProfitByDays() {
        Map<Date, Long> map = new HashMap<>();

        for (EventDataRow eventDataRow : statisticStorage.getEvents(EventType.SELECTED_VIDEOS)) {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(eventDataRow.getDate());
            for (int i : Calendar_Params) {
                calendar.clear(i);
            }

            if (map.containsKey(calendar.getTime())) {
                map.put(calendar.getTime(), map.get(calendar.getTime())+((VideoSelectedEventDataRow)eventDataRow).getAmount());
            }
            else {
                map.put(calendar.getTime(), ((VideoSelectedEventDataRow)eventDataRow).getAmount());
            }
        }
        return map;
    }

    public Map<Date, Map<String, Integer>> getCooksWorkTimeByDays() {
        Map<Date, Map<String, Integer>> map = new TreeMap<>();

        for (EventDataRow eventDataRow : statisticStorage.getEvents(EventType.COOKED_ORDER)) {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(eventDataRow.getDate());
            for (int i : Calendar_Params) {
                calendar.clear(i);
            }

            CookedOrderEventDataRow cook = (CookedOrderEventDataRow) eventDataRow;

            int time = cook.getTime();
            if (time == 0) continue;
            if (time % 60 == 0) time = time / 60;
            else time = time / 60 + 1;

            if (map.containsKey(calendar.getTime())) {
                if (map.get(calendar.getTime()).containsKey(cook.getCookName())) {
                    map.get(calendar.getTime()).put(cook.getCookName(), map.get(calendar.getTime()).get(cook.getCookName()) + time);
                }
                else {
                    map.get(calendar.getTime()).put(cook.getCookName(), time);
                }
            }
            else {
                Map<String, Integer> map1 = new TreeMap<>();
                map1.put(cook.getCookName(), time);
                map.put(calendar.getTime(), map1);
            }
        }
        return map;
    }

    public Map<Date, Integer> getNoVideoAvailableByDays() {
        Map<Date, Integer> map = new TreeMap<>();

        for (EventDataRow eventDataRow : statisticStorage.getEvents(EventType.NO_AVAILABLE_VIDEO)) {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(eventDataRow.getDate());
            for (int i : Calendar_Params) {
                calendar.clear(i);
            }

            NoAvailableVideoEventDataRow video = (NoAvailableVideoEventDataRow) eventDataRow;

            int time = video.getTime();
            if (time == 0) continue;
            if (time % 60 == 0) time = time / 60;
            else time = time / 60 + 1;

            if (map.containsKey(calendar.getTime())) {
                map.put(calendar.getTime(), map.get(calendar.getTime()) + time);
            }
            else {
                map.put(calendar.getTime(), time);
            }
        }
        return map;
    }

    private class StatisticStorage {

        private Map <EventType, List<EventDataRow>> map = new HashMap<>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                map.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            map.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvents(EventType eventType) {
            return map.get(eventType);
        }
    }
}
