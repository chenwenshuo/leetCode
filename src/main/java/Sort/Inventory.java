package Sort;


import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Inventory {
    private Date start;
    private Date end;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public Inventory(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    public Inventory(String start, String end) throws ParseException {
        this.start = simpleDateFormat.parse(start);
        this.end = simpleDateFormat.parse(end);
    }
}
