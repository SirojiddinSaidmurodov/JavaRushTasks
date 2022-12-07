package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String actionParam = args[0];
        switch (actionParam) {
            case "-c":
                String name = args[1];
                Sex sex = (args[2].equals("м")) ? Sex.MALE : Sex.FEMALE;
                allPeople.add((sex.equals(Sex.MALE) ? Person.createMale(name, inputDateFormat.parse(args[3])) : Person.createFemale(name, inputDateFormat.parse(args[3]))));
                System.out.println(allPeople.size() - 1);
                break;
            case "-r":
                Person person = allPeople.get(Integer.parseInt(args[1]));
                if (person != null) {
                    System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + outputDateFormat.format(person.getBirthDate()));
                }
                break;
            case "-u":
                int id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                person.setName(args[2]);
                person.setSex((args[3].equals("м")) ? Sex.MALE : Sex.FEMALE);
                person.setBirthDate(inputDateFormat.parse(args[4]));
                break;
            case "-d":
                id = Integer.parseInt(args[1]);
                Person currentPerson = allPeople.get(id);
                currentPerson.setBirthDate(null);
                currentPerson.setSex(null);
                currentPerson.setName(null);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + actionParam);
        }
    }
}
