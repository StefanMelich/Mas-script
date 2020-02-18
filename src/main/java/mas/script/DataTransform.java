package mas.script;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DataTransform {

    private final TimeParser parser;

    public DataTransform() {
        this.parser = new TimeParser();
    }

    public List<String> reverseData(List<String> data) {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(iterator.apply(data), Spliterator.ORDERED), false)
                .collect(Collectors.toList());
    }

    private Function<List<String>, Iterator<String>> iterator =
            (data) -> new LinkedList<>(data).descendingIterator();

    public List<String> inputAnalyzerFormat(List<String> data) {
        return data
                .stream()
                .map(removeFirstAndLastColumn::apply)
                .map(parser.timeInSeconds::apply)
                .collect(Collectors.toList());
    }

    private static Function<String, String> removeFirstColumn =
            s -> s.replaceAll("^(.*?)\\t", "");
    private static Function<String, String> removeLastColumn =
            s -> s.replaceAll("\\t.*$", "");
    private static Function<String, String> removeFirstAndLastColumn =
            removeFirstColumn.andThen(removeLastColumn);
}
