import java.util.Scanner;

public class Ui {


    public static void welcome() {
        System.out.println("Hello I'm Duke \nWhat can I do for you?");
    }

    public static void exit () {
        System.out.println("Bye! Hope to see you again soon!");
    }

    public static String readCommand() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
