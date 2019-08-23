import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";

        ArrayList<String> taskList = new ArrayList<>();
        String greeting = "Hello I'm Duke \nWhat can I do for you?";
        String goodbye = "Bye. Hope to see you again soon!";
//        System.out.println("Hello from\n" + logo);
        System.out.println(greeting);

        String input = "0";
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (!input.equals("bye")) {
            input = reader.nextLine();

            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.println( (i+1) + ". " + taskList.get(i) );
                }
            } else {
                taskList.add(input);
                System.out.println("added: " + input);
            }

        }
        System.out.println(goodbye);
    }

}
