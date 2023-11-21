package api;

import java.time.LocalDateTime;

public class CityOwResponse {
    private Wind wind;
    private Main main;
    private String name;
    private LocalDateTime dt;

    public CityOwResponse(Wind wind, Main main, String name, LocalDateTime dt) {
        this.wind = wind;
        this.main = main;
        this.name = name;
        this.dt = dt;
    }

    public Wind getWind() {
        return wind;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDt() {
        return dt;
    }
}