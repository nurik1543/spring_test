package nursultan.taalaibekov.spring_test.interfaces;

import nursultan.taalaibekov.spring_test.Entities.City;
import nursultan.taalaibekov.spring_test.Entities.Subscriber;

import java.util.List;

public interface IDAOSubscriber {
    int insert(Subscriber subscriber);
    int update(Subscriber subscriber);
    void deleteById(int id);
    void upsert(Subscriber subscriber);
    Subscriber getElementById(int id);
    List<Subscriber> getAllElemtents();
}
