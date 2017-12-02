/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

/**
 *
 * @author Tvolex
 */
public class intg {
    
    public boolean isInteger(String s) {
        
        try { 
            
            Integer.parseInt(s); 
            
        } catch(NumberFormatException e) { 
            
            return false; 
            
        } catch(NullPointerException e) {
            
            return false;
            
        }
        return true;
    }
}
