import java.util.Vector;

public class Main_2 {
    static Vector<Integer> merge(Vector<Integer> izq, Vector<Integer> der) {
        Vector<Integer> resultado = new Vector<>();
        int i = 0, j = 0;

        while (i < izq.size() && j < der.size()) {
            if (izq.get(i) <= der.get(j)) {
                resultado.add(izq.get(i));
                i++;
            } else {
                resultado.add(der.get(j));
                j++;
            }
        }

        // Agregar elementos que hayan quedado
        while (i < izq.size()) {
            resultado.add(izq.get(i));
            i++;
        }
        while (j < der.size()) {
            resultado.add(der.get(j));
            j++;
        }

        return resultado;
    }

    static Vector<Integer> mergeSort(Vector<Integer> numbers, int inicio, int fin) {
        if (inicio == fin) {
            Vector<Integer> unico = new Vector<>();
            unico.add(numbers.get(inicio));
            return unico;
        }
        int medio = (inicio + fin) / 2;
        Vector<Integer> izq = mergeSort(numbers, inicio, medio);
        Vector<Integer> der = mergeSort(numbers, medio + 1, fin);

        return merge(izq, der);
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

        Vector<Integer> ordenado = mergeSort(desordenado,0,desordenado.size()-1);

        System.out.println(ordenado);
    }
}
