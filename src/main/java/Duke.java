import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";

        ArrayList<String> taskList = new ArrayList<>(100);
        ArrayList<Boolean> doneList = new ArrayList<>(100);

        String greeting = "Hello I'm Duke \nWhat can I do for you?";
        String goodbye = "Bye. Hope to see you again soon!";
//        System.out.println("Hello from\n" + logo);
        System.out.println(greeting);

        String input = "0";
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (!input.equals("bye")) {  //while the input is not bye
            input = reader.nextLine();

            if (input.equals("bye")) { //terminates the whole program
                break;
            } else if (input.equals("list")) {  //prints out the whole list of tasks
                System.out.println("Here are the tasks in your list: ");
                for (int i = 0; i < taskList.size(); i++) {
                    System.out.print( (i+1) + "." );
                    if (doneList.get(i)) {
                        System.out.print("[✓] ");
                    } else {
                        System.out.print("[X] ");
                    }
                    System.out.print(taskList.get(i) + "\n");
                }
            } else if (input.contains("done")) {   //marks the task specified as done
                int idx = Character.getNumericValue(input.charAt(5));
                doneList.set( (idx-1), true);
            } else {  //adds the task typed out into the list
                taskList.add(input);
                doneList.add(false);
                System.out.println("added: " + input);
            }
        }
        System.out.println(goodbye);
    }

}
