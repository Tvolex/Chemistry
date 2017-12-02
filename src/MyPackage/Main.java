
package MyPackage;

import java.io.File;
import java.util.TreeMap;

/**
 *
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
    
    public static void startProcess() {
        
        String input = "";
        String currentElement = "";
        
        while (process == 1) {
            
            System.out.print("Введіть дію: 1 - перегляд інформації про хімічнй елементи, 2 - редагування інфомації, 3 - вилучення елемента: ");
            
            
        
            switch(new Input().get()){
                case "1": 
                    //System.out.print("Введіть індекс хім.елемента: ");
                    
                    //input = new Input().get();
                    
                    //Object getObj = Elements.get(Integer.parseInt(input));
                    
                    //currentElement = getObj.toString();
                    System.out.print("Введіть індекс хім.елемента: ");
                    
                    input = new Input().get();
                    
                    currentElement = new CRUD().Read(Integer.parseInt(input));
                    
                    break;
                    
                case "2":
                    System.out.println("Введіть назву елементу: ");
                    
                    String name = new Input().get();
                    
                    if (!name.isEmpty()) {
                        
                        System.out.println("Введіть новий текст елементу: ");

                        String newText = new Input().get();

                        if (!newText.isEmpty()){
                            //System.out.println(PathToElement.get(input2));
                            new CRUD().Update(name, newText);
                        }
                    }
                    
                    
                    
                    break;
                case "3": 
                    new CRUD().Delete();
                    break;
                    
                case "4": 
                    System.out.println("Введіть індекс: ");
                    
                    String index = new Input().get();
                    
                    System.out.println("Введіть назву: ");
                    
                    String nameEL = new Input().get();
                    
                    System.out.println("ВВедіть текс: ");
                    
                    String text = new Input().get();
                    
                    new CRUD().Create(Integer.parseInt(index), nameEL, text);
            }
            
            
            
            
                    
        
            if (currentElement == null) currentElement = "Такого елемента не існує";
            
            if (!input.isEmpty() && new Intg().isInteger(input))
                System.out.println("Ваш елемент: " + currentElement);
            
            System.out.println("\n Продовжити? (y) - продовжити, інше - якщо ні");
            
            String inp = new Input().get();
            
            if (!"y".equals(inp)) process = 0; 
        
        }
        
    }
    
    private static void init() {
    
        process = 1;
        
        pathOfSourcesElements = System.getProperty("user.dir") + "/Elements";
        
        if (pathOfSourcesElements != null) {
        
            update();

        }
        
    }
    
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

                System.err.println("Something wrong");
            }

        }
    }
    
}
