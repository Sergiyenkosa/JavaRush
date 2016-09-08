package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by s.sergienko on 29.08.2016.
 */
public class DirectorTablet {

    private StatisticEventManager statisticManager = StatisticEventManager.getInstance();

    public void printAdvertisementProfit() {
        List<Date> dates = new ArrayList<>();
        dates.addAll(statisticManager.getAdvertisementProfitByDays().keySet());
        Collections.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return (int) (o2.getTime() - o1.getTime());
            }
        });

        long total = 0;

        for (Date date : dates) {
            total += statisticManager.getAdvertisementProfitByDays().get(date);
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(date), statisticManager.getAdvertisementProfitByDays().get(date) * 0.01));
        }

        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total * 0.01) + "\r\n");
    }

    public void printCookWorkloading() {
        List<Date> dates = new ArrayList<>();
        dates.addAll(statisticManager.getCooksWorkTimeByDays().keySet());
        Collections.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return (int) (o2.getTime() - o1.getTime());
            }
        });

        for (int i = 0; i < dates.size(); i++) {

            ConsoleHelper.writeMessage(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(dates.get(i)));

            for (Map.Entry<String, Integer> entry : statisticManager.getCooksWorkTimeByDays().get(dates.get(i)).entrySet()) {
                ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %d min", entry.getKey(), entry.getValue()));
            }
        }
    }

    public void printActiveVideoSet() {
        List<Advertisement> list = new ArrayList<>();
        list.addAll(StatisticAdvertisementManager.getInstance().getActiveVideoSet());
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toUpperCase().charAt(0) - o2.getName().toUpperCase().charAt(0);
            }
        });

        for (Advertisement advertisement : list) {
            ConsoleHelper.writeMessage(String.format("%s - %d", advertisement.getName(), advertisement.getHits()));
        }
        ConsoleHelper.writeMessage("");
    }

    public void printArchivedVideoSet() {
        List<Advertisement> list = new ArrayList<>();
        list.addAll(StatisticAdvertisementManager.getInstance().getArchivedVideoSet());
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toUpperCase().charAt(0) - o2.getName().toUpperCase().charAt(0);
            }
        });

        for (Advertisement advertisement : list) {
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }

    public void printNoAvailableVideoSet() {
        List<Date> dates = new ArrayList<>();
        dates.addAll(statisticManager.getNoVideoAvailableByDays().keySet());
        Collections.sort(dates, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return (int) (o2.getTime() - o1.getTime());
            }
        });

        for (int i = 0; i < dates.size(); i++) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %d min",new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(dates.get(i)), statisticManager.getNoVideoAvailableByDays().get(dates.get(i))));
        }
    }
}
