/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage;

/**
 * Клас містить метод, який перевіряє число
 * @author Alina
 */
public class Intg {
    /**
     * Метод, який перевіряє чи в рядку число
     * @param s рядок
     * @return число, якщо введено не число, ловить помилку
     */
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
