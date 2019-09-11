import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/yyyy HHmm");

    private Date dateTime;

    public Deadline(String description, String date_string) {
        super(description);
        try {
            //The code you are trying to exception handle
            this.dateTime = dateFormatter.parse(date_string);
        }
        catch (Exception e) {
            //The handling for the code
            System.out.println("Wrong date format.");
        }

    }

    @Override
    public String toString() {
        return String.format("[D]%s(by: %s)", super.toString(), dateFormatter.format(dateTime));
    }


    @Override
    public String formatString() {
        return String.format(
                "D|%s|%s", super.formatString(), dateFormatter.format(dateTime));
    }

}
