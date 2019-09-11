import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/yyyy HHmm");

    private Date dateTime;

    public Deadline(String description, String date_string) throws ParseException {
        super(description);
        try {
            this.dateTime = dateFormatter.parse(date_string);
        }
        catch (Exception e)  {
            System.out.println("Wrong date format. Please write it in the format dd/mm/yy HHmm");
            String correctInput = Ui.readCommand();
            this.dateTime = dateFormatter.parse(correctInput);
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
