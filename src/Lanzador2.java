import java.io.*;

public class Lanzador2 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java Lanzador <texto>");
            System.exit(1);
        }

        String texto = args[0];

        try {
            ProcessBuilder processBuilderMayusculas = new ProcessBuilder("java", "ConvertirAMayusculas", texto);
            Process processMayusculas = processBuilderMayusculas.start();

            BufferedReader readerMayusculas = new BufferedReader(new InputStreamReader(processMayusculas.getInputStream()));
            String line;
            while ((line = readerMayusculas.readLine()) != null) {
                System.out.println(line);
            }

            processMayusculas.waitFor();

            ProcessBuilder processBuilderPalindromo = new ProcessBuilder("java", "Palindromo", texto);
            Process processPalindromo = processBuilderPalindromo.start();

            BufferedReader readerPalindromo = new BufferedReader(new InputStreamReader(processPalindromo.getInputStream()));
            while ((line = readerPalindromo.readLine()) != null) {
                System.out.println(line);
            }

            processPalindromo.waitFor();

        } catch (Exception e) {
            System.err.println("Error al ejecutar los procesos: " + e.getMessage());
        }
    }
}
