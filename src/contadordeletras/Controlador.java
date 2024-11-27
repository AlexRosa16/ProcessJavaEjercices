package contadordeletras;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class Controlador {
    public static void main(String[] args) throws IOException {
        System.out.println("Dime una letra y te dire cuantas hay");
        Scanner scanner = new Scanner(System.in);
        char letra = scanner.next().charAt(0);
        Process p = new ProcessBuilder("java","ContadorLetras.java").directory( new File("src/contadordeletras")).start();

        OutputStream os = p.getOutputStream();
        os.write(letra);
        os.flush();
        os.close();

        try {

            InputStream is = p.getInputStream();
            int c;
            while ((c = is.read()) != -1){
                System.out.print((char)c);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}




