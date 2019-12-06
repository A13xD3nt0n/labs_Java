import java.util.ArrayList;


public class CityManager {

    private static ArrayList<Person> citizens = new ArrayList<Person>();

    public static void main(String[] args) {
        manageCity();
    }

    public static void manageCity() {
        while (true) {
            System.out.println("Выберите");
            System.out.println("1. Добавить жителя в город ");
            System.out.println("2. Вывести список жителей города ");
            System.out.println("3. Выгнать жителя из города ");
            System.out.println("4. Поиск жителя ");
            System.out.println("5. Отсортировать жителей");
            System.out.println("6. Выплаты");
            System.out.println("7. Выход");
            switch (City.readLine()) {
                case "1":
                    City.addCitizen();
                    break;
                case "2":
                    City.showCitizens(citizens);
                    break;
                case "3":
                    City.driveOut(citizens);
                    break;
                case "4":
                    City.search();
                    break;
                case "5":
                    City.sort(citizens);
                    break;
                case "6":
                    for (Person person : citizens) {
                        person.increaseBudget();
                        person.payTaxes();
                    }
                    System.out.println("Выплаты произведены");
                    break;
                case "7":
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }

    public static ArrayList<Person> getCitizens() {
        return citizens;
    }

    public static void addCitizen(Person citizen) {
        citizens.add(citizen);
    }


    public static void setCitizens(ArrayList<Person> citizens) {
        CityManager.citizens = citizens;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class City {

    public static String readLine() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void addCitizen() {
        while (true) {
            System.out.println("Выберите профессию нового жителя:");
            System.out.println("1. Рабочий");
            System.out.println("2. Служащий");
            System.out.println("3. Инженер");
            System.out.println("4. Назад");
            switch (readLine()) {
                case "1":
                    CityManager.addCitizen(new Worker(enterName(), enterAge(), enterBudget(), enterSalary()));
                    break;
                case "2":
                    CityManager.addCitizen(new Clerk(enterName(), enterAge(), enterBudget(), enterSalary()));
                    break;
                case "3":
                    CityManager.addCitizen(new Engineer(enterName(), enterAge(), enterBudget(), enterSalary(), enterLevel()));
                    break;
                case "4":
                    CityManager.manageCity();
                    break;
                default:
                    System.out.println("Некорректный ввод!");
                    break;
            }
        }
    }

    private static int enterAge() {
        System.out.println("Введите возраст(14+):");
        int choice = readInt();
        if (choice >= 14) {
            return choice;
        } else {
            return enterAge();
        }
    }

    private static String enterName() {
        System.out.println("Введите имя жителя:");
        String firstName = readLine();
        System.out.println("Введите фамилия жителя:");
        String secondName = readLine();
        System.out.println("Введите отчество жителя:");
        String middleName = readLine();
        String name = secondName + " " + firstName + " " + middleName;
        return name;
    }

    private static int enterBudget() {
        System.out.println("Введите бюджет:");
        int choice = readInt();
        if (choice >= 0) {
            return choice;
        } else {
            return enterBudget();
        }
    }

    private static int enterSalary() {
        System.out.println("Введите зарплату:");
        int choice = readInt();
        if (choice >= 1) {
            return choice;
        } else {
            return enterSalary();
        }
    }

    private static int enterLevel() {
        System.out.println("Введите квалификацию инженера(1-5):");
        int choice = readInt();
        if (choice <= 5 && choice >= 1) {
            return choice;
        } else {
            return enterLevel();
        }
    }

    private static int readInt() {
        try {
            String input = readLine();
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка ввода!");
            return readInt();
        }
    }

    public static void sort(ArrayList<Person> list) {
        int choiceData = chooseData();
        Object buffer;
        switch (choiceData) {
            case 1:
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i).getName().compareTo(list.get(i + 1).getName()) < 0) {
                            buffer = list.get(i);
                            list.set(i, list.get(i + 1));
                            list.set(i + 1, (Person) buffer);
                        }
                    }
                }
                System.out.println("Сортировка выполнена!");
                CityManager.setCitizens(list);
                break;
            case 2:
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i).getAge() < list.get(i + 1).getAge()) {
                            buffer = list.get(i);
                            list.set(i, list.get(i + 1));
                            list.set(i + 1, (Person) buffer);
                        }
                    }
                }
                System.out.println("Сортировка выполнена!");
                CityManager.setCitizens(list);
                break;
            case 3:
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i).getBudget() < list.get(i + 1).getBudget()) {
                            buffer = list.get(i);
                            list.set(i, list.get(i + 1));
                            list.set(i + 1, (Person) buffer);
                        }
                    }
                }
                System.out.println("Сортировка выполнена!");
                CityManager.setCitizens(list);
                break;
            case 4:
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i).getSalary() < list.get(i + 1).getSalary()) {
                            buffer = list.get(i);
                            list.set(i, list.get(i + 1));
                            list.set(i + 1, (Person) buffer);
                        }
                    }
                }
                System.out.println("Сортировка выполнена!");
                CityManager.setCitizens(list);
                break;
            case 5:
                int res1;
                int res2;
                for (int j = 0; j < list.size() - 1; j++) {
                    for (int i = 0; i < list.size() - 1; i++) {
                        if (list.get(i) instanceof Engineer) {
                            res1 = ((Engineer) list.get(i)).getLevel();
                        } else {
                            res1 = 0;
                        }
                        if (list.get(i + 1) instanceof Engineer) {
                            res2 = ((Engineer) list.get(i + 1)).getLevel();
                        } else {
                            res2 = 0;
                        }
                        if (res1 < res2) {
                            buffer = list.get(i);
                            list.set(i, list.get(i + 1));
                            list.set(i + 1, (Person) buffer);
                        }
                    }
                }
                System.out.println("Сортировка выполнена!");
                CityManager.setCitizens(list);
                break;
        }
    }

    public static void driveOut(ArrayList<Person> list) {
        showCitizens(list);
        System.out.println("Выберите ID жителя: ");
        int choice = readInt();
        try {
            list.remove(choice - 1);
            CityManager.setCitizens(list);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Данного элемента нет в списке");
        }
    }

    public static void showCitizens(ArrayList<Person> list) {
        int k = 1;
        System.out.println("Список жителей: ");
        for (Person element : list) {
            System.out.print(k + ") ");
            k++;
            System.out.print("Профессия: " + element.getClass().getSimpleName() + " ");
            System.out.print("ФИО: " + element.getName() + " ");
            System.out.print("Возраст: " + element.getAge() + " ");
            System.out.print("Бюджет: " + element.getBudget() + " ");
            System.out.print("Зарплата: " + element.getSalary() + " ");
            if (element instanceof Engineer) {
                System.out.print("Квалификация: " + ((Engineer) element).getLevel() + " ");
            }
            System.out.println();
        }
    }

    private static int chooseProfession() {
        System.out.println("Выберите профессию");
        System.out.println("1. Рабочий");
        System.out.println("2. Служащий");
        System.out.println("3. Инженер");
        System.out.println("4. Все");
        switch (readLine()) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            default:
                return chooseProfession();
        }
    }

    private static int chooseData(int choice) {
        System.out.println("Выберите данные:");
        System.out.println("1. ФИО");
        System.out.println("2. Возраст");
        System.out.println("3. Бюджет");
        System.out.println("4. Зарплата");
        if (choice == 3) {
            System.out.println("5. Квалификация");
        }
        switch (readLine()) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                if (choice == 3) {
                    return 5;
                } else {
                    return chooseData(choice);
                }
            default:
                return chooseData(choice);
        }
    }

    public static void search() {

        int choiceProfession = chooseProfession();
        int choiceData = chooseData(choiceProfession);
        System.out.println("Введите что находить:");
        String data = readLine();
        System.out.println("Найдены: ");
        switch (choiceProfession) {
            case 1:
                search(choiceData, "Worker", CityManager.getCitizens(), data);
                break;
            case 2:
                search(choiceData, "Clerk", CityManager.getCitizens(), data);
                break;
            case 3:
                search(choiceData, "Engineer", CityManager.getCitizens(), data);
                break;
            case 4:
                search(choiceData, "Worker", CityManager.getCitizens(), data);
                search(choiceData, "Clerk", CityManager.getCitizens(), data);
                search(choiceData, "Engineer", CityManager.getCitizens(), data);
                break;
        }
    }

    public static void search(int choice, String nameClass, ArrayList<Person> list, String data) {
        switch (choice) {
            case 1:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClass().getSimpleName().equals(nameClass)) {
                        if (list.get(i).getName().compareTo(data) == 0) {
                            printCitizen(i);
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClass().getSimpleName().equals(nameClass)) {
                        if (Integer.toString(list.get(i).getAge()).compareTo(data) == 0) {
                            printCitizen(i);
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClass().getSimpleName().equals(nameClass)) {
                        if (Integer.toString(list.get(i).getBudget()).compareTo(data) == 0) {
                            printCitizen(i);
                        }
                    }
                }
                break;
            case 4:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClass().getSimpleName().equals(nameClass)) {
                        if (Integer.toString(list.get(i).getSalary()).compareTo(data) == 0) {
                            printCitizen(i);
                        }
                    }
                }
                break;
            case 5:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getClass().getSimpleName().equals(nameClass)) {
                        if (Integer.toString(((Engineer) list.get(i)).getLevel()).compareTo(data) == 0) {
                            printCitizen(i);
                        }
                    }
                }
                break;
        }
    }

    public static void printCitizen(int index) {
        System.out.print("Профессия: " + CityManager.getCitizens().get(index).getClass().getSimpleName() + " ");
        System.out.print("ФИО: " + CityManager.getCitizens().get(index).getName() + " ");
        System.out.print("Возраст: " + CityManager.getCitizens().get(index).getAge() + " ");
        System.out.print("Бюджет: " + CityManager.getCitizens().get(index).getBudget() + " ");
        System.out.print("Зарплата: " + CityManager.getCitizens().get(index).getSalary() + " ");
        if (CityManager.getCitizens().get(index) instanceof Engineer) {
            System.out.print("Квалификация: " + ((Engineer) CityManager.getCitizens().get(index)).getLevel() + " ");
        }
        System.out.println();
    }

    private static int chooseData() {
        System.out.println("Выберите данные:");
        System.out.println("1. ФИО");
        System.out.println("2. Возраст");
        System.out.println("3. Бюджет");
        System.out.println("4. Зарплата");
        System.out.println("5. Квалификация");
        switch (readLine()) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            default:
                return chooseData();
        }
    }
}

