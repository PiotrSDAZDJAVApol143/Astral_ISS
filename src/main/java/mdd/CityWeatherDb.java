package mdd;

import java.util.HashMap;
import java.util.Map;

public class CityWeatherDb {

    private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();

    // TODO: metody do pracy nad bazą danych, dodawanie itp...
    public void add(CityDataEntity entity) {
        dataBase.put(entity.getId(), entity);
    }
    public CityDataEntity get(Long id) {
        return dataBase.get(id);
    }

    public boolean delete(CityDataEntity entity) {
        return dataBase.remove(entity.getId(), entity);
    }

    public CityDataEntity modify(CityDataEntity entity, String name, WeatherDataEntity weatherDataEntity) {
        return dataBase.computeIfPresent(entity.getId(), (id, existingEntity) -> {
            existingEntity.setName(name);
            existingEntity.setWeatherDataEntity(weatherDataEntity);
           return existingEntity;
       });
    }
  public CityDataEntity change(CityDataEntity entity) {
      // wyszukac po id ? jak wyciągamy obiekt po kluczu?
      final CityDataEntity toChange = dataBase.get(entity.getId());
      // zmodyfikowac jego pola (settery)
      toChange.setName(entity.getName());
      toChange.setWeatherDataEntity(entity.getWeatherDataEntity());
      // zapisać ponownie do mapy ? jak dodajemy po kluczu bwartość
      return dataBase.put(entity.getId(), toChange);
  }
}
