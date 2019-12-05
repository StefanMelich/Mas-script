package mas.script;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileWriter {

    public void write(String path, List<String> list) throws IOException {
        Files.write(Paths.get(path), list);
    }

}
