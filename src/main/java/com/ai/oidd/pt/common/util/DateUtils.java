package com.ai.oidd.pt.common.util;

import com.ai.oidd.pt.common.Constants;
import org.joda.time.DateTime;

import java.util.Calendar;

/**
 * Asiainfo-OIDD
 *
 * @author sunbin-71738
 * @date 2018-04-10
 */
public class DateUtils {


    public static int getToday() {
        Calendar calendar = Calendar.getInstance();
        DateTime dateTime = new DateTime(calendar);
        String date = dateTime.toString(Constants.SHORT_DATE_FORMAT);

        return Integer.valueOf(date);
    }

}
