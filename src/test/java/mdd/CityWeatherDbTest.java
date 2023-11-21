package mdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CityWeatherDbTest {
    private static final CityWeatherDb cityWeatherDb = new CityWeatherDb();


    @Test
    void addTest() {
        //given
        final CityDataEntity entity = new CityDataEntity();
        entity.setId(1L);
        entity.setName("Warszawa");

        //when
        cityWeatherDb.add(entity);


        //then
     //   Assertions.assertEquals(entity, entity.);
    }

    @Test
    void deleteTest() {
    }

    @Test
    void modify() {
    }
    @Test
    void change() {
        // given
        final long id = 1L;
        final String cityName = "Warsaw";
        final CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        cityWeatherDb.add(cityDataEntity);

        final CityDataEntity changedCityDataEntity = new CityDataEntity();
        changedCityDataEntity.setId(id);
        final String newName = cityName + "AAA";
        changedCityDataEntity.setName(newName);
        // when
        cityWeatherDb.change(changedCityDataEntity);
        // then
        final CityDataEntity result = cityWeatherDb.get(id);
        Assertions.assertEquals(result.getName(), newName);
    }
    @Test
    void should_get_id(){

    }
}