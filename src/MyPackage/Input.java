
package MyPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvolex
 */
public class Input {
    
    /**
     * Get string of input
     * @return String input, if something happened wrong that return null
     */
    public String get() {
        
        try {
            
            BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
            
            String path = reader.readLine();
            
            return path;
        } catch (IOException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return null;
    }
}
