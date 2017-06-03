package tmp;

import java.util.Calendar;
import java.util.Date;

public class LosoweDaty {
    public static void main(String[] args) {
        Date ddd = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(ddd);
        cal.add(Calendar.DATE, -30);
        Date dateBefore30Days = cal.getTime();
        System.out.println(dateBefore30Days);
    }
}
