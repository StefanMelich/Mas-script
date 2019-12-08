package mas.script;

final class Time {

    private final int hours;
    private final int minutes;
    private final int seconds;
    private final int hundredth;

    public Time(final int hours, final int minutes, final int seconds, final int hundredth) {
        validate(hours, 23, "Hours can't be bigger than 23 !");
        validate(minutes, 59, "Minutes can't be bigger than 59 !");
        validate(seconds, 59, "Seconds can't be bigger than 59 !");
        validate(hundredth, 99, "Hundredth can't be bigger than 99 !");

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.hundredth = hundredth;
    }

    public String toSeconds() {
        return new StringBuilder()
                .append(getInSeconds())
                .append(".")
                .append(hundredthToString())
                .toString();
    }

    private int hoursToMinutes(final int hours) {
        return hours * 60;
    }

    private int minutesToSeconds(final int minutes) {
        return minutes * 60;
    }

    private int getInSeconds() {
        final int minutes = this.minutes + hoursToMinutes(this.hours);
        final int seconds = this.seconds + minutesToSeconds(minutes);
        return seconds;
    }

    private String hundredthToString() {
        if (this.hundredth < 10)
            return "0" + this.hundredth;
        return Integer.toString(this.hundredth);
    }

    private void validate(int actualValue, int maxValue, String message) {
        if (actualValue > maxValue)
            throw new IllegalArgumentException(message);
    }

}
