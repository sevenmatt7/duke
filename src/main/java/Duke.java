import java.io.IOException;
import java.text.ParseException;

/**
 * The Duke program implements an application that
 * acts as a personal assistant with the ability to
 * store tasks in a list that is kept as a text file
 *
 * @author  Matthew Nathanael Sugiri
 * @version 1.0
 * @since   2019-08-21
 */
public class Duke {
    public static boolean isExit = false;
    private Storage storage;
    private static TaskList tasks;
    private Ui ui;

    /**
     * Constructor for the duke class.
     */
    public Duke() {
        ui = new Ui();
        tasks = new TaskList();
    }

    public static void setExit() {
        isExit = true;
    }

    /**
     * This method is used to run the Duke program.
     * @param filePath This is the string which is the path to the .txt file where the
     *                 list of tasks are stored in.
     * @param tasks  This is the where the list of tasks are stored, the class has a private
     *               ArrayList of tasks.
     * @return  Nothing
     */
    public void run (String filePath, TaskList tasks) throws IOException, ParseException {
        Ui.welcome();
        while(!isExit) {
            String userInput = Ui.readCommand();
            Parser.interpretCommand(userInput);
            TaskList.writetoFile(filePath, Duke.tasks);
        }
        TaskList.writetoFile(filePath, Duke.tasks);
        Ui.exit();
    }

    /**
     * This is the main method which makes use of run method.
     * @param args Unused.
     * @return Nothing.
     * @exception IOException On input error.
     * @see IOException
     */
    public static void main(String[] args) throws IOException, ParseException {
        new Duke().run("Tasks.txt", tasks);
    }

}
