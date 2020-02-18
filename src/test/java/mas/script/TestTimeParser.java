package mas.script;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTimeParser {

    @Test
    void time_from_string() {
//       // Arrange
//        final Time expected = new Time(0,0,6,62);
//
//        // Act
//        final TimeParser parser = new TimeParser();
//        final Time actual = parser.timeInSeconds("00:00:06.62");
//
//        // Assert
//        Assertions.assertEquals(expected.toSeconds(), actual.toSeconds());
    }

    @Test
    void null_parameter_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new TimeParser().timeInSeconds.apply(null));
    }
}
