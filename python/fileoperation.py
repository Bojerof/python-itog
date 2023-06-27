import csv
import notes

def add():
    with open("notes.csv", "a", newline="") as file:
        note = [notes.get_notes()]
        columns = ["id", "head", "body", "date"]
        writer = csv.DictWriter(file, columns)
        if(notes.chek_id() == 1):
            writer.writeheader()
        writer.writerows(note)
        print("Заметка добавлена.")

def read():
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            print(row["id"], "  ", row["head"], "\n",row["body"], "\n",row["date"])
        
    
def find_notes():
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        id = int(input("Введите id для поиска заметки: "))
        for row in reader:
            if(int(row["id"]) == id):
                print(row["id"], "  ", row["head"], "\n",row["body"], "\n",row["date"])

def create():
    with open("notes.csv", "r+", newline="") as file:
        reader = csv.DictReader(file)
        columns = ["id", "head", "body", "date"]
        writer = csv.DictWriter(file, columns)
        index = int(input("Введите номер id для изменения: "))
        for row in reader:
            if(int(row["id"]) == index):
                note = [notes.get_notes(index)]
                writer.writerows(note)
            writer.writerows(row)


