public class Event extends Task {
    private String location;

    public Event(String description, String location) {
        super(description);
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("[E]%s(at:%s)", super.toString(), location);
    }

    @Override
    public String formatString() {
        return String.format(
                "E|%s|%s", super.formatString(), location);
    }
}
