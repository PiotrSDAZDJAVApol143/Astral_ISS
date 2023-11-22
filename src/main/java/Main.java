import api.CityOwResponse;
import services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "Y" -> {
                    final CityOwResponse weatherFromOW = new WeatherService().getWeatherFromOpenWeather("Warsaw");
                    System.out.println("City name: " + weatherFromOW.getName());
                }
                case "Z" -> {
                    System.out.println("Type a name of City to find");
                    Scanner scannerInputToFind = new Scanner(System.in);
                    String inputUserCityName = scannerInputToFind.nextLine();
                final CityOwResponse weatherFromOW = new WeatherService().getWeatherFromOpenWeather(inputUserCityName);
                String message = """
                        City weather data from [%s]
                        - city name:    [%s]
                        - wind speed:   [%s]
                        - temp:         [%s]
                        - pressure:     [%s]
                        """.formatted(weatherFromOW.getDt(),
                        weatherFromOW.getName(),
                        weatherFromOW.getWind(),
                        weatherFromOW.getMain().getTemp(),
                        weatherFromOW.getMain().getPressure()
                        );
                    System.out.println(message);
                }
                default -> System.out.println("ERROR!!! INVALID INPUT");
            }
        }
    }

    private static boolean showWelcomeMenu(boolean isFirstRun) {
        if (isFirstRun) {
            System.out.println("""
                    ----------------------
                    WELCOME!
                    type X to quit
                    type Y to get a weather stats
                    type Z to show what City you want to find
                    ----------------------
                    """);
            isFirstRun = false;
        }
        return isFirstRun;
    }
}