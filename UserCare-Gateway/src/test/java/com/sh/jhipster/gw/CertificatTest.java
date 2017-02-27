package com.sh.jhipster.gw;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

/**
 * Created by Faiziev Shuhrat on 1/24/17.
 */
public class CertificatTest {

    @Test
    public void testString(){
        System.out.println( "pos :" + getfirstrepot("dfs gr ew erw e fwe") );
    }

    private int getfirstrepot(String s){
        for(int i=1; i<s.length()-1;i++) {
            int pos =s.substring(i).indexOf(s.charAt(i-1));
            if (pos>=0 ) return pos+i;

        }
        return -1;
    }

    static int getRandomFrom1MTo1B(){
        Random random= new Random(LocalDateTime.now().getNano());
        return 1000000+random.nextInt();
    }

    private static double getRandom(){
       return 0.3439567211424543 ;
    }

     int getRandom(int min , int max) {
        if (min>max)  throw new IllegalArgumentException("Variable  'min' must be less then 'max'");
        return (int) (min+getRandom()*(max-min));
    }
}
