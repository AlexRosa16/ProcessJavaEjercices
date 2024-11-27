import java.io.IOException;

public class ProcessKillNotepad {
    public static void main(String[] args) {
        Process process = null;

        try {
            // Iniciar el Bloc de notas en Windows o gedit en Linux
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                process = new ProcessBuilder("notepad").start(); // Inicia el Bloc de notas en Windows
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                process = new ProcessBuilder("gedit").start(); // Inicia gedit en Linux/Mac
            } else {
                System.err.println("Sistema operativo no compatible.");
                return;
            }

            System.out.println("El editor de texto se ha iniciado. Esperando 10 segundos...");

            // Esperar 10 segundos
            Thread.sleep(10000);

            // Terminar el proceso
            if (process.isAlive()) {
                process.destroy();
                System.out.println("El editor de texto ha sido finalizado.");
            } else {
                System.out.println("El editor de texto ya se había cerrado.");
            }

        } catch (IOException e) {
            System.err.println("Error al iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Error en el tiempo de espera: " + e.getMessage());
        } finally {
            if (process != null && process.isAlive()) {
                process.destroy(); // Asegurarse de terminar el proceso si aún está activo
            }
        }
    }
}
