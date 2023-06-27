import csv
import datetime

def add():
    with open("notes.csv", "a", newline="") as file:
        notes = [{"id": chekId(), "head": input("Введите заголовок "), "body": input("Введите тело заметки "), 
                  "date": datetime.datetime.now().strftime("\t%d-%m-%y\t%H:%M:%S")}]
        columns = ["id", "head", "body", "date"]
        writer = csv.DictWriter(file, columns)
        if(chekId() == 1):
            writer.writeheader()
        writer.writerows(notes)

def read():
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            print(row["id"], row["head"], row["body"], row["date"])

def chekId():
    id = 0
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            if(int(row["id"]) > id):
                id = int(row["id"])       
        newId = id + 1
        return newId