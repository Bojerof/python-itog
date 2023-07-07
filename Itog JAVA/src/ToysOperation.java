import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToysOperation {
    FileOperation fileOperation = new FileOperation("toys.txt");
    FileOperation fileLotOperation = new FileOperation("lotToys.txt");
    ToysMapper mapper = new ToysMapper();

    private Toys input() {
        String name = print("Введите название игрушки");
        String count = print("Введите количество");
        return new Toys(name, count);
    }
    public void listToys(){
        List<String> list = fileOperation.readAll();
        for (var item : list) {
            System.out.println(item);
        }
    }
    private List<Toys> getAllToys() {
        List<String> fileList = fileOperation.readAll();
        List<Toys> toys = new ArrayList<>();
        for (var item : fileList) {
            toys.add(mapper.map(item));
        }
        return toys;
    }
    private List<Toys> getAllLotToys(){
        List<String> fileList = fileLotOperation.readAll();
        List<Toys> toys = new ArrayList<>();
        for (var item : fileList) {
            toys.add(mapper.map(item));
        }
        return toys;
    }
    private void addLot(Toys toy){
        List<Toys> toys = getAllLotToys();
        for (var item : toys) {
            if (item.getName().equals(toy.getName())){
                int count = Integer.parseInt(item.getCount()) + 1;
                String newCount = String.format("%d", count);
                item.setCount(newCount);
                saveLot(toys);
                return;
            }
        }
        int id = toys.size() + 1;
        toy.setId(String.format("%d", id));
        toy.setCount(String.format("%d", 1));
        toys.add(toy);
        saveLot(toys);
    }

    public void add() {
        List<Toys> toys = this.getAllToys();
        Toys toy = input();
        int max = 0;
        for (var item : toys) {
            int id = Integer.parseInt(item.getId());
            if (id > max){
                    max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        toy.setId(id);
        toys.add(toy);
        saveAll(toys);
        System.out.println("Игрушка добавлена");
    }
    public void delete(){
        List<Toys> toys = this.getAllToys();
        List<Toys> newToys = new ArrayList<>();
        String toy = print("Введите название игрушки");
        int id = 1;
        for (var item : toys) {
            if (!item.getName().equals(toy)){
                item.setId(String.format("%d", id));
                newToys.add(item);
                id += 1;
            }
        }
        saveAll(newToys);
        System.out.printf("Ишрушка %s убрана с полок\n", toy);
    }
    public void buy(){
        List<Toys> toys = this.getAllToys();
        List<Toys> newToys = new ArrayList<>();
        String toy = print("Введите название игрушки");
        for (var item : toys) {
            if (item.getName().equals(toy)){
                if (Integer.parseInt(item.getCount()) > 0) {
                    int count = Integer.parseInt(item.getCount()) - 1;
                    String strCount = String.format("%d", count);
                    item.setCount(strCount);
                }
            }
        }
        int id = 1;
        for (var item : toys){
            if (Integer.parseInt(item.getCount()) > 0){
                item.setId(String.format("%d", id));
                newToys.add(item);
                id += 1;
            }
        }
        saveAll(newToys);
        System.out.printf("Игрушка %s куплена\n", toy);
    }

    private void saveAll(List<Toys> toys){
        List<String> list = new ArrayList<>();
        for (var item : toys) {
            list.add(mapper.map(item));
        }
        fileOperation.saveAll(list);
    }
    private void saveLot(List<Toys> toys){
        List<String> list = new ArrayList<>();
        for (var item : toys) {
            list.add(mapper.map(item));
        }
        fileLotOperation.saveAll(list);
    }
    public void lotToys(){
        List<Toys> toys = this.getAllToys();
        List<Toys> newToys = new ArrayList<>();
        Toys newToy = null;
        int count = (int) ((Math.random() * toys.size()) + 1);
        for (var item : toys) {
            if (Integer.parseInt(item.getId()) == count){
                newToy = item;
                if (Integer.parseInt(item.getCount()) > 0) {
                    int counter = Integer.parseInt(item.getCount()) - 1;
                    String strCount = String.format("%d", counter);
                    item.setCount(strCount);
                }
            }
        }
        int id = 1;
        for (var item : toys){
            if (Integer.parseInt(item.getCount()) > 0){
                item.setId(String.format("%d", id));
                newToys.add(item);
                id += 1;
            }
        }
        saveAll(newToys);
        addLot(newToy);
        System.out.printf("Вы выйграли игрушку - %s\n", newToy.getName());
    }
    private String print(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
