package clases;

import java.sql.Date;
import java.util.Calendar;

public class Auxiliar {

    public static boolean IsNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Date SQLDate(Calendar cal) {
        int d, m, a;
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        return new Date(a, m, d);
    }

}
