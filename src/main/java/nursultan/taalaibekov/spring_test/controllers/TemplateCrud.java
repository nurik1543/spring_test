package nursultan.taalaibekov.spring_test.controllers;

import nursultan.taalaibekov.spring_test.Entities.City;
import nursultan.taalaibekov.spring_test.Entities.Region;
import nursultan.taalaibekov.spring_test.Entities.Subscriber;
import nursultan.taalaibekov.spring_test.interfaces.IDAOCity;
import nursultan.taalaibekov.spring_test.interfaces.IDAORegion;
import nursultan.taalaibekov.spring_test.interfaces.IDAOSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemplateCrud {
    private final String APPLICATION_JSON_VALUE = "application/json";

    @Autowired
    private IDAOCity daoCity;

    @Autowired
    private IDAORegion daoRegion;

    @Autowired
    private IDAOSubscriber daoSub;

    @GetMapping(path="/subscriber/get/{id}", produces = APPLICATION_JSON_VALUE)
    public Subscriber getSub(@PathVariable int id)
    {
        System.out.println("/subscriber/get/" + id);

        return daoSub.getElementById(id);
    }


    @PostMapping(path= "/subscriber/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public int createSub(@RequestBody Subscriber subscriber)
    {
        System.out.println("/subscriber/create: " + subscriber.toString());

        return daoSub.insert(subscriber);
    }

    @PostMapping(path= "/subscriber/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public int updateSub(@RequestBody Subscriber subscriber)
    {
        System.out.println("/subscriber/update: " + subscriber.toString());

        return daoSub.update(subscriber);
    }


    @PostMapping(path= "/region/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public int createRegion(@RequestBody Region region)
    {
        System.out.println("/region/create: " + region.toString());

        return daoRegion.insert(region);
    }

    @PostMapping(path= "/city/create", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public int createCity(@RequestBody City city)
    {
        System.out.println("/city/create: " + city.toString());

        return daoCity.insert(city);
    }

}

