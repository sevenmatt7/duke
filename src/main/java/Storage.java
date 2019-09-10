import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Storage {

    public Storage (String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        Writer output = new BufferedWriter(fw);
//
        output.close();
    }

}
