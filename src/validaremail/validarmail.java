package validaremail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class validarmail {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena = br.readLine();

        try {
            validarmail validomail = new validarmail();
            boolean validado = validomail.esvalidomail(cadena);

            if(validado){
                System.out.println("El email es valido");
            }else{
                System.out.println("El email no es valido");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean esvalidomail(String mail){

        boolean contienearroba = false;
        char arroba = '@';

        for (int i = 0; i < mail.length(); i++){
            if (mail.charAt(i) == arroba){
                contienearroba = true;
            }
        }
        if(contienearroba){

            String [] mailcompleto = mail.split("@");
            if (mailcompleto.length != 2){
                return false;
            }
            if(!mailcompleto[1].contains(".")){
                return false;
            }

            if (mailcompleto[1].startsWith(".") || mailcompleto[1].endsWith(".")){
                return false;
            }

            if (mailcompleto[0].startsWith(".") || mailcompleto[0].endsWith(".")){
                return false;
            }

            String[] domainSections = mail.split("\\.");
            for (String section : domainSections) {
                if (section.isEmpty()) {
                    return false;
                }
            }

            return true;

        }else{
            return false;
        }


    }
}
