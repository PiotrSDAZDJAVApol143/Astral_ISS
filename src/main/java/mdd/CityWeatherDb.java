package mdd;

import java.util.HashMap;
import java.util.Map;

public class CityWeatherDb {

    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();

    // TODO: metody do pracy nad bazą danych, dodawanie itp...
    public void add(CityDataEntity entity) {
        dataBase.put(entity.getId(), entity);
    }

}
