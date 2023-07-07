import java.util.List;

public interface IFileOperating {
    public List<String> readAll();
    public void saveAll(List<String> list);
}
