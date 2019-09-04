import java.util.Scanner;
import java.util.ArrayList;


public class Duke {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<Task>(100);

        String greeting = "Hello I'm Duke \nWhat can I do for you?";
        String goodbye = "Bye. Hope to see you again soon!";
        System.out.println(greeting);
        String input = "0";
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (!input.equals("bye")) {  //while the input is not bye
            input = reader.nextLine();

            if (input.equals("bye")) { //terminates the whole program
                break;
            } else if (input.equals("list")) {  //prints out the whole list of tasks
                System.out.println("Here are the tasks in your list: ");
                int idx = 1;
                for (Task task : taskList) {
                    System.out.println(idx + ". " + task.toString());
                    idx += 1;
                }
            } else if (input.contains("done")) {   //marks the task specified as done
                int idx = Character.getNumericValue(input.charAt(5)) - 1;
                taskList.get(idx).setDone();
                System.out.println( "Nice! I've marked this task as done:\n\t" + taskList.get(idx).toString());
            } else {  //adds the task typed out into the list
                if (input.startsWith("todo")){
                    TodoTask newTask = new TodoTask(input.substring(5));
                    taskList.add(newTask);
                    System.out.println("added: " + newTask.toString());
//                } else if (input.startsWith("deadline")) {
//                    String data = input.substring(9);
//                    String[] tokens =  data.split("/by");
//                    Deadline newTask = new Deadline(tokens[0], tokens[1]);
//                    taskList.add(newTask);
//                    System.out.println("added: " + newTask.toString());
                } else if (input.startsWith("event")) {
                    String data = input.substring(6);
                    String[] tokens = data.split("/");
                    Event newTask = new Event(tokens[0], tokens[1].substring(2));
                    taskList.add(newTask);
                    System.out.println("added: " + newTask.toString());
                }
            }
        }
        System.out.println(goodbye);
    }

}
