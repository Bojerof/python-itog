import datetime
import csv

def get_notes():
    id = chek_id()
    head = input(("Введите заголовок "))
    body = input("Введите тело заметки ")
    date = datetime.datetime.now().strftime("%d-%m-%y\t%H:%M:%S")
    return {"id": id, "head": head, "body": body, "date": date}

def chek_id():
    id = 0
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            if(int(row["id"]) > id):
                id = int(row["id"])       
        newId = id + 1
        return newId