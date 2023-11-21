import api.CityOwResponse;
import api.HttpClientService;
import services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            if (isFirstRun) {
                System.out.println("""
                        ----------------------
                        WELCOME!
                        type X to quit
                        type Y to get a weather stats
                        ----------------------
                        """);
                isFirstRun = false;
            }

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "Y" -> {
                    final CityOwResponse weatherFromOW = new WeatherService().getWeatherFromOpenWeather();
                    System.out.println("City name: " + weatherFromOW.getName());
                }
                default -> System.out.println("ERROR!!! INVALID INPUT");
            }
        }
    }
}