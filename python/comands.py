from fileoperation import *

def run():
    while(True):
        print("Что вы хотите сделать? \n1 (add) - Добавить заметку \n2 (list) - Псмотреть все заметки \n3 (find) - Найти заметку")
        print("4 (update) - Изменить заметку \n5 (delete) - Удалить заметку \n6 (exit) - Выйти")
        comand = input("Введите команду: ")
        if comand.lower() == "add" or comand == "1":
            add()
        elif comand.lower() == "list" or comand == "2":
            print(read())
        elif comand.lower() == "find" or comand == "3":
            find_notes()
        elif comand.lower() == "update" or comand == "4":
            create()
        elif comand.lower() == "delete" or comand == "5":
            delete()
        elif comand.lower() == "exit" or comand == "6":
            break
        print("Хотите продолжить?")
        end = input("Если нет - нажмите n, если да - нажмите y: ")
        if end.lower() == "n":
            break
