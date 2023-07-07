import java.util.Scanner;

public class ViewToys {
    public ViewToys(ToysOperation toysOperation) {
        this.toysOperation = toysOperation;
    }

    private ToysOperation toysOperation;

    public void run(){
        Commands com = Commands.NONE;
        while (true) {
            try {
                System.out.println("Что вы хотите сделать? \nДобавить игрушку - add\nПоказать список игрушек - list" +
                        "\nРазыграть игрушку - lot\nУбрать с полок ишрушку - delete" +
                        "\nКупить игрушку - buy\nвыйти - exit");
                String command = print("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT) return;
                switch (com) {
                    case ADD:
                        toysOperation.add();
                        break;
                    case DELETE:
                        toysOperation.delete();
                        break;
                    case BUY:
                        toysOperation.buy();
                        break;
                    case LIST:
                        toysOperation.listToys();
                        break;
                    case LOT:
                        toysOperation.lotToys();
                        break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private String print(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

}
