package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        synchronized (Solution.class){
            if (args[0].equals("-c")){

                int name = 1;
                int sex = 2;
                int data = 3;

                while (data < args.length){
                    if (args[sex].equals("м")){
                        allPeople.add(Person.createMale(args[name], new SimpleDateFormat("dd/MM/yyyy").parse(args[data])));
                        System.out.println(allPeople.size()-1);
                        name += 3;
                        sex += 3;
                        data += 3;
                    }
                    else if (args[sex].equals("ж")){
                        allPeople.add(Person.createFemale(args[name], new SimpleDateFormat("dd/MM/yyyy").parse(args[data])));
                        System.out.println(allPeople.size()-1);
                        name += 3;
                        sex += 3;
                        data += 3;
                    }
                }
            }

            else if(args[0].equals("-u")){

                int id = 1;
                int name = 2;
                int sex = 3;
                int data = 4;

                while (data < args.length){

                    int i = Integer.parseInt(args[id]);

                    if (args[sex].equals("м")){
                        allPeople.get(i).setSex(Sex.MALE);
                    }
                    else if (args[sex].equals("ж")){
                        allPeople.get(i).setSex(Sex.FEMALE);
                    }

                    allPeople.get(i).setName(args[name]);
                    allPeople.get(i).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[data]));

                    id += 4;
                    name += 4;
                    sex += 4;
                    data += 4;
                }
            }

            else if(args[0].equals("-d")){

                int id = 1;

                while (id < args.length){

                    int i = Integer.parseInt(args[id]);

                    allPeople.set(i, null);

                    id += 1;
                }
            }

            else if(args[0].equals("-i")){

                int id = 1;

                while (id < args.length){

                    int i = Integer.parseInt(args[id]);

                    String s = "";

                    if (allPeople.get(i).getSex().equals(Sex.MALE)){
                        s = "м";
                    }
                    else if (allPeople.get(i).getSex().equals(Sex.FEMALE)){
                        s = "ж";
                    }

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                    System.out.println(allPeople.get(i).getName() + " " + s + " " + simpleDateFormat.format(allPeople.get(i).getBirthDay()));

                    id += 1;
                }
            }
        }
    }
}
