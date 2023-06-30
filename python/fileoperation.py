import csv
import notes

def add():
    with open("notes.csv", "a", newline="") as file:
        note = [notes.get_notes()]
        columns = ["id", "date", "head", "body"]
        writer = csv.DictWriter(file, columns)
        if(notes.chek_id() == 1):
            writer.writeheader()
        writer.writerows(note)
        print("Заметка добавлена.")

def read():
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            print(row["id"], "  ", row["date"], "\n", row["head"], "\n",row["body"])
        
        
    
def find_notes():
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        id = int(input("Введите id для поиска заметки: "))
        for row in reader:
            if(int(row["id"]) == id):
                print(row["id"], "  ", row["date"], "\n", row["head"], "\n",row["body"])
        print("Такой заметки нету!")
                
def create():
    list = []
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        index = int(input("Введите id для изменения заметки: "))
        for row in reader:
            if(int(row["id"]) == index):
                note = notes.get_notes_id(index)
                list.append(note)
            else:    
                list.append(row)
    if (int(row["id"]) == index):
        with open("notes.csv", "w", newline="") as file:
            columns = ["id", "date", "head", "body"]
            writer = csv.DictWriter(file, columns)
            writer.writeheader()
            for row in list:
                writer.writerow(row)
            print("Заметка изменена.")
    else:
        print("Такой заметки нету!")

def delete():
    list = []
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        index = int(input("Введите id для удаления заметки: "))
        for row in reader:
            if(int(row["id"]) == index):
                continue
            else:    
                list.append(row)
    if (int(row["id"]) == index):
        with open("notes.csv", "w", newline="") as file:
            id = 1
            columns = ["id", "date", "head", "body"]
            writer = csv.DictWriter(file, columns)
            writer.writeheader()
            for row in list:
                row["id"] = id
                writer.writerow(row)
                id += 1
            print("Заметка удалена.")
    else:
        print("Такой заметки нету!")
