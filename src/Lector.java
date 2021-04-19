import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Lector {
    public ArrayList<Association<String,String>> Lector_Asociaciones(int idioma) throws FileNotFoundException {
        ArrayList<Association<String,String>> asociaciones = new ArrayList<>();
        File diccionario = new File("diccionario.txt");
        Scanner reader = new Scanner(diccionario);
        while (reader.hasNextLine()){
            String data = reader.nextLine().toLowerCase();
            String[] temp = data.split(",");
            Association<String, String> temp_As = new Association<>(temp[idioma],data);
            asociaciones.add(temp_As);
        }
        return asociaciones;
    }

    public BinarySearchTree<ComparableAssociation<String,String>> Lector_Asociaciones2(int idioma) throws FileNotFoundException {
        BinarySearchTree<ComparableAssociation<String,String>> asociaciones = new BinarySearchTree<>();
        File diccionario = new File("diccionario.txt");
        Scanner reader = new Scanner(diccionario);
        while (reader.hasNextLine()){
            String data = reader.nextLine();
            String[] temp = data.split(",");
            ComparableAssociation<String, String> temp_As = new ComparableAssociation<>(temp[idioma],data);
            asociaciones.add(temp_As);
        }
        return asociaciones;
    }


    public String Lector_Expresion() throws FileNotFoundException{
        String expresion = "";
        File documento = new File("text.txt");
        Scanner reader = new Scanner(documento);
        while(reader.hasNextLine()){
            expresion = reader.nextLine(); //reemplaza la expresion
        }
        return expresion;
    }
}
