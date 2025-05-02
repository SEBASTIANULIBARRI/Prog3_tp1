//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ABB<Integer> arbol = new ABB<>();
        arbol.add(5);
        arbol.add(3);
        arbol.add(8);
        arbol.add(1);
        arbol.add(9);
        arbol.add(11);
        arbol.add(13);

        arbol.printInOrder();
        System.out.println("el borrado de 1 fue : " + arbol.delete(1));
        System.out.println("el borrado de 1 fue : " + arbol.delete(3));
        arbol.printInOrder();

    }
}