
package MyPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Tvolex
 */
public class Read {
    
    private final File currentFile;
    
    private int index;
    
    private String contain;
    
    public Read (File currentFile) {
        
        this.currentFile = currentFile;
    
    }
    

    
    public String parse() {
        
        if (currentFile.isFile() && currentFile.canRead()) {
            
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(currentFile),"Cp1251"));
                
                int i=0;
                
                while (in.ready()){
                  
                    String s = in.readLine();
                    
                    if (new intg().isInteger(s)) index = Integer.parseInt(s);
                    
                    if (s != null && !new intg().isInteger(s) ) 
                        contain = s; 
                    
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
    
    
    
    public int getIndex() {
        return index;
    }
    
}
