import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String greeting = "Hello I'm Duke \nWhat can I do for you?";
        String endSentence = "Bye. Hope to see you again soon!";
//        System.out.println("Hello from\n" + logo);
        System.out.println(greeting);

        String input = "0";
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        while (!input.equals("bye")) {
            input = reader.nextLine();
            if (input.equals("bye")) {
                break;
            }
            System.out.println(input);
        }
        System.out.println(endSentence);
    }

}
