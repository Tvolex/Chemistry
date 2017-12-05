package MyPackage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
/**
 * Клас містить методи, які записуюь дані у файл, якщо файл не існує, то його буде створено
 * @author Alina
 */
public class writeFile {
    private BufferedWriter out;
    /**
     * Метод дописує у кінець файлу переданий текст, якщо файл не існує його буде створено
     * @param x містить текст який треба дописати
     */
    public void addToFile(String x){
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\text.txt", true),"Cp1251"));
            out.write(x);
            out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Метод перезаписує файл, якщо файл не існує його буде створено
     * @param X текст яким буде перезаписано файл
     * @param index індекс елементу
     * @param pathToFile путь до файлу
     */
    public void rewriteFile(String pathToFile, int index, String X) {
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToFile),"Cp1251"));           
            out.write(String.valueOf(index));
            out.newLine();
            out.write(X);
            out.newLine();
            out.close();
            
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }      
}
