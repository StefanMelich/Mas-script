package mas.script;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DataTransform {

    private final TimeParser parser;

    public DataTransform() {
        // not necessary DI
        this.parser = new TimeParser();
    }

    public List<String> reverseData(List<String> data) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(descendingIterator(data), Spliterator.ORDERED), false)
                .collect(Collectors.toList());
    }

    private Iterator<String> descendingIterator(List<String> data) {
        return new LinkedList<>(data).descendingIterator();
    }

    public List<String> inputAnalyzerFormat(List<String> data) {
        return data
                .stream()
                .map(s -> s.replaceAll("^(.*?)\\t", ""))
                .map(s -> s.replaceAll("\\t.*$", ""))
                // below map: converts string time to Time, toSeconds return time in seconds
                .map(time -> parser.timeInSeconds(time))
                .collect(Collectors.toList());
    }

}
