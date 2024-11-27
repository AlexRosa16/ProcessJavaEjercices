package validaremail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) throws IOException {

        for (int i=0; i < 3;i++){
            System.out.println("Dime un email");
            Scanner scanner = new Scanner(System.in);
            String mail = scanner.nextLine();

            Process p = new ProcessBuilder("java", "validarmail.java").directory(new File("src/validaremail")).start();

            OutputStream os = p.getOutputStream();
            os.write(mail.getBytes());
            os.flush();
            os.close();

            try {
                InputStream is = p.getInputStream();
                int c;
                while ((c= is.read()) != -1){
                    System.out.print((char)c);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }




        }



    }
}
