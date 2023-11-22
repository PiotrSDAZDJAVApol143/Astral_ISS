package services;

import api.CityOwResponse;
import api.HttpClientService;

public class WeatherService {

    public CityOwResponse getWeatherFromOpenWeather(String cityName) {
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
        String appIDQuery = "appid=716238e6166ce6e1315daf3232959cd3&";
        String cityQuery = "q=" + cityName;
        String unitQuery = "&units=metric";
       // String openWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3&q=Warsaw&units=metric";
String openWeatherUrl = baseUrl+appIDQuery+cityQuery+unitQuery;
        var httpClientService = new HttpClientService<CityOwResponse>();
        final CityOwResponse response = httpClientService.getWeather(openWeatherUrl, CityOwResponse.class);

        return response;
    }

}
