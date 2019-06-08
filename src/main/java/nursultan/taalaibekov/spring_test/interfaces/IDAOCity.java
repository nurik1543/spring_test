package nursultan.taalaibekov.spring_test.interfaces;

import nursultan.taalaibekov.spring_test.Entities.City;

import java.util.List;

public interface IDAOCity {
    int insert(City city);
    void deleteById(int id);
    void update(City city);
    void upsert(City city);
    City getElementById(int id);
    List<City> getAllElemtents();
}
