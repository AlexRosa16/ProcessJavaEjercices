package ejercicioexamen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) throws IOException {
        System.out.println("Dime una cadena");
        Scanner scanner = new Scanner(System.in);
        String cadena = scanner.nextLine();
        Process p = new ProcessBuilder("java","Coincidencia.java").directory( new File("src/ejercicioexamen")).start();

        OutputStream os = p.getOutputStream();
        os.write(cadena.getBytes());
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
