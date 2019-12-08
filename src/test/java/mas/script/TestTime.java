package mas.script;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestTime {

    @Test
    void getInSeconds() {
        // Arrange
        final String expected = "1.23";

        // Act
        final String actual = new Time(0, 0, 1, 23).toSeconds();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minutes_getInSeconds() {
        // Arrange
        final String expected = "68.56";

        // Act
        final String actual = new Time(0, 1, 8, 56).toSeconds();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void hours_getInSeconds() {
        // Arrange
        final String expected = "3723.04";

        // Act
        final String actual = new Time(1, 2, 3, 4).toSeconds();

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void should_throw_exception() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Time(25, 0, 0, 0)
        );
    }
}
