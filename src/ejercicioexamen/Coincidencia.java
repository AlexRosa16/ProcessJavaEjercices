package ejercicioexamen;

import java.io.*;

public class Coincidencia {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String cadena = br.readLine();

        try {

            Coincidencia coincidencia = new Coincidencia();
            boolean existe = coincidencia.siexiste(cadena);

            FileWriter fw;

            if(existe){
                fw = new FileWriter("palabras.txt",true);
                fw.write("\n" + "siesta");
                fw.close();
                System.out.println("La cadena si estaba en el fichero");
            }else{
                fw = new FileWriter("palabras.txt",false);
                fw.close();
                System.out.println("La cadena no estaba en el fichero");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean siexiste(String texto) throws IOException {
        FileReader lector = new FileReader("palabras.txt");
        BufferedReader brl = new BufferedReader(lector);

        String line;
        boolean esta = false;


        while ((line = brl.readLine()) != null){
            if (texto.equals(line)){
                esta = true;
            }
        }

        return esta;

    }
}
