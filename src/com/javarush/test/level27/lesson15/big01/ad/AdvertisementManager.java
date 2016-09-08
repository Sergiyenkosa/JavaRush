package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by s.sergienko on 09.08.2016.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {

        List<Advertisement> advertisements = new ArrayList<>();

        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getDuration() <= timeSeconds && advertisement.getHits() > 0) {
                advertisements.add(advertisement);
            }
        }

        if (advertisements.isEmpty()) {
            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }

        advertisements = recursion(advertisements, null, null, 0, 0, null, null);

        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying()) {
                    return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
                }
                else {
                    return (int) (o1.getAmountPerOneDisplaying()/o1.getDuration() - o2.getAmountPerOneDisplaying()*1000/o2.getDuration());
                }
            }
        });

        long moneyResult = 0;
        int timeResult = 0;

        for (Advertisement advertisement : advertisements) {
            moneyResult += advertisement.getAmountPerOneDisplaying();
            timeResult += advertisement.getDuration();
        }

        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(advertisements, moneyResult, timeResult));

        for (Advertisement advertisement : advertisements) {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(), advertisement.getAmountPerOneDisplaying()*1000/advertisement.getDuration()));
            advertisement.revalidate();
        }
    }

    private List<Advertisement> recursion (List<Advertisement> advertisements, List<Advertisement> advertisementsCompare, List<Advertisement> result, int tCompare, long mCompare, int[] tResult, long[] mResult) {
        if (advertisementsCompare == null && !advertisements.isEmpty()) {
            result = new ArrayList<>();
            tResult = new int[] {0};
            mResult = new long[] {0};

            for (Advertisement advertisement : advertisements) {
                List<Advertisement> compare = new ArrayList<>();
                compare.add(advertisement);

                recursion(advertisements, compare, result, advertisement.getDuration(), advertisement.getAmountPerOneDisplaying(), tResult, mResult);
            }
        }
        else if (advertisementsCompare != null) {
            for (Advertisement advertisement : advertisements) {
                if (!advertisementsCompare.contains(advertisement) && advertisement.getDuration() + tCompare <= timeSeconds) {
                    List<Advertisement> compare = new ArrayList<>();
                    compare.addAll(advertisementsCompare);
                    compare.add(advertisement);
                    recursion(advertisements, compare, result, tCompare + advertisement.getDuration(), mCompare + advertisement.getAmountPerOneDisplaying(), tResult, mResult);
                }
            }

            if (mCompare > mResult[0]) {
                result.clear();
                result.addAll(advertisementsCompare);
                tResult[0] = tCompare;
                mResult[0] = mCompare;
            }
            else if (mCompare == mResult[0]) {
                if (tCompare > tResult[0]) {
                    result.clear();
                    result.addAll(advertisementsCompare);
                    tResult[0] = tCompare;
                    mResult[0] = mCompare;
                }
                else if (tCompare == tResult[0]) {
                    if (advertisementsCompare.size() < result.size()) {
                        result.clear();
                        result.addAll(advertisementsCompare);
                        tResult[0] = tCompare;
                        mResult[0] = mCompare;
                    }
                }
            }
        }

        return result;
    }
}
