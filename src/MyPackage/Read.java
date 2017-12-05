
package MyPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Цей клас містить метод, який зчитує вміст файла
 * @author Alina
 */
public class Read {
    
    private final File currentFile;
    
    private int index;
    
    private String[] nameOfFile;
    
    private String contain;
    /**
     * Конструктор з параметром 
     * @param currentFile з типом File
     */
    public Read (File currentFile) {
        
        this.currentFile = currentFile;
    
        this.nameOfFile = currentFile.getName().split(".txt");
        
        contain = nameOfFile[0];
    }
    /**
     * Конструктор з параметром
     * @param currentEl з типом String
     */
    public Read(String currentEl) {
        
        this.currentFile = new File(currentEl);
        
        this.nameOfFile = currentFile.getName().split(".txt");
        
        contain = nameOfFile[0];
    }
    /**
     * Зчитує вміст файла
     * @return вміст, якщо нема - null
     */
    public String parse() {
        
        if (currentFile.isFile() && currentFile.canRead()) {
            
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile),"Cp1251"));
                
                while (in.ready()){
                  
                    String s = in.readLine();
                    
                    if (new Intg().isInteger(s)) index = Integer.parseInt(s);
                    
                    if (s != null && !new Intg().isInteger(s) ) 
                        contain = contain + "\n" + s; 
                    
                }
                
                in.close();
                
                return contain;
                
            } catch (Exception e) {

                System.err.println("Error: " + e);

                return null;
            }
            
        }
        return null;
    }
    /**
     * @return повертає індекс елемента
     */  
    public int getIndex() {
        return index;
    }
    
}
