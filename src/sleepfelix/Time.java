/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepfelix;
import java.util.regex.*;  

/**
 *
 * @author k3vin
 */
public class Time {
    private int hour;
    private int minute;
    private int seconds;
    
    public Time(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
    }
    
    public Time(String currentTime){
        String[] time = currentTime.split(":");
        hour = Integer.parseInt(time[0]);
        minute = Integer.parseInt(time[1]);
        seconds = Integer.parseInt(time[2]);
                
    }
    
    public String getCurrentTime(){
    return hour + ":" + minute + ":" + seconds;
    }
    
    public void oneSecondPassed(){
        seconds++;
         if(seconds == 60){
        } else {
            minute++;
            seconds = 0;
            if(minute == 60){
                hour++;
                minute = 0;
                if(hour == 24){
                    hour = 0;
                    System.out.println("Next Day");
                }
            }
        }
    }
}

