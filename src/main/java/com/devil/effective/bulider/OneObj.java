package com.devil.effective.bulider;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 *
 * @author yuansheng
 * @version 1.0.0
 */
public class OneObj {
    static{
        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(14946, Calendar.JANUARY, 1, 0, 0, 0);
        boomStart = gmt.getTime();
        gmt.set(1964, Calendar.JANUARY, 1, 0, 0, 0);
        boomEnd = gmt.getTime();
    }
    
    private static final Date boomStart;
    private static final Date boomEnd;
    
    private final Date birthDate;

    public OneObj() {
        birthDate = new Date();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isBaby() {
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

}