abstract public class Person {

    private String name;
    private int age;
    private int budget;
    private int salary;

    public Person(String name, int age, int budget, int salary) {
        this.age = age;
        this.budget = budget;
        this.name = name;
        this.salary = salary;
    }

    abstract public void payTaxes();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getBudget() {
        return budget;
    }

    public int getSalary() {
        return salary;
    }

    public void decreaseBudget(int sum) {
        this.budget = this.budget - sum;
    }

    public void increaseBudget() {
        this.budget += salary;
    }
}

public class Engineer extends Person {

    private int level;

    public int getLevel() {
        return level;
    }

    public Engineer(String name, int age, int budget, int salary, int level) {
        super(name, age, budget, (int) (level*salary*0.3+salary));
        this.level = level;
    }

    @Override
    public void payTaxes() {
        decreaseBudget((int) (super.getSalary() * 0.15));
    }
}

public class Clerk extends Person {


    public Clerk(String name, int age, int budget, int salary) {
        super(name, age, budget, salary);
    }

       @Override
    public void payTaxes() {
        decreaseBudget((int)(super.getSalary()*0.05));
    }
}

public class Worker extends Person {

    public Worker(String name, int age, int budget, int salary) {
        super(name, age, budget, salary);
    }

    @Override
    public void payTaxes() {
        decreaseBudget((int) (super.getSalary() * 0.25));
    }
}
