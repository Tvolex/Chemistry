/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Alina
 */
public class CRUD {
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
    
    public static void Update (String name, String text) {
        
        String pathToFile = PathToElement.get(name).toString();
        
        Read readFile = new Read(pathToFile);

        String contain = readFile.parse();

        int index = readFile.getIndex();
        
        writeFile rewrite = new writeFile();
        
        rewrite.rewriteFile(pathToFile, index, text);
        
        Main.update();
        
    }
    
    public static void close(Closeable closeable) {
        
       try {
        
           closeable.close();
        
       } catch(IOException ignored) {
        
       }
    }
    
    public void Delete () {
        
        System.out.print("Введіть назву елемента який ви хочете вилучити: ");
        
        String input3 = new Input().get();
        
        if (!input3.isEmpty()){
            
            String Katya = Main.PathToElement.get(input3).toString();
            
            new File(Katya).delete();
                        
        }
        
        Main.update();
    }
}
