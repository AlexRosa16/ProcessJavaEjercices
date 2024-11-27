package prueba;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Lanzador {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantas veces lo quieres?");
        int numVeces = scanner.nextInt();

        for (int i = 0; i < numVeces; i++){
        int n1 = 2;
        int n2 = 3;
        Process p = new ProcessBuilder("java", "Sumador.java",Integer.toString(n1),Integer.toString(n2)).directory(new File("src/prueba")).start();

        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read())!= -1){
            System.out.print((char)c);
        }
        }

    }
}
