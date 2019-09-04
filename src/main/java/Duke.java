import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.ArrayList;


public class Duke {
//    private Storage storage;
//    private TaskList tasks;
//    private Ui ui;
//
//    public Duke(String filePath) {  //constructor for the Duke Object
//        ui = new Ui();
//        storage = new Storage(filePath);
//        try {
//            tasks = new TaskList(storage.load());
//        } catch (DukeException e) {
//            ui.showLoadingError();
//            tasks = new TaskList();
//        }
//    }
//
//    public void run() {
//        //...
//    }
//
//    public static void main(String[] args) {
//        new Duke("Tasks.txt").run();
//    }
//}


    public static void main(String[] args) throws IOException {
        ArrayList<Task> taskList = new ArrayList<Task>();

        String greeting = "Hello I'm Duke \nWhat can I do for you?";
        String goodbye = "Bye. Hope to see you again soon!";
        System.out.println(greeting);
        String input = "0";
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (!input.equals("bye")) {  //while the input is not bye
            input = reader.nextLine();
            FileWriter fw = new FileWriter("Tasks.txt");
            Writer output = new BufferedWriter(fw);
            for (Task task : taskList) {
                output.write(task.toString() + "\n");
            }
            output.close();

            if (input.equals("bye")) { //terminates the whole program
                break;
            } else if (input.equals("list")) {  //prints out the whole list of tasks
                if (taskList.isEmpty()) {
                    System.out.println("You have no tasks in your current list.");
                } else {
                    System.out.println("Here are the tasks in your list: ");
                    int idx = 1;
                    for (Task task : taskList) {
                        System.out.println(idx + ". " + task.toString());
                        idx += 1;
                    }
                }
            } else if (input.contains("done")) {   //marks the task specified as done
                int idx = Character.getNumericValue(input.charAt(5)) - 1;
                taskList.get(idx).setDone();
                System.out.println( "Nice! I've marked this task as done:\n\t" + taskList.get(idx).toString());
            } else {  //adds the task typed out into the list
                if (input.startsWith("todo")){
                    if (input.length() == 4 ) {
                        System.out.println("OOPS!! The description of a todo cannot be empty!");
                    } else {
                        TodoTask newTask = new TodoTask(input.substring(5));
                        taskList.add(newTask);
                        System.out.println("added: " + newTask.toString());
                    }
//                } else if (input.startsWith("deadline")) {
//                    String data = input.substring(9);
//                    String[] tokens =  data.split("/by");
//                    Deadline newTask = new Deadline(tokens[0], tokens[1]);
//                    taskList.add(newTask);
//                    System.out.println("added: " + newTask.toString());
                } else if (input.startsWith("event")) {
                    if (input.length() == 5) {
                        System.out.println("OOPS!! You did not write down the activity for the event!");
                    } else {
                        String data = input.substring(6);
                        String[] tokens = data.split("/");
                        Event newTask = new Event(tokens[0], tokens[1].substring(2));
                        taskList.add(newTask);
                        System.out.println("added: " + newTask.toString());
                    }
                } else if (input.startsWith("delete")) {
                    int idx = Character.getNumericValue(input.charAt(7)) - 1;
                    System.out.println( "Noted. I've removed this task:\n\t" + taskList.get(idx).toString());
                    taskList.remove(idx);
                } else if (input.startsWith("find")) { //finds the tasks containing the search word
                    ArrayList<String> foundList = new ArrayList<String>();
                    String searchTerm = input.substring(5);
                    int idx = 1;
                    for (Task task : taskList) {
                        if (task.toString().contains(searchTerm)) {
                            foundList.add(task.toString());
                        }
                    }
                    if (foundList.isEmpty()) {
                        System.out.println("I could not find any matching tasks.");
                    } else {
                        System.out.println("Here are the matching tasks in your list:\n");
                        for (String str : foundList) {
                            System.out.println(idx + ". " + str);
                            idx += 1;
                        }
                    }
                } else {
                    System.out.println("OOPS!! I don't know what that means!");
                }
            }
        }
        System.out.println(goodbye);
    }

}
