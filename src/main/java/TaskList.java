import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList;

     public TaskList() {
         this.taskList = new ArrayList<Task>();
     }

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

     public static void setDone(String input) {
         int idx = Character.getNumericValue(input.charAt(5)) - 1;
         taskList.get(idx).setDone();
         System.out.println( "Nice! I've marked this task as done:\n\t" + taskList.get(idx).toString());
     }

     public static void addTodo(String input) {
         if (input.length() == 0 ) {
             System.out.println("OOPS!! The description of a todo cannot be empty!");
         } else {
             TodoTask newTask = new TodoTask(input);
             taskList.add(newTask);
             System.out.println("added: " + newTask.toString());
         }
     }

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

     public static void addDeadline(String input) {
         if (input.length() == 0) {
             System.out.println("OOPS!! You did not write the task that needs to be finished by the deadline!");
         } else {
             String[] tokens = input.split("/");
             Deadline newTask = new Deadline(tokens[0], tokens[1].substring(2));
             taskList.add(newTask);
             System.out.println("added: " + newTask.toString());
         }
     }

     public static void deleteTask(int idx) {
         System.out.println( "Noted. I've removed this task:\n\t" + taskList.get(idx).toString());
         taskList.remove(idx);
     }

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
