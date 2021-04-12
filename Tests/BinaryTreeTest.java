import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void value() {
    }

    @Test
    void prueba(){
        BinaryTree<String> trial = new BinaryTree<String>("a");
        BinaryTree<String> trial2 = new BinaryTree<String>("b");
        BinaryTree<String> trial3 = new BinaryTree<String>("c",trial,trial2);

        BinaryTree<String> impresion = trial3;
        while (!impresion.left.isEmpty()){
            impresion = impresion.left();
            System.out.println(impresion.value());
        }
    }

    @Test
    /*
    void pruebaArrayStrings(){
        BinaryTree<String[]> izquierda = new BinaryTree<String[]>({"1","2","3"});
        BinaryTree<String[]> derecha = new BinaryTree<String[]>({"a","b","c"});
        BinaryTree<String[]> padre = new BinaryTree<String[]>({"x","y","z"},izquierda,derecha);

        BinaryTree<String[]> impresion = padre;
        while (!impresion.left.isEmpty()){
            impresion = impresion.left();
            System.out.println(impresion);
        }
    }

     */


    void prueba2(){
        BinaryTree<String> trial = new BinaryTree<String>("a,aa,aaa");
        BinaryTree<String> trial2 = new BinaryTree<String>("b,bb,bbb");
        BinaryTree<String> trial3 = new BinaryTree<String>("c,cc,ccc",trial,trial2);

        BinaryTree<String> impresion = trial3;
        while (!impresion.left.isEmpty()){
            impresion = impresion.left();
            String[] impresion2 = impresion.value().split(",");
            System.out.println(impresion2[2]);
        }
    }
}