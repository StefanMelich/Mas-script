package mas.script;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DataTransform {

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
                .collect(Collectors.toList());
    }

}
