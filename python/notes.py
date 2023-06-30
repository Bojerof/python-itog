import datetime
import csv

def get_notes():
    id = chek_id()
    head = input(("Введите заголовок "))
    body = input("Введите тело заметки ")
    date = datetime.datetime.now().strftime("%d-%m-%y  %H:%M:%S")
    return {"id": id, "date": date , "head": head, "body": body}

def get_notes_id(new_id):
    id = new_id
    head = input(("Введите заголовок "))
    body = input("Введите тело заметки ")
    date = datetime.datetime.now().strftime("%d-%m-%y  %H:%M:%S")
    return {"id": id, "date": date , "head": head, "body": body}

def chek_id():
    id = 0
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            if(int(row["id"]) > id):
                id = int(row["id"])       
        newId = id + 1
        return newId