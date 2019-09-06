import java.util.Scanner;

public class Ui {


    public void welcome() {
        System.out.println("Hello I'm Duke \nWhat can I do for you?");
    }

    public void exit () {
        System.out.println("Bye! Hope to see you again soon!");
    }

    public String readCommand() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }
}
