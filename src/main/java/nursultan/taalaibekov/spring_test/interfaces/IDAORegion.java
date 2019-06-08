package nursultan.taalaibekov.spring_test.interfaces;

import nursultan.taalaibekov.spring_test.Entities.City;
import nursultan.taalaibekov.spring_test.Entities.Region;

import java.util.List;

public interface IDAORegion {
    int insert(Region region);
    void deleteById(int id);
    void update(Region region);
    void upsert(Region region);
    City getElementById(int id);
    List<Region> getAllElemtents();
}
