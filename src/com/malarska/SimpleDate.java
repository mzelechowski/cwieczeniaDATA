package com.malarska;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class SimpleDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); //timestamp

        SimpleDateFormat dataFormat = new SimpleDateFormat("YYYY.MM.dd  HH:mm:ss w");
        System.out.println(dataFormat.format(date));

        ////// cwiczenie

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss dd.MM.YYYY w");
        Date date1 = new Date();
        System.out.println(dateFormat1.format(date1));
        System.out.printf("%1$tY.%1$tm.%1$td %1$tH:%1$tM:%1$tS", new Date());

        /////////////// format daty

        System.out.printf("Hello %s %d %f %b %n %tc", "Maka Paka", 12, 5.6f, true, new Date());
        System.out.printf("%nHello %s %2$tY.%2$tm.%2$td %2$tH:%2$tM:%2$tS", "World", new Date());

        String str =  String.format("%n %1$tT", new Date());
        System.out.println(str);

        Date date3 = new Date();
        System.out.printf("%1$tY-%1$tm-%1$td", date3);
        System.out.println("");

        //timestamp  - czas w milisekundach
        long timestamp = date.getTime();
        System.out.println(timestamp);
        // stwórz czas z przyszłości za 3 dni 10 godzin i 25 minut
        timestamp+=((3*24+10)*60+25)*60*1000;
        Date date4=new Date(timestamp);
        System.out.println(date4);

        ////////////// Future and Past
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DAY_OF_MONTH,5);
        calendar.add(Calendar.MONTH, 2);
        calendar.add(Calendar.YEAR, 3);
        calendar.add(Calendar.HOUR, 1);
        calendar.add(Calendar.MINUTE, 10);
        calendar.add(Calendar.SECOND, 30);

        Date dateInFuture=calendar.getTime();
        System.out.println(dateInFuture);
        /////// Cwiczenie z kalendarza
        Calendar calendar1=Calendar.getInstance();
        calendar1.add(Calendar.YEAR, 10);
        calendar1.add(Calendar.DAY_OF_MONTH, 3);
        calendar1.add(Calendar.HOUR, 10);
        calendar1.add(Calendar.MINUTE, 25);
        calendar1.add(Calendar.SECOND,6);
        Date dateExercise=calendar1.getTime();
        System.out.println(dateExercise);

        //////////////// LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour()+":"+localTime.getMinute()+":"+ localTime.getSecond());
        localTime=localTime.plusHours(2);
        localTime=localTime.minusMinutes(10);
        localTime=localTime.plusSeconds(40);
        System.out.println(localTime.getHour()+":"+localTime.getMinute()+":"+ localTime.getSecond());
        //////////////////LocalDate
        System.out.println("Funkcja locadDate");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfYear());
        localDate=localDate.plusYears(100);
        localDate=localDate.minusMonths(2);
        localDate=localDate.minusDays(3);
        System.out.println(localDate);

        ///////// LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strData = dateTimeFormatter.format(localDateTime);
        System.out.println(strData);

        ////////////////////// Mierzenie czasu wykonywana fragmentu kodu
        long star=System.currentTimeMillis();
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println(new Date().getTime());
                Thread.sleep(5);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        long timeElapsed=end - star;
        System.out.println("Took time: "+timeElapsed);

        ///////////////////// porównywanie date
        System.out.println(localDate.isAfter(LocalDate.now()));

        /////Local Date Time Exercise
        LocalDateTime local = LocalDateTime.now();
        System.out.println(local);
        LocalDateTime local2=LocalDateTime.of(2030, 12, 10, 22,13,30 );
        if(local2.isAfter(local))
            System.out.println("Data z przyszłosci " + local2);

    }
}
