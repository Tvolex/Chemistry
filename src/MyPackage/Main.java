
package MyPackage;

import java.io.File;

/**
 *
 * @author Tvolex
 */
public class Main {
    
    private static String[] Elements = new String[150];
    
    private static String pathOfSourcesElements;
    
    private static int process;
    
    public static void main (String[] args) {
    
        init();
        startProcess();
        
    }
    
    public static void startProcess() {
        
        while (process == 1) {
        
            System.out.print("Введіть індекс хім.елемента: ");
        
            String input = new Input().get();
            
            String currentElement = Elements[Integer.parseInt(input)];
        
            if (currentElement == null) currentElement = "Sorry, but i didn't found your element ;( плак плак";
            
            if (!input.isEmpty() && new intg().isInteger(input))
                System.out.println("Your element: " + currentElement);
            
            System.out.println("\n Try again ? (y) - for again, something else if no");
            
            String inp = new Input().get();
            
            if (!"y".equals(inp)) process = 0; 
        
        }
        
    }
    
    private static void init() {
    
        process = 1;
        
        pathOfSourcesElements = System.getProperty("user.dir") + "/Elements";
        
        if (pathOfSourcesElements != null) {
        
            File[] files = new File(pathOfSourcesElements).listFiles();

            for (File file : files) {

                Read readFile = new Read(file);

                String contain = readFile.parse();

                int index = readFile.getIndex();

                if (contain != null) {

                    Elements[index] = contain;

                } else {

                    System.err.println("Something wrong");
                }

            }

        }
        
    }
}
