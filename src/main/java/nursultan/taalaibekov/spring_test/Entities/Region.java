package nursultan.taalaibekov.spring_test.Entities;

public class Region {
    private int id;
    private String name;

    public Region() {}
    public Region(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("id: %d, name: %s", id, name);
    }
}
