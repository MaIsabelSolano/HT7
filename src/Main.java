/**
 * Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Estructuras de datos y algoritmos
 * Profesor: Douglas Barrios
 * @author Maria Isabel Solano Bonilla 20504
 * @version 1
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        Lector lector = new Lector();
        int idioma_original = 0;
        int idioma_traduccion = 0;
        String id_or = "";
        String id_tr = "";
        String Error = "La opción ingresada no existe o no es valida";
        String[] idiomas_disponibles = {"Inglés","Español","Francés"};
        String expresion = "";

        //obtención de archivo
        BinarySearchTree<ComparableAssociation<String,String>> ingles = lector.Lector_Asociaciones2(0);
        BinarySearchTree<ComparableAssociation<String,String>> espanol = lector.Lector_Asociaciones2(1);
        BinarySearchTree<ComparableAssociation<String,String>> frances = lector.Lector_Asociaciones2(2);
        ArrayList<Association<String,String>> ingles_ = lector.Lector_Asociaciones(0);
        ArrayList<Association<String,String>> espanol_ = lector.Lector_Asociaciones(1);
        ArrayList<Association<String,String>> frances_ = lector.Lector_Asociaciones(2);

        //inicio del programa
        System.out.println("BIENVENIDO/A AL TRADUCTOR");
        while (!expresion.toLowerCase().equals("salir")){
            //Obtener el los idiomas
            boolean ver1 = false;
            while (!ver1){
                try {
                    System.out.println("_______________________________________________________________");
                    System.out.println("De qué idioma desea traducir? (Escriba el acrónimo del idioma)");
                    System.out.println("Eng | Esp | Fr");

                    id_or = scan.nextLine();

                    expresion = lector.Lector_Expresion();
                    //determinar el idioma original
                    //obtener segundo idioma
                    switch (id_or.toLowerCase()) {
                        case "eng" -> {
                            idioma_original = 0;
                            System.out.println("_______________________________________________________________");
                            System.out.println("A qué idioma desea traducir? [Esp | Fr]");
                            id_tr = scan.nextLine();
                            if (id_tr.toLowerCase().equals("esp")) {
                                idioma_traduccion = 1;
                                //Traducir(expresion,ingles,idioma_traduccion);
                                Traducir2(expresion,ingles_,idioma_traduccion);

                                ver1 = true; //se puede salir del ciclo
                            } else if (id_tr.toLowerCase().equals("fr")) {
                                idioma_traduccion = 2;
                                //Traducir(expresion,ingles,idioma_traduccion);
                                Traducir2(expresion,ingles_,idioma_traduccion);
                                ver1 = true; //se puede salir del ciclo
                            } else {
                                System.out.println(Error);
                                //Se repite el ciclo
                            }
                        }
                        case "esp" -> {
                            idioma_original = 1;
                            System.out.println("_______________________________________________________________");
                            System.out.println("A qué idioma desea traducir? [Eng | Fr]");
                            id_tr = scan.nextLine();
                            if (id_tr.toLowerCase().equals("eng")) {
                                idioma_traduccion = 0;
                                //Traducir(expresion,espanol,idioma_traduccion);
                                Traducir2(expresion,espanol_,idioma_traduccion);
                                ver1 = true; //se puede salir del ciclo
                            } else if (id_tr.toLowerCase().equals("fr")) {
                                idioma_traduccion = 2;
                                //Traducir(expresion,espanol,idioma_traduccion);
                                Traducir2(expresion,espanol_,idioma_traduccion);
                                ver1 = true; //se puede salir del ciclo
                            } else {
                                System.out.println(Error);
                                //Se repite el ciclo
                            }
                        }
                        case "fr" -> {
                            idioma_original = 2;
                            System.out.println("_______________________________________________________________");
                            System.out.println("A qué idioma desea traducir? [Eng | Esp]");
                            id_tr = scan.nextLine();
                            if (id_tr.toLowerCase().equals("esp")) {
                                idioma_traduccion = 1;
                                //Traducir(expresion,frances,idioma_traduccion);
                                Traducir2(expresion,frances_,idioma_traduccion);
                                ver1 = true; //se puede salir del ciclo
                            } else if (id_tr.toLowerCase().equals("eng")) {
                                idioma_traduccion = 0;
                                //Traducir(expresion,espanol,idioma_traduccion);
                                Traducir2(expresion,frances_,idioma_traduccion);
                                ver1 = true; //se puede salir del ciclo
                            } else {
                                System.out.println(Error);
                                //Se repite el ciclo
                            }
                        }
                        default -> System.out.println(Error);
                    }
                }
                catch (InputMismatchException ime){
                    System.out.println(Error);
                    scan.nextLine();
                }
            }

            System.out.println("Idioma original: "+idiomas_disponibles[idioma_original]);
            System.out.println("Idioma a traducir: "+idiomas_disponibles[idioma_traduccion]);

            //Iniciar traducción
            System.out.println("_______________________________________________________________");
            System.out.println("\nDe click en ENTER para repetir\n(O ingrese la palabra SALIR para finalizar el programa");
            expresion = scan.nextLine();
        }
    }

    /**
     * Realiza la traducción
     * @param expresion String con la frase a traducir
     * @param bst diccionario con las palabras
     * @param idioma número del idioma al que se quiere traducir (0 Inglés, 1 Español, 2 Francés)
     */
    public static void Traducir(String expresion, BinarySearchTree<ComparableAssociation<String,String>> bst, int idioma){
        String[] temp = expresion.split(" ");
        ComparableAssociation<String,String> temp2 = new ComparableAssociation<>(temp[idioma],"");
        for(int i = 0;i<temp.length;i++){
            if (bst.contains(temp2)){
                temp[i] = "*"+bst.get(temp2).getValue().split(",")[idioma]+"*";
            }
        }

        //Volver todo un string que se lea
        StringBuilder sb = new StringBuilder();
        for (String s: temp){
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb.toString());

    }

    /**
     * Realiza la traducción
     * @param expresion String con la frase a traducir
     * @param dic diccionario con las palabras
     * @param idioma número del idioma al que se quiere traducir (0 Inglés, 1 Español, 2 Francés)
     */
    public static void Traducir2(String expresion, ArrayList<Association<String, String>> dic,int idioma){
        String[] temp = expresion.split(" ");
        for (int i = 0; i<temp.length; i++){
            for (int j = 0; j<dic.size(); j++){
                if (dic.get(j).Exists(temp[i])){
                    //remplazar la palabra por la traduccion
                    String[] temporal = dic.get(j).getValue().split(",");
                    temp[i] = "*"+temporal[idioma]+"*";
                }
            }
        }
        //Volver todo un string que se lea
        StringBuilder sb = new StringBuilder();
        for (String s: temp){
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
