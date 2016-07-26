package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }

    public static class DataAdapter implements RowItem{

        private Customer customer;

        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {

            this.customer = customer;

            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            return countries.get(this.customer.getCountryName());
        }

        @Override
        public String getCompany()
        {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] split = this.contact.getName().split(" ");
            return split[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] split = this.contact.getName().split(", ");
            return split[0];
        }

        @Override
        public String getDialString()
        {
            String s = this.contact.getPhoneNumber();
            String number = "callto://";

            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '+' || s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9'){
                    number += s.charAt(i);
                }
            }

            return number;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}