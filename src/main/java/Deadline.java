import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d/M/yyyy HHmm");

    private Date dateTime;

    public Deadline(String description, Date dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return String.format("[D]%s(by: %s)", super.toString(), DATE_FORMAT.format(dateTime));
    }


    @Override
    public String formatString() {
        return String.format(
                "D|%s|%s", super.formatString(), DATE_FORMAT.format(dateTime));
    }

}
