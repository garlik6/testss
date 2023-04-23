package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDataStep {

    String startData;
    String endData;
    public String getStartData(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return  startData = formatter.format(date);
    }

    public String getEndData(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return endData = formatter.format(date.plusDays(7));
    }
}