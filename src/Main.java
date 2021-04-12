import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Lector lector = new Lector("ASOCIACIONES.txt");
        int idioma_original = 0;
        int idioma_traduccion = 0;
        String id_or = "";
        String id_tr = "";
        String Error = "La opción ingresada no existe o no es valida";
        String[] idiomas_disponibles = {"Inglés","Español","Francés"};
        String expresion = "";

        //obtención de archivos


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
                                ver1 = true; //se puede salir del ciclo
                            } else if (id_tr.toLowerCase().equals("fr")) {
                                idioma_traduccion = 2;
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
                                ver1 = true; //se puede salir del ciclo
                            } else if (id_tr.toLowerCase().equals("fr")) {
                                idioma_traduccion = 2;
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
                                ver1 = true; //se puede salir del ciclo
                            } else if (id_tr.toLowerCase().equals("eng")) {
                                idioma_traduccion = 0;
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
            System.out.println("\nIngrese la frase que desea traducir:\n(O ingrese la palabra SALIR para finalizar el programa");
            expresion = scan.nextLine();
        }
    }
}
