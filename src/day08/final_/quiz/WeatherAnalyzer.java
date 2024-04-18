package day08.final_.quiz;

import static day08.final_.quiz.WeatherConstants.*;

public class WeatherAnalyzer {
    static boolean checkTemperatureAlert(double temperature) {
        return (temperature > MAX_TEMPERATURE_ALERT || temperature < MIN_TEMPERATURE_ALERT);
    }
    static boolean checkPrecipitationAlert(double precipitation) {
        return precipitation > PRECIPITATION_ALERT;
    }
}
