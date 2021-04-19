/**
 * Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Estructuras de datos y algoritmos
 * Profesor: Douglas Barrios
 * @author Maria Isabel Solano Bonilla 20504
 * @version 1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Lector {
    /**
     *
     * @param idioma el idioma del diccionario. 0 Inglés, 1 Español, 2 Francés
     * @return ArrayList de asociaciones
     * @throws FileNotFoundException
     */
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

    /**
     *
     * @param idioma el idioma del diccionario. 0 Inglés, 1 Español, 2 Francés
     * @return Un binary search tree de asociaciones comparables
     * @throws FileNotFoundException
     */
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

    /**
     *
     * @return String con la expresion que se quiere traducir
     * @throws FileNotFoundException
     */
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
