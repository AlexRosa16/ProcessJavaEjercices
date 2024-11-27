import java.io.File;
import java.util.Scanner;

public class ProcessListPNG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario la ruta del directorio
        System.out.println("Introduce la ruta del directorio (por ejemplo, /micarpeta/fotos): ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // Verificar que la ruta es válida
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("La ruta proporcionada no es un directorio válido.");
            return;
        }

        // Listar todos los archivos PNG en el directorio
        File[] pngFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        // Mostrar resultados
        if (pngFiles != null && pngFiles.length > 0) {
            System.out.println("Archivos PNG encontrados:");
            for (File pngFile : pngFiles) {
                System.out.println(pngFile.getName());
            }
        } else {
            System.out.println("No se encontraron archivos PNG en el directorio.");
        }
    }
}
