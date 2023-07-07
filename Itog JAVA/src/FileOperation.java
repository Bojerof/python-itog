import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperation implements IFileOperating {

    private String fileName;

    public FileOperation(String fileName) {
        this.fileName = fileName;
        try (FileWriter fileWriter = new FileWriter(fileName, true)){
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<String> readAll(){
        List<String> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);
            String line = bf.readLine();
            if (line != null)
                list.add(line);
            while (line != null){
                line = bf.readLine();
                if (line != null)
                    list.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveAll(List<String> list) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)){
            for (String line : list){
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
