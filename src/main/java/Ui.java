import java.util.Scanner;

public class Ui {

    /**
     * Prints the welcome message for Duke.
     */
    public static void welcome() {
        System.out.println("Hello I'm Duke \nWhat can I do for you?");
    }

    /**
     * Prints the goodbye message for Duke.
     */
    public static void exit () {
        System.out.println("Bye! Hope to see you again soon!");
    }

    /**
     * Reads in the user input.
     */
    public static String readCommand() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
