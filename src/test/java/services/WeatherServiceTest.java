package services;

import api.CityOwResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void getWeatherFromOpenWeather() {
        //given
        final String cityNameToFind = "Warsaw";
        final var weatherService =new WeatherService();

        //when
        final CityOwResponse response = weatherService.getWeatherFromOpenWeather(cityNameToFind);
        //then
        final String resultCityName = response.getName();
        Assertions.assertEquals(resultCityName,cityNameToFind);

    }
}