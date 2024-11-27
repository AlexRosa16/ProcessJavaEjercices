package prueba;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Sumador{
    public static void main(String[] args) throws IOException {

        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        Sumador sumador = new Sumador();
        System.out.println(sumador.suma(n1,n2));

    }

    public int suma(int n1, int n2){
        int valorsuma = 0;
        for (int i = n1; i <= n2; i++) {
            valorsuma += i;

        }

        return valorsuma;
    }

}