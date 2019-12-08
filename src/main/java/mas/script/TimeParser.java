package mas.script;

public class TimeParser {

    public String timeInSeconds(final String time) {
        return this.stringToTime(time).toSeconds();
    }
    
    private Time stringToTime(final String time) {
        if (time == null)
            throw new IllegalArgumentException("Argument is null");

        final String[] timeParts = time.split(":");
        final String[] secondsAndHundredth = timeParts[2].split("\\.");
        final int hours = Integer.parseInt(timeParts[0]);
        final int minutes = Integer.parseInt(timeParts[1]);
        final int seconds = Integer.parseInt(secondsAndHundredth[0]);
        final int hundredth = Integer.parseInt(secondsAndHundredth[1]);
        return new Time(hours, minutes, seconds, hundredth);
    }
}
