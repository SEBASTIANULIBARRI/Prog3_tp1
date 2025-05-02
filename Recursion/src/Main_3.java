import java.util.Vector;

public class Main_3 {
    static void intercambio(Vector<Integer> elements, int pos, int posIntercambio) {
        int aux = elements.get(pos);
        elements.set(pos, elements.get(posIntercambio));
        elements.set(posIntercambio, aux);
    }

    static int pivotar(Vector<Integer> numbers, int inicio, int fin) {
        int pivote = numbers.get(inicio);
        int i = inicio + 1;
        int j = fin;

        while (i <= j) {
            while (i <= fin && numbers.get(i) <= pivote) {
                i++;
            }
            while (numbers.get(j) > pivote) {
                j--;
            }
            if (i < j) {
                intercambio(numbers, i, j);
            }
        }
        intercambio(numbers, inicio, j); // colocamos el pivote en su lugar
        return j;
    }

    static void quickSort(Vector<Integer> numbers, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int posicionPivote = pivotar(numbers, inicio, fin);
        quickSort(numbers, inicio, posicionPivote - 1);
        quickSort(numbers, posicionPivote + 1, fin);
    }

    public static void main(String[] args) {
        Vector<Integer> desordenado = new Vector<>();
        desordenado.add(42);
        desordenado.add(7);
        desordenado.add(19);
        desordenado.add(3);
        desordenado.add(55);
        desordenado.add(1);
        desordenado.add(24);
        desordenado.add(15);
        desordenado.add(38);
        desordenado.add(9);
        desordenado.add(17);
        desordenado.add(31);
        desordenado.add(5);
        desordenado.add(46);
        desordenado.add(20);
        desordenado.add(2);
        desordenado.add(29);
        desordenado.add(11);
        desordenado.add(6);
        desordenado.add(27);

        quickSort(desordenado, 0, desordenado.size() - 1);

        System.out.println(desordenado);

    }
}
