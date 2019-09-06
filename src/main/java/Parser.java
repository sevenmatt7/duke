import java.util.ArrayList;

public class Parser {

    public void interpretCommand(String input) {
        if (input.equals("bye")) {  //terminates the program
            Duke.setExit();
        } else if (input.equals("list")) {  //prints out the whole list of tasks
            TaskList.getList();
        } else if (input.startsWith("done")) {   //marks the task specified as done
            TaskList.setDone();
        } else if (input.startsWith("todo")) {
            String todoTask = input.substring(5); //5th character is when the actual task is specified
            TaskList.addTodo(todoTask);
        } else if (input.startsWith("event")) {
            String eventActivity = input.substring(6); //6th character is when the actual event is specified
            TaskList.addEvent(eventActivity);
        } else if (input.startsWith("deadline")) {
            String deadlineTask = input.substring(9);
            String[] tokens = deadlineTask.split("/by");
        } else if (input.startsWith("delete")) {
            int idx = Character.getNumericValue(input.charAt(7)) - 1;
            TaskList.deleteTask(idx);
        } else if (input.startsWith("find")) {
            String searchTerm = input.substring(5);
            TaskList.getFoundlist();
        } else {
            System.out.println("OOPS! I don't know what that means!");
        }
    }

}
