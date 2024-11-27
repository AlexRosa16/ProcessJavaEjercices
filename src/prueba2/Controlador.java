package prueba2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        Process p = new ProcessBuilder("java", "Palindromo.java").directory( new File("src/prueba2")).start();
        
        OutputStream os = p.getOutputStream();
        os.write(cadena.getBytes());
        os.flush();
        os.close();

        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read())!= -1){
            System.out.print((char)c);
        }
        is.close();
    }
}
