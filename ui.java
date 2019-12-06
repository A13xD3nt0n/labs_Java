import java.io.*;
import java.util.*;

public class UserInterface {
    private static ArrayList<Text> ourList = new ArrayList<Text>();
    
    // меню работы со списком объектов
    private static void workWithList()
    {
        System.out.println("Выберите:");
        System.out.println("1) Создать экземпляр класса;");
        System.out.println("2) Вывести список созданных объектов на экран;");
        System.out.println("3) Удаление объекта из списка;");
        System.out.println("4) Выполнение заданий с указанным элементом списка;");
        System.out.println("5) Изменить элемент списка;");
        System.out.println("6) Назад.");
            switch (IOS.readLine()) {
                case "1":
                    createObject();
                    break;
                case "2":
                    if (!ourList.isEmpty())
                    {
                        printList(ourList);                        
                    }
                    else
                    {
                        System.out.println("Список пуст!");
                    }
                    break;
                case "3":
                    printList(ourList);
                    int choice = chooseObject();
                    switch (choice) {
                        case -1:
                            System.out.println("Некорректный ввод!");
                            break;
                        case -2:
                            System.out.println("Список пуст!");
                            break;
                        default:
                            ourList.remove(choice);
                            break;
                    }
                    break;
                case "4":
                    if (ourList.isEmpty())
                    {
                        System.out.println("Список пуст!");
                    }
                    else 
                    {
                        doTasks();                        
                    }
                    break;
                case "5":
                    printList(ourList);
                    int ch = chooseObject();
                    switch (ch) {
                        case -1:
                            System.out.println("Некорректный ввод!");
                            break;
                        case -2:
                            System.out.println("Список пуст!");
                            break;
                        default:
                            System.out.println("Введите текст:");
                            ourList.get(ch).setString(IOS.readLine());
                            break;
                    }
                    break;
                case "6":
                    break;
                default:
                    workWithList();
                    System.out.println("Некорректный ввод!");
                    break;
                    
            }
    }
    
    // меню выбора способа создания экземпляра класса
    private static void createObject()
    {
        System.out.println("Выберите способ создания объекта:");
        System.out.println("1) Новый;");
        System.out.println("2) Новый с введенным текстом;");
        System.out.println("3) Копия другого из списка;");
        System.out.println("4) Назад.");
        switch (IOS.readLine()) {
            case "1":
                ourList.add(new Text());
                break;
            case "2":
                System.out.println("Введите текст: ");
                ourList.add(new Text(IOS.readLine()));
                break;
            case "3":
                printList(ourList);
                int choice = chooseObject();
                switch (choice) {
                    case -1:
                        System.out.println("Некорректный ввод!");
                        break;
                    case -2:
                        System.out.println("Список пуст!");
                        break;
                    default:
                        ourList.add(new Text(ourList.get(choice)));
                        break;
                }
                break;
            case "4":
                workWithList();
                break;
            default:
                System.out.println("Некорректный ввод!");
                createObject();
                break;
                
        }
    }
    
    // печать листа
    private static void printList(ArrayList<Text> list)
    {
        Integer i = 1;
        if (!list.isEmpty())
        {
            System.out.println("Список объектов:");
            for (Text element: list)
            {
                System.out.print(i.toString() + ") ");
                i++;
                System.out.println(element.getString());
            }
        }
    }
    
    // выбор объекта из списка
    private static int chooseObject()
    {
        if (ourList.isEmpty())
        {
            return -2;
        }
        else
        {            
            System.out.println("Выберите элемент из списка: ");
            return IOS.readInt();            
        }
    }
    
    // выполнение заданий
    private static void doTasks()
    {
        printList(ourList);
        int choice = chooseObject();
        switch (choice) {
            case -1:
                System.out.println("Некорректный ввод!");
                break;
            case -2:
                System.out.println("Список пуст!");
                break;
            default:
                System.out.println("Выберите:");
                System.out.println("1) Вывести количество знаков препинания;");
                System.out.println("2) Вывести слова, начинающиеся и заканчивающиеся на одну и ту же букву;");
                System.out.println("3) Вывести массив слов, полученных из текста, в порядке возрастания длин слов;");
                System.out.println("4) Назад.");
            switch (IOS.readLine()) {
                case "1":
                    System.out.println("Результат: ");
                    System.out.println(ourList.get(choice).countSigns());               
                    break;
                case "2":
                    System.out.println("Результат: ");
                    ourList.get(choice).printWithChoice();
                    break;
                case "3":
                    System.out.println("Результат: ");
                    ourList.get(choice).printSort();
                    break;
                case "4":
                    workWithList();
                    break;
                default:
                    System.out.println("Некорректный ввод!");
                    doTasks();
                    break;
            }
            break;
        }
    }
   
    // получение элемента списка
    public static void getElement(int numer)
    {
        ourList.get(numer);
    }
    
    // стартовое меню
    public static void startMenu()
    {
        while (true)
        {
            System.out.println("Выберите:");
            System.out.println("1) Работа с списком текстов;");
            System.out.println("2) Открыть файл;");
            System.out.println("3) Сохранить файл;");
            System.out.println("4) Выход.");
            switch (IOS.readLine()) {
                case "1":
                    workWithList();
                    break;
                case "2":
                    if (IOS.readFile())
                    {
                        System.out.println("Файл прочтен!");
                    }
                    else 
                    {
                        System.out.println("Ошибка!");
                    }
                    break;
                case "3":
                    if (IOS.saveFile(ourList))
                    {
                        System.out.println("Файл сохранен!");
                    }
                    else 
                    {
                        System.out.println("Ошибка!");
                    }
                    break;                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }        
    }
    
    // добавления элемента в список
    public static void addElement(String s)
    {
        ourList.add(new Text(s));        
    }
    
    // очистка списка объектов
    public static void clearList()
    {   
        ourList.clear();
    }
    
}