package nursultan.taalaibekov.spring_test.Entities;

import java.io.Serializable;

public class Subscriber {
    private int id;
    private String surname;
    private String name;
    private String phone;
    private int regionId;
    private int cityId;

    public Subscriber() {}

    public Subscriber(int id, String surname, String name, String phone, int regionId, int cityId) {
        super();
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.regionId = regionId;
        this.cityId = cityId;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return String.format("id: %d, surname: %s, name: %s, phone %s, regionId %d, cityId %d", id, surname, name, phone, regionId, cityId);
    }



}
