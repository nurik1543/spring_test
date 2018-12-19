package nursultan.taalaibekov.spring_test.interfaces;

import nursultan.taalaibekov.spring_test.Entities.RoutineTemplate;

import java.util.List;

public interface IDAOTemplate {
    void insert(RoutineTemplate template);
    void deleteById(int id);
    void update(RoutineTemplate template);
    void upsert(RoutineTemplate routineTemplate);
    RoutineTemplate getElementById(int id);
    List<RoutineTemplate> getAllElemtents();
}
