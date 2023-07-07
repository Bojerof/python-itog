public class Toys {
    private String id;
    private String name;
    private String count;

    public Toys(String name, String count) {
        this.name = name;
        this.count = count;
    }
    public Toys(String id, String name, String count){
        this(name, count);
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setCount(String count) {
        this.count = count;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }


    @Override
    public String toString() {
        return String.format("Id - %d, Name - %s, count - %d", id, name, count);
    }
}
