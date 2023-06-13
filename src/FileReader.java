import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) throws FileNotFoundException {
        int contador = 0;
        File file = new File("C:\\Users\\Leo\\Documents\\ALEST\\TrabalhoFinalALEST\\src\\data.csv");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(contador + " " + line);
            contador++;
        }
    }

}
