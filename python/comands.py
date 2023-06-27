from fileoperation import *

def run():
    while(True):
        comand = input("Введите команду: ")
        if comand.lower() == "add" or comand == "1":
            add()
        elif comand.lower() == "list" or comand == "2":
            print(read())
        elif comand.lower() == "find" or comand == "3":
            find_notes()
        elif comand.lower() == "create" or comand == "4":
            create()
        print("Хотите продолжить?")
        end = input("Если нет - нажмите n, если да - нажмите y: ")
        if end.lower() == "n":
            break
