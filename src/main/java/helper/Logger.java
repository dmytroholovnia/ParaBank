package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public void log(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String time = sdf.format(new Date());
        System.out.println(time + " " + message);
    }
}
