import java.util.List;

public class ToysMapper {
    public String map(Toys toys){
        return String.format("%s,%s,%s", toys.getId(), toys.getName(), toys.getCount());
    }
    public Toys map(String lines){
        String[] line = lines.split(",");
        return new Toys(line[0], line[1], line[2]);
    }
}

