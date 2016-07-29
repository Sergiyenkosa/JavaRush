package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by s.sergienko on 20.07.2016.
 */
public class CurrencyManipulator {
    String currencyCode;

    Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if(denominations.containsKey(denomination))
            denominations.put(denomination, denominations.get(denomination) + count);
        else
            denominations.put(denomination,count);
    }

    public int getTotalAmount() {
        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }

        return sum;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        int a = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.putAll(denominations);
        Map<Integer, Integer> map2 = new HashMap<>();

        List<Integer> list = new LinkedList<>();
        list.addAll(denominations.keySet());
        Collections.sort(list);

        int count = 0;

        Map[] maps = new Map[2];

        int size = list.size();

        for (int cycle = 2; cycle > 0; cycle--) {

            for (int i = size - 1; i > -1; i--) {

                for (int i2 = denominations.get(list.get(i)); i2 > 0; i2--) {

                    if (list.get(i) + a <= expectedAmount) {

                        a += list.get(i);

                        map1.put(list.get(i), map1.get(list.get(i))-1);
                        if (map2.containsKey(list.get(i))) {
                            map2.put(list.get(i), map2.get(list.get(i))+1);
                        }
                        else {
                            map2.put(list.get(i), 1);
                        }
                    }

                    if (a == expectedAmount){
                        int newCount = 0;

                        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                            newCount += entry.getValue();
                        }

                        if (maps[0] != null && count > newCount) {
                            Map<Integer, Integer> map1Copy = new HashMap();
                            map1Copy.putAll(map1);
                            Map<Integer, Integer> map2Copy = new HashMap();
                            map2Copy.putAll(map2);

                            maps[0] = map1Copy;
                            maps[1] = map2Copy;

                            count = newCount;

                            i = 0;
                            break;
                        }
                        else {
                            Map<Integer, Integer> map1Copy = new HashMap();
                            map1Copy.putAll(map1);
                            Map<Integer, Integer> map2Copy = new HashMap();
                            map2Copy.putAll(map2);

                            maps[0] = map1Copy;
                            maps[1] = map2Copy;

                            count = newCount;

                            i = 0;
                            break;
                        }
                    }
                }


                if (i == 0) {
                    a = 0;
                    size = size-1;
                    i = size;
                    map1.putAll(denominations);
                    map2 = new HashMap<>();
                }
            }

            if (maps[0] == null) {

                a = 0;
                size = list.size();
                map1.putAll(denominations);
                map2 = new HashMap<>();
                Collections.sort(list, new Comparator<Integer>()
                {
                    @Override
                    public int compare(Integer o1, Integer o2)
                    {
                        if (o1 * denominations.get(o1) != o2 * denominations.get(o2)) {
                            return o2 * denominations.get(o2) - o1 * denominations.get(o1);
                        }
                        else {
                            return o2 - o1;
                        }
                    }
                });
            }
            else {
                break;
            }
        }

        if (maps[0] != null){
            denominations.clear();
            denominations.putAll(maps[0]);
            return maps[1];
        }
        else {
            throw new NotEnoughMoneyException();
        }

    }
}
