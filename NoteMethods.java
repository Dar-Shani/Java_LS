package Java_Core_LS_1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NoteMethods {
    
    public String dataTime() {
        //LocalDateTime time = LocalDateTime.now();
        String time = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a").format(LocalDateTime.now());
        return time;
    }
    
}