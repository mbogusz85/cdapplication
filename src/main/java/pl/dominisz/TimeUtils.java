package pl.dominisz;

/**
 * http://dominisz.pl
 * 08.01.2018
 */
public class TimeUtils {

    public static String format(int time) {
        int hours = time / 3600;
        int minutes = (time - hours * 3600) / 60;
        int seconds = time % 60;

        if (hours > 0) {
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d", minutes, seconds);
        }
    }

}
