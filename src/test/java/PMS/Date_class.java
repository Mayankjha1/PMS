package PMS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_class {

    public static String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        Date date = new Date();
        return formatter.format(date);
    }
}

