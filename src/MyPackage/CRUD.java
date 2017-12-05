
package MyPackage;

import static MyPackage.Main.Elements;
import static MyPackage.Main.PathToElement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Клас, що містить методи для роботи з файлами
 * @author Alina
 */
public class CRUD {
    /**
     * Створює нови файл
     * @param index змінна містить  індекс елемента     
     * @param name змінна містить ім*я файлу
     * @param text змінна містить вміст файлу
     */
    public void Create (int index, String name ,String text) {
        
        if (Read(index) == null) {
        
            File PATH = new File(Main.pathOfSourcesElements);
            
            try {
            
                String path = Main.pathOfSourcesElements + File.separator + name + ".txt";

                File f = new File(path);

                f.getParentFile().mkdirs(); 
                f.createNewFile();
                
                writeFile rewrite = new writeFile();
        
                rewrite.rewriteFile(f.getAbsolutePath(), index, text);
        
                Main.update();
                
            } catch (IOException e ) {
            
                System.err.println("Програма впіймала помилку: " + e);
                
            }
            
        }
        
    }
    
    /**
     * @param index це індекс хімічного елементу
     */
    public String Read (int index) {
                 
        Object getObj = Elements.get(index);
                
        if (getObj == null) 
            return null;
        else 
            return getObj.toString();
    }
    /* Редагує вміст файла
    * @param name змінна в якій зберігається імя файлу
    * @param text змінна в якій вміст файлу
    */
    public static void Update (String name, String text) {
       try {
           String pathToFile = PathToElement.get(name).toString();
        
            Read readFile = new Read(pathToFile);

            String contain = readFile.parse();

            int index = readFile.getIndex();

            writeFile rewrite = new writeFile();

            rewrite.rewriteFile(pathToFile, index, text);

            Main.update();
       } catch (NullPointerException notExistFile) {
           System.err.println("Такого файлу не існує");
       }  
        
        
        
    }
    
    public static void close(Closeable closeable) {
        
       try {
        
           closeable.close();
        
       } catch(IOException ignored) {
        
       }
    }
    /**
     * Видаляє заданий файл
     * @param name назва файлу, який потрібно видалити
     */
    public void Delete (String name) {
        
        String Katya = Main.PathToElement.get(name + ".txt").toString();
        
        boolean deleted = new File(Katya).delete();
        
        if (deleted) {
            System.err.println("Елемент " + name + " успішно видалений");
        } else {
            System.err.println("Такого елементу не існує");
        }
        
        Main.update();
    }
}
