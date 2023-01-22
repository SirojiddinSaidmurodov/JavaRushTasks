package com.javarush.task.task39.task3913;

import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\siroj\\IdeaProjects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Vasya Pupkin",null,null));
        System.out.println(logParser.getUniqueIPs( null,null));
        System.out.println(logParser.getIPsForEvent(Event.LOGIN,null,null));
        System.out.println(logParser.getDateWhenUserDoneTask("Vasya Pupkin",15,null,null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null,null));
//        System.out.println(logParser.execute("get ip for user = \"Amigo\""));
        System.out.println(logParser.execute("get ip for user = \"Amigo\" and date between \"30.08.2011 16:08:13\" and \"03.01.2022 23:59:59\""));
    }
}