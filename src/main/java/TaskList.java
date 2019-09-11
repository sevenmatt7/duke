import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList;

    /**
     * Constructor for TaskList class
     * @param Nothing
     */
     public TaskList() {
         this.taskList = new ArrayList<Task>();
     }

    /**
     * Write the current tasks in the ArrayList of Tasks to the .txt file.
     * @param filePath The string specifying the path to the .txt file.
     * @param tasks The ArrayList of Tasks
     */
    public static void writetoFile (String filePath, TaskList tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        Writer output = new BufferedWriter(fw);
        for (Task task : taskList) {
            output.write(task.toString() + "\n");
        }
        output.close();
    }

    /**
     * Prints out the list of tasks in the ArrayList in a specified format.
     * @param Nothing
     */
     public static void getList() {
         if (taskList.isEmpty()) {
             System.out.println("You have no tasks in your list.");
         } else {
             System.out.println("Here are the tasks in your list: ");
             int idx = 1;
             for (Task task : taskList) {
                 System.out.println(idx + ". " + task.toString());
                 idx += 1;
             }
         }
     }

    /**
     * Marks a specified Task in the list of tasks as done
     * @param input Specifies which task in the ArrayList to be marked as done.
     */
     public static void setDone(String input) {
         int idx = Character.getNumericValue(input.charAt(5)) - 1;
         taskList.get(idx).setDone();
         System.out.println( "Nice! I've marked this task as done:\n\t" + taskList.get(idx).toString());
     }

    /**
     * Adds a TodoTask to the list of tasks. If the description is empty,
     * it will prompt the user to enter the description.
     * @param input It contains the description of the TodoTask.
     */
     public static void addTodo(String input) {
         if (input.length() == 0 ) {
             System.out.println("OOPS!! The description of a todo cannot be empty!");
         } else {
             TodoTask newTask = new TodoTask(input);
             taskList.add(newTask);
             System.out.println("added: " + newTask.toString());
         }
     }

    /**
     * Adds an Event to the list of tasks. If the description is empty,
     * it will prompt the user to enter the description.
     * @param input It contains the description of the Event.
     */
     public static void addEvent(String input) {
         if (input.length() == 0) {
             System.out.println("OOPS!! You did not write down the activity for the event!");
         } else {
             String[] tokens = input.split("/");
             Event newTask = new Event(tokens[0], tokens[1].substring(2));
             taskList.add(newTask);
             System.out.println("added: " + newTask.toString());
         }
     }

    /**
     * Adds a Deadline to the list of tasks. If the description is empty,
     * it will prompt the user to enter the description.
     * @param input It contains the description of the task that has a deadline.
     */
     public static void addDeadline(String input) throws ParseException {
         if (input.length() == 0) {
             System.out.println("OOPS!! You did not write the task that needs to be finished by the deadline!");
         } else {
             String[] tokens = input.split("/by");
             Deadline newTask = new Deadline(tokens[0], tokens[1]);
             taskList.add(newTask);
             System.out.println("added: " + newTask.toString());
         }
     }

    /**
     * Deletes a specified Task in the list of tasks.
     * @param idx Specifies which task in the ArrayList to be deleted.
     */
     public static void deleteTask(int idx) {
         System.out.println( "Noted. I've removed this task:\n\t" + taskList.get(idx).toString());
         taskList.remove(idx);
     }


    /**
     * It prints out the list of tasks that has a substring that matches to the
     * specified search term given by the user.
     * @param searchTerm Specifies the substring to be found in the task description.
     */
     public static void getFoundlist(String searchTerm) {
         ArrayList<String> foundList = new ArrayList<String>();
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
     }

}
