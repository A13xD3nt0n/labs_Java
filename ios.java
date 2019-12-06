import java.io.*;
import java.util.*;

public class IOS {
    // ввод строки с клавиатуры
    public static String readLine()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    
    // ввод целого числа с клавиатуры
    public static int readInt()
    {
        String input = readLine();
        try {
           int numer = Integer.parseInt(input)-1;
           UserInterface.getElement(numer);
           return numer;
        }
        catch (NumberFormatException | IndexOutOfBoundsException e)
        {
            return -1;
        }
    }
    
    // чтение файла
    public static void readFile()
    {
        UserInterface.clearList();
        String s;       
        try (BufferedReader br = new BufferedReader( new FileReader ("strings.txt"))) {
            while ((s=br.readLine())!=null)
            {
                UserInterface.addElement(s);
            }
            return true;
        }
        catch (IOException ex)
        {
            return false;
        }
    }
    
    // сохранение файла
    public static void saveFile(ArrayList<Text> array)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter ("strings.txt"))) {
            for (int i = 0; i < array.size(); i++)
            {
                bw.write(array.get(i).getString()+"\r\n");
            }
            return true;
        }
        catch (IOException ex)
        {
            return false;
        }        
    }
}