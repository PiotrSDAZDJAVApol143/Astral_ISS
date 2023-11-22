package mdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class CityWeatherDbTest {
    private static final CityWeatherDb dataBase = new CityWeatherDb();

    @Test
    void should_change_entity() {
        // given
        final long id = 1L;
        final String cityName = "Warsaw";
        final CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);

        final CityDataEntity changedCityDataEntity = new CityDataEntity();
        changedCityDataEntity.setId(id);
        final String newName = cityName + "AAA";
        changedCityDataEntity.setName(newName);
        // when
        dataBase.change(changedCityDataEntity);
        // then
        final Optional<CityDataEntity> resultOpt = dataBase.get(id);
        final String name = resultOpt.orElseThrow().getName();
        Assertions.assertEquals(name, newName);
    }

    @Test
    void should_get_entity_by_id() {
        // given
        final long id = 1L;
        final String cityName = "Warsaw";
        final CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setId(id);
        cityDataEntity.setName(cityName);
        dataBase.add(cityDataEntity);
        // when
        final CityDataEntity result = dataBase.get(id).orElseThrow();
        // then
        Assertions.assertEquals(result.getName(), cityName);
    }

  //  @Test
 //  void should_delete_an_element_from_database() {
 //      // given
 //      final long id = createAndAddUser(1L, "Warszawa");
 //      // when
 //      dataBase.delete(id);
 //      // then
 //      final var resultOpt = dataBase.get(id);
 //      final boolean isPresent = resultOpt.isPresent();
 //      Assertions.assertFalse(isPresent);
 //  }

  // private static long createAndAddUser(Long id, String cityName) {
  //     final CityDataEntity cityDataEntity = new CityDataEntity();
  //     cityDataEntity.setId(id);
  //     cityDataEntity.setName(cityName);
  //     final CityDataEntity add = dataBase.add(cityDataEntity);
  //     return id;
   // }

}