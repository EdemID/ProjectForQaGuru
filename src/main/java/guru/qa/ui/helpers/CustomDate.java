package guru.qa.ui.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDate {

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String calendarToString(Calendar cal){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        return simpleDateFormat.format(cal.getTime());
    }
}
