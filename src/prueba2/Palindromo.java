package prueba2;

import java.io.*;
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = br.readLine();

        Palindromo palindromo = new Palindromo();
        boolean esPalindromo = palindromo.esPalindromo(cadena);

        FileWriter fw;

        if(esPalindromo){
            fw = new FileWriter("palindromo.txt",true);
            fw.write(cadena);
            fw.close();
        }
        else if(!esPalindromo){

            fw = new FileWriter("nopalindromo.txt",true);
            fw.write(cadena);
            fw.close();

        }

        fw = new FileWriter("todos.txt",true);
        fw.write(cadena);
        fw.close();


    }
    public static boolean esPalindromo(String texto) {
        String invertido = new StringBuilder(texto).reverse().toString();
        return invertido.equals(texto);
    }

}
