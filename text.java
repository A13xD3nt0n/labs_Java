import java.util.ArrayList;

public class Text {
    private String string = "";
    private ArrayList<String> arrayOfWords = new ArrayList<String>();
    
    // пустой конструктор
    public Text() {};
    
    // конструктор с введенным текстом
    public Text(String str)
    {
        string = str;
        splitToArray();
    }
    
    // конструктор копирования
    public Text(Text other)
    {
        string = other.string;
        splitToArray();
    }
    
    // изменение текста
    public void setString(String str)
    {
        string = str;
        arrayOfWords.clear();
        splitToArray();
    }
    
    // получение текста
    public String getString()
    {
        return string;        
    }
    
    // подсчет знаков препинания
    public int countSigns()
    {
        String znaki = ",.?!()-:;";
        int count = 0;
        boolean probel = false;
        for (int i = 0; i<string.length(); i++)
        {
            for (int j = 0; j<znaki.length(); j++)
            {
                if (znaki.charAt(j)==string.charAt(i))
                {
                    count++;
                }
                if (!probel && string.charAt(i)=='-')
                {
                    count--;
                }
                if (string.charAt(i)==' ')
                {
                    probel = true;
                }
                else
                {
                    probel = false;
                }
            }
        }        
        return count;        
    }
    
    // забиение текста на массив слов
    private void splitToArray()
    {
        String str = string + " ";
        str = str.replaceAll("[.,!?():;]+", "");
        str = str.replaceAll(" - ", " ");
        int endofword;
        while (!str.isEmpty())
        {
            endofword = str.indexOf(" ");
            arrayOfWords.add(str.substring(0, endofword));
            str = str.substring(endofword+1);            
        }
    }
    
    // печать сортированного в порядке возрастания длины слов массива
    public void printSort()
    {
        String buffer;
        for (int i = 0; i<arrayOfWords.size();i++)
        {
            for (int j = 0; j<arrayOfWords.size()-1;j++)
            {
                if (arrayOfWords.get(j).length()>arrayOfWords.get(j+1).length())
                {
                    buffer = arrayOfWords.get(j);
                    arrayOfWords.set(j,arrayOfWords.get(j+1));
                    arrayOfWords.set(j+1,buffer);
                }
            }
        }
        for (String element: arrayOfWords)
        {
                
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    // печать слов, которые начинаются на одну и ту же букву
    public void printWithChoice()
    {
        for (String element: arrayOfWords)
        {
            if (element.charAt(0)==element.charAt(element.length()-1))
            {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }
}
