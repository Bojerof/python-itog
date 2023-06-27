from fileoperation import *

def run():
    while(True):
        comand = input("Введите команду: ")
        if comand.lower() == "add" or comand == "1":
            add()
        elif comand.lower() == "list" or comand == "2":
            read()
        print("Хотите продолжить?")
        end = input("Если нет - нажмите n, если да - нажмите y: ")
        if end.lower() == "n":
            break
