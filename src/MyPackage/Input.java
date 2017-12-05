
package MyPackage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Клас містить методи, які зчитують дані
 * @author Alina
 */
public class Input {
    
    /**
     * Бере введений рядок
     * @return введений рядок, якщо рядка нема - null
     */
    public String get() {
        
        try {
            BufferedReader reader = new BufferedReader( new InputStreamReader (System.in, "Cp1251"));

            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        
        }
        
        return null;
    }
}
