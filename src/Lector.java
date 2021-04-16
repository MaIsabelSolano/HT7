import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Lector {
    public ArrayList<Association> Lector_Asociaciones(int idioma) throws FileNotFoundException {
        ArrayList<Association> asociaciones = new ArrayList<>();
        File diccionario = new File("diccionario.txt");
        Scanner reader = new Scanner(diccionario);
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            String[] temp = data.split(",");
            Association<String, String> temp_As = new Association<>(temp[idioma],data);
        }
        return asociaciones;
    }

    public String Lector_Expresion(){
        String expresion = "";
        return expresion;
    }
}
