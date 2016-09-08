package com.javarush.test.level27.lesson15.big01.ad;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by s.sergienko on 05.09.2016.
 */
public class StatisticAdvertisementManager {

    private volatile static StatisticAdvertisementManager ourInstance;

    public static StatisticAdvertisementManager getInstance() {
        if (ourInstance == null) {
            synchronized (StatisticAdvertisementManager.class) {
                if (ourInstance == null) {
                    ourInstance = new StatisticAdvertisementManager();
                }
            }
        }
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public Set<Advertisement> getActiveVideoSet() {
        Set<Advertisement> advertisements = new HashSet<>();

        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() > 0) {
                advertisements.add(advertisement);
            }
        }

        return advertisements;
    }

    public Set<Advertisement> getArchivedVideoSet() {
        Set<Advertisement> advertisements = new HashSet<>();

        for (Advertisement advertisement : advertisementStorage.list()) {
            if (advertisement.getHits() == 0) {
                advertisements.add(advertisement);
            }
        }

        return advertisements;
    }
}
