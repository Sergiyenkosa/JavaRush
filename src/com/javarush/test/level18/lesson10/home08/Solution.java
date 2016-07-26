package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        List<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";

        while (!(fileName = reader.readLine()).equals("exit")){
            list.add(fileName);
        }

        reader.close();

        for(String s : list){
            new ReadThread(s).start();
        }
    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут


        @Override
        public void run()
        {
            Map<Integer, Integer> map = new HashMap<>();

            try
            {
                FileInputStream in = new FileInputStream(this.fileName);

                while (in.available() > 0){

                    int i = in.read();

                    if (map.containsKey(i)){
                        map.put(i, map.get(i) + 1);
                    }
                    else {
                        map.put(i, 1);
                    }
                }

                in.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            int key = 0, value = 0;

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() > value){
                    value = entry.getValue();
                    key = entry.getKey();
                }
            }

            synchronized (resultMap){
                resultMap.put(this.fileName, key);
            }
        }
    }
}
