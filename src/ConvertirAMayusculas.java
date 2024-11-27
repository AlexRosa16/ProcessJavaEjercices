public class ConvertirAMayusculas {

    // Método que convierte la cadena a mayúsculas
    public static String convertirAMayusculas(String texto) {
        return texto.toUpperCase();  // Convierte la cadena a mayúsculas
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java ConvertirAMayusculas <texto>");
            System.exit(1);  // Si no hay un argumento, termina con error
        }

        // Obtener el texto que se pasa como argumento
        String texto = args[0];

        // Convertir a mayúsculas y mostrar el resultado
        String resultado = convertirAMayusculas(texto);
        System.out.println("Texto en mayúsculas: " + resultado);
    }
}
