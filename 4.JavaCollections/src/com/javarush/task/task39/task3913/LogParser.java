package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    static DateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
    Path logDir;
    ArrayList<LogLine> logLines = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir)) {
            for (Path file : directoryStream) {
                if (file.toString().toLowerCase().endsWith(".log")) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            logLines.add(new LogLine(line));
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return (int) filterByDate(after, before).map(LogLine::getIp).distinct().count();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return filterByDate(after, before).map(LogLine::getIp).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.getUser().equals(user)).map(LogLine::getIp).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.getEvent().equals(event)).map(LogLine::getIp).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.getStatus().equals(status)).map(LogLine::getIp).collect(Collectors.toSet());
    }

    private Stream<LogLine> filterByDate(Date after, Date before) {
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }
        Date finalBefore = before;
        Date finalAfter = after;
        return logLines.stream().filter(logLine -> logLine.date.before(finalBefore) && logLine.date.after(finalAfter));
    }

    @Override
    public Set<String> getAllUsers() {
        return filterByDate(null, null).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return (int) filterByDate(after, before).map(LogLine::getUser).distinct().count();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return (int) filterByDate(after, before).filter(logLine -> logLine.getUser().equals(user)).map(LogLine::getEvent).distinct().count();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.getIp().equals(ip)).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.LOGIN)).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.DOWNLOAD_PLUGIN)).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.WRITE_MESSAGE)).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.SOLVE_TASK)).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.SOLVE_TASK) && logLine.taskNum == task).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.DONE_TASK)).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return filterByDate(after, before).filter(logLine -> logLine.event.equals(Event.DONE_TASK) && logLine.taskNum == task).map(LogLine::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.getUser().equals(user))
                .filter(logLine -> logLine.event.equals(event))
                .map(LogLine::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.getStatus().equals(Status.FAILED))
                .map(LogLine::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.getStatus().equals(Status.ERROR))
                .map(LogLine::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Optional<Date> min = filterByDate(after, before)
                .filter(logLine -> logLine.getUser().equals(user))
                .filter(logLine -> logLine.event.equals(Event.LOGIN))
                .map(LogLine::getDate)
                .min(Date::compareTo);
        return min.orElse(null);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Optional<Date> min = filterByDate(after, before)
                .filter(logLine -> logLine.getUser().equals(user))
                .filter(logLine -> logLine.event.equals(Event.SOLVE_TASK) && logLine.taskNum == task)
                .map(LogLine::getDate)
                .min(Date::compareTo);
        return min.orElse(null);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Optional<Date> min = filterByDate(after, before)
                .filter(logLine -> logLine.getUser().equals(user))
                .filter(logLine -> logLine.event.equals(Event.DONE_TASK))
                .filter(logLine -> logLine.taskNum == task)
                .map(LogLine::getDate)
                .min(Date::compareTo);
        return min.orElse(null);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.user.equals(user))
                .filter(logLine -> logLine.getEvent().equals(Event.WRITE_MESSAGE))
                .map(LogLine::getDate)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.user.equals(user))
                .filter(logLine -> logLine.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .map(LogLine::getDate)
                .collect(Collectors.toSet());

    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return (int) filterByDate(after, before)
                .map(LogLine::getEvent)
                .distinct()
                .count();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return filterByDate(after, before)
                .map(LogLine::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.ip.equals(ip))
                .map(LogLine::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.getUser().equals(user))
                .map(LogLine::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.status.equals(Status.FAILED))
                .map(LogLine::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.status.equals(Status.ERROR))
                .map(LogLine::getEvent)
                .collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) filterByDate(after, before)
                .filter(logLine -> logLine.event.equals(Event.SOLVE_TASK))
                .filter(logLine -> logLine.getTaskNum() == task)
                .map(LogLine::getEvent)
                .count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) filterByDate(after, before)
                .filter(logLine -> logLine.getTaskNum() == task)
                .filter(logLine -> logLine.event.equals(Event.DONE_TASK))
                .map(LogLine::getEvent)
                .count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.event.equals(Event.SOLVE_TASK))
                .map(logLine -> logLine.taskNum)
                .distinct()
                .collect(Collectors.toMap(taskNum -> taskNum, taskNum -> getNumberOfAttemptToSolveTask(taskNum, after, before)));
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return filterByDate(after, before)
                .filter(logLine -> logLine.event.equals(Event.DONE_TASK))
                .map(logLine -> logLine.taskNum)
                .distinct()
                .collect(Collectors.toMap(taskNum -> taskNum, taskNum -> getNumberOfSuccessfulAttemptToSolveTask(taskNum, after, before)));
    }

    @Override
    public Set<Object> execute(String query) {
        String[] parsedQuery = query.split(" ");
        Stream<LogLine> logStream = logLines.stream();
        Stream<Object> result = null;
        if (parsedQuery.length > 2 && parsedQuery[2].equals("for")) {
            String parameter = getParameter(query);
            logStream = filterByMainCondition(parsedQuery, logStream, parameter);
        }
        if (query.contains("and")) {
            logStream = filterByAuxCondition(query, logStream);
        }
        result = mapLogToObject(parsedQuery, logStream, result);
        return result.collect(Collectors.toSet());
    }

    private static Stream<Object> mapLogToObject(String[] parsedQuery, Stream<LogLine> logStream, Stream<Object> result) {
        switch (parsedQuery[1]) {
            case "ip":
                result = logStream.map(LogLine::getIp);
                break;
            case "user":
                result = logStream.map(LogLine::getUser);
                break;
            case "date":
                result = logStream.map(LogLine::getDate);
                break;
            case "event":
                result = logStream.map(LogLine::getEvent);
                break;
            case "status":
                result = logStream.map(LogLine::getStatus);
                break;
        }
        return result;
    }

    private static Stream<LogLine> filterByAuxCondition(String query, Stream<LogLine> logStream) {
        query = query.substring(query.indexOf("and") + 4);
        String[] dates = query.split("and");
        Date after;
        Date before;
        try {
            Date date1 = simpleDateFormat.parse(dates[0].substring(dates[0].indexOf("\"") + 1, dates[0].lastIndexOf("\"")));
            Date date2 = simpleDateFormat.parse(dates[1].substring(dates[1].indexOf("\"") + 1, dates[1].lastIndexOf("\"")));
            after = (date1.after(date2)) ? date2 : date1;
            before = (date1.before(date2)) ? date2 : date1;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        logStream = logStream.filter(logLine -> logLine.date.after(after) && logLine.date.before(before));
        return logStream;
    }

    private static Stream<LogLine> filterByMainCondition(String[] parsedQuery, Stream<LogLine> logStream, String parameter) {
        switch (parsedQuery[3]) {
            case "ip":
                logStream = logStream.filter(logLine -> logLine.ip.equals(parameter));
                break;
            case "user":
                logStream = logStream.filter(logLine -> logLine.user.equals(parameter));
                break;
            case "date":
                logStream = logStream.filter(logLine -> {
                    try {
                        return logLine.date.equals(simpleDateFormat.parse(parameter));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return false;
                });
                break;
            case "event":
                logStream = logStream.filter(logLine -> logLine.event.equals(Event.valueOf(parameter)));
                break;
            case "status":
                logStream = logStream.filter(logLine -> logLine.status.equals(Status.valueOf(parameter)));
                break;
        }
        return logStream;
    }

    private static String getParameter(String query) {
        String parameter;
        if (query.contains("and")) {
            parameter = query.substring(query.indexOf("\"") + 1, query.lastIndexOf("\" and date")).trim();
        } else {
            parameter = query.substring(query.indexOf("\"") + 1, query.lastIndexOf("\"")).trim();
        }
        return parameter;
    }


    private static class LogLine {
        private final String ip;
        private final String user;
        private final Status status;
        private Event event;
        private int taskNum;
        private Date date;

        public LogLine(String ip, String name, Date date, Event event, Status status) {
            this.ip = ip;
            this.user = name;
            this.date = date;
            this.event = event;
            this.status = status;
        }

        public LogLine(String logLine) {
            String[] splitLine = logLine.split("\t");
            ip = splitLine[0].trim();
            user = splitLine[1].trim();
            try {
                date = simpleDateFormat.parse(splitLine[2].trim());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (splitLine[3].contains(" ")) {
                String[] s = splitLine[3].trim().split(" ");
                event = Event.valueOf(s[0]);
                taskNum = Integer.parseInt(s[1]);
            } else {
                event = Event.valueOf(splitLine[3].trim());
            }
            status = Status.valueOf(splitLine[4].trim());
        }

        public int getTaskNum() {
            return taskNum;
        }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return user;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public Status getStatus() {
            return status;
        }
    }
}