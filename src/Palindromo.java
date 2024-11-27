import java.io.*;

public class Palindromo {

    // Método para verificar si la cadena es un palíndromo
    public static boolean esPalindromo(String texto) {
        // Eliminar caracteres no alfabéticos y convertir a minúsculas
        String limpio = texto.replaceAll("[^a-zA-Z]", "").toLowerCase();
        // Crear una versión invertida de la cadena
        String invertido = new StringBuilder(limpio).reverse().toString();
        // Comparar la cadena original limpia con la invertida
        return limpio.equals(invertido);
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java Palindromo <texto>");
            System.exit(1);  // Si no hay un argumento, termina con error
        }

        String texto = args[0];  // Obtener el texto que se pasa como argumento

        boolean esPalindromo = esPalindromo(texto);  // Verificar si es palíndromo

        // Escribir en los archivos correspondientes
        try {
            // Abrir los archivos en modo append (agregar contenido)
            FileWriter todasWriter = new FileWriter("todas.txt", true);
            FileWriter palindromoWriter = new FileWriter("palindromo.txt", true);
            FileWriter nopalindromoWriter = new FileWriter("nopalindromo.txt", true);

            // Escribir el texto en todas.txt
            todasWriter.write(texto + "\n");

            // Si es palíndromo, escribir en palindromo.txt
            if (esPalindromo) {
                palindromoWriter.write(texto + "\n");
            } else {
                // Si no es palíndromo, escribir en nopalindromo.txt
                nopalindromoWriter.write(texto + "\n");
            }

            // Cerrar los archivos después de escribir
            todasWriter.close();
            palindromoWriter.close();
            nopalindromoWriter.close();

            System.out.println("El texto \"" + texto + "\" ha sido procesado.");

        } catch (IOException e) {
            System.err.println("Error al escribir en los archivos: " + e.getMessage());
        }
    }
}
