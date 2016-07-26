package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv");
            InputStream inputStream = new FileInputStream("C:\\Users\\s.sergienko\\Desktop\\Новый текстовый документ (2).abv");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(javaRush.users.size()-1).setFirstName("fgadsfgasdfg");
            javaRush.users.get(javaRush.users.size()-1).setCountry(User.Country.UKRAINE);
            javaRush.users.add(new User());

            GregorianCalendar calendar = new GregorianCalendar(2004, 11, 19);
            Date date = new Date(calendar.getTimeInMillis());

            javaRush.users.get(javaRush.users.size()-1).setBirthDate(date);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.users.size() + " " + loadedObject.users.size());
            System.out.println(loadedObject.users.get(0).getFirstName() + " " + loadedObject.users.get(0).getCountry() + " " + loadedObject.users.get(1).getBirthDate().toString());
            System.out.println(javaRush.users.get(0).getFirstName() + " " + javaRush.users.get(0).getCountry() + " " + javaRush.users.get(1).getBirthDate().toString());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String areUsersPresent = this.users.isEmpty() == false ? "yes" : "no";
            writer.println(areUsersPresent);

            if(areUsersPresent.equals("yes")){
                writer.println(this.users.size());

                for (User user : this.users){

                    String isFirstNamePresent = user.getFirstName() != null ? "yes" : "no";
                    writer.println(isFirstNamePresent);
                    if(isFirstNamePresent.equals("yes")){
                        writer.println(user.getFirstName());
                    }

                    String isLastNamePresent = user.getLastName() != null ? "yes" : "no";
                    writer.println(isLastNamePresent);
                    if(isLastNamePresent.equals("yes")){
                        writer.println(user.getLastName());
                    }

                    String isDatePresent = user.getBirthDate() != null ? "yes" : "no";
                    writer.println(isDatePresent);
                    if(isDatePresent.equals("yes")){
                        writer.println(user.getBirthDate().getTime());
                    }

                    writer.println(user.isMale());

                    String isCountryPresent = user.getCountry() != null ? "yes" : "no";
                    writer.println(isCountryPresent);
                    if(isCountryPresent.equals("yes")){
                        writer.println(user.getCountry());
                    }
                }
            }

            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String areUsersPresent = reader.readLine();
            if (areUsersPresent.equals("yes")){
                int size = Integer.parseInt(reader.readLine());

                for (int i = 0; i < size; i++){

                    this.users.add(new User());

                    String isFirstNamePresent = reader.readLine();
                    if (isFirstNamePresent.equals("yes")){
                        this.users.get(this.users.size()-1).setFirstName(reader.readLine());
                    }

                    String  isLastNamePresent = reader.readLine();
                    if (isLastNamePresent.equals("yes")){
                        this.users.get(this.users.size()-1).setLastName(reader.readLine());
                    }

                    String isDatePresent = reader.readLine();
                    if (isDatePresent.equals("yes")){
                        this.users.get(this.users.size()-1).setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    }

                    String isMalePresent = reader.readLine();
                    if (isMalePresent.equals("true")){
                        this.users.get(this.users.size()-1).setMale(Boolean.parseBoolean(isMalePresent));
                    }

                    String isCountryPresent = reader.readLine();
                    if (isCountryPresent.equals("yes")){
                        String country = reader.readLine();
                        if (country.equals("UKRAINE")){
                            this.users.get(this.users.size()-1).setCountry(User.Country.UKRAINE);
                        }
                        else if (country.equals("RUSSIA")){
                            this.users.get(this.users.size()-1).setCountry(User.Country.RUSSIA);
                        }
                        else if (country.equals("OTHER")){
                            this.users.get(this.users.size()-1).setCountry(User.Country.OTHER);
                        }
                    }
                }
            }
        }
    }
}
