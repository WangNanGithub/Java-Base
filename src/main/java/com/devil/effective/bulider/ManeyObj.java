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
public class ManeyObj {
    private final Date birthDate;

    public ManeyObj() {
        birthDate = new Date();
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isBaby() {
        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(14946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmt.getTime();
        gmt.set(1964, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmt.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

}
