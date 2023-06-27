import csv

def add():
    with open("notes.csv", "a", newline="") as file:
        notes = [{"id": chekId(), "head": input("Введите заголовок "), "body": input("Введите тело заметки ")}]
        columns = ["id", "head", "body"]
        writer = csv.DictWriter(file, columns)
        writer.writeheader()
        writer.writerows(notes)



def chekId():
    id = 0
    with open("notes.csv", "r", newline="") as file:
        reader = csv.DictReader(file)
        for row in reader:
            if(int(row["id"]) > id):
                id = int(row["id"])       
        newId = id + 1
        return newId