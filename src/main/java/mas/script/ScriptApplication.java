package mas.script;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScriptApplication {

    public static void main(String[] args) {

        if (args.length != 2) {
            throw new IllegalArgumentException("Exactly 2 arguments required. \nFirst input file. \nSecond output file.");
        }
        String inputFile = args[0];
        String outputFile = args[1];

        List<String> data = new ArrayList<>();
        FileReader reader = new FileReader();
        try {
            data = reader.read(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataTransform transformer = new DataTransform();
        List<String> reverseData = transformer.reverseData(data);
        List<String> timeDifferenceData = transformer.inputAnalyzerFormat(reverseData);

        FileWriter writer = new FileWriter();
        try {
            writer.write(outputFile, timeDifferenceData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
