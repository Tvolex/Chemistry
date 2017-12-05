
package MyPackage;

import java.io.File;
import java.util.TreeMap;

/**
 * Головний клас
 * @author Alina
 */
public class Main {
    
    public static TreeMap PathToElement = new TreeMap();
    
    public static TreeMap Elements = new TreeMap();
    
    public static String pathOfSourcesElements;
    
    private static int process;
    
    public static void main (String[] args) {
        
        init();
       
        startProcess();
        
    }
    /**
     * Метод виконує головний процес: зчитує введені користувачем аргументи та викликає потібні для виконання методи
     */
    public static void startProcess() {
        
        String input = "";
        
        String currentElement = "";
      
        System.out.print("Вітаю! Це довідник з хімії!\n");
        
        while (process == 1) {
            
            System.out.print("Оберіть дію:" + "\n"+"1: переглянути інформацію про хімічнй елементи"+"\n"+"2: редагувати інфомацію про хімічний елемент"+"\n"+"3: вилучити елемент"+"\n"+"4: додати новий елемент"+"\n");
           
            switch(new Input().get()){
                
                case "1": 
                    
                    System.out.print("Введіть індекс хімічного елемента: ");
                   
                    input = new Input().get();
                    
                    if (input != null) {
                        if (new Intg().isInteger(input) && input != "" ) {
                            
                            currentElement = new CRUD().Read(Integer.parseInt(input));
                        } else {
                            System.err.println("Ви не коректний індекс");
                        }
                    }
                    
                    
                    
                    break;
                   
                case "2":
                    System.out.println("Введіть назву елемента (Назва.txt): ");
                    
                    String name = new Input().get();
                    
                    if (!name.isEmpty() && validateStr(name)) {
                        name += ".txt";
                        System.out.println("Введіть новий текст: ");
                        String newText = new Input().get();
                        
                        if (!newText.isEmpty()){
                            new CRUD().Update(name, newText);
                        }
                    } else {
                        System.err.println("Ви ввели не правильну назву");
                    }
                    
                    
                    break;
                    
                case "3": 
                    System.out.print("Введіть назву елемента який ви хочете вилучити: ");
                    String inName = new Input().get();
        
                    if (!inName.isEmpty() && validateStr(inName)) {
                        new CRUD().Delete(inName);
                    } else {
                        System.err.println("Ви ввели не правильне ім`я");
                    }
                
                    break;
        
                    
                    
                case "4": 
                    System.out.println("Введіть індекс хімічного елемента: ");
                    
                    String index = new Input().get();
                    
                    System.out.println("Введіть назву: ");
                    
                    String nameEL = new Input().get();
                    
                    System.out.println("Введіть текст: ");
                    
                    String text = new Input().get();
                    
                    if (new Intg().isInteger(index)) {
                        new CRUD().Create(Integer.parseInt(index), nameEL, text);
                    }  else {
                        System.err.println("Ви ввели не коректнй індекс");
                    }
                    break;
                    
                default: 
                    System.out.println("Ви ввели не вірний пункт");
            }   
            
            if (currentElement == null) currentElement = "Такого елемента не існує";
            
            if (!input.isEmpty() && new Intg().isInteger(input))
                
                System.out.println("Ваш елемент: " + currentElement);
            
            System.out.println("Продовжити?"+"\n"+"y - продовжити"+"\n"+"інше - вихід");
            
            String inp = new Input().get();
            
            if (!"y".equals(inp)) process = 0; 
        
        }
        
    }
    /**
     * Метод ініціалізує змінну pathOfSourcesElements
     */
    private static void init() {
        
        process = 1;
       
        pathOfSourcesElements = System.getProperty("user.dir") + "/Elements";
       
        if (pathOfSourcesElements != null) {
        
            update();

        }
        
    }
    /**
     * Обновляє змінну Elements
     */
    public static void update () {
       
        File[] files = new File(pathOfSourcesElements).listFiles();
        
        for (File file : files) {
            
            PathToElement.put(file.getName(), file.getAbsolutePath());
            
            Read readFile = new Read(file);
           
            String contain = readFile.parse();
            
            int index = readFile.getIndex();
            
            if (contain != null) {
                
                Elements.put(index, contain);
                
            } else {
                // System.err.println("Something wrong");
            }
        }
    }
    
    public static boolean validateStr (String str) {
        if (new Intg().isInteger(str)) 
            return false;
                
        return true;
    }
    
}
