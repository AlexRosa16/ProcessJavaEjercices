package contadordeletras;

import java.io.*;

public class ContadorLetras {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        char caracter = br.readLine().charAt(0);

        try {

            ContadorLetras contadorLetras = new ContadorLetras();
            int numerocoincidencias = contadorLetras.cuantashay(caracter);

            System.out.println("La letra eligida se ha repetido en el fichero : " + numerocoincidencias + " veces");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int cuantashay(char letra) throws IOException {
        FileReader lector = new FileReader("palabras.txt");
        BufferedReader brl = new BufferedReader(lector);

        String line;

        int contador = 0;

        while ((line = brl.readLine()) != null){
            for (int i = 0; i < line.length(); i++){
                if (line.charAt(i) == letra){
                    contador++;
                }
            }

        }
        return contador;

    }
}
