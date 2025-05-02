import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static <T extends Comparable<T>> boolean estaOrdenadoAscendente(List<T> elementos, int indiceActual, T valorActual) {
        if (indiceActual == elementos.size()) {
            return true;
        }
        T valor = elementos.get(indiceActual);
        if (valor == null || (valorActual != null && valorActual.compareTo(valor) > -1)) return false;
        else
            return estaOrdenadoAscendente(elementos, indiceActual + 1, valor);
    }

    static <T extends Comparable<T>> boolean find(List<T> elementos, int indiceActual, T valorBuscado) {
        //Casos Hoja

        if (elementos.size() < indiceActual || elementos.get(indiceActual).compareTo(valorBuscado) > 0) return false;
        if (elementos.get(indiceActual).equals(valorBuscado)) return true;
        //recursion
        return find(elementos, indiceActual + 1, valorBuscado);
    }

    static String toBinary(int number) {

        if (number == 0) return "0";
        if (number == 1) return "1";

        if (number >= 2) {
            String resto = "" + number % 2;
            int cociente = number / 2;
            return toBinary(cociente) + resto;
        }
        return "Cannot convert " + number + " to binary.";
    }

    static void fibonacci(List<Integer> resultado, int ciclo, int number) {
        if (ciclo == 0 || ciclo == 1) {
            resultado.add(ciclo);
            fibonacci(resultado, ciclo + 1, number);
        } else if (ciclo < number) {
            resultado.add(resultado.get(ciclo - 1) + resultado.get(ciclo - 2));
            fibonacci(resultado, ciclo + 1, number);
        }

    }

    static int equalsToPosition(List<Integer> elements, int index) {
        // Returns the index if there exists an element such that A[index] == index; otherwise, returns -1.
        if (index > elements.size()) return -1;
        int comparison = elements.get(index).compareTo(index);
        if (comparison == 0) return index;
        if (comparison > 0) return -1;

        return equalsToPosition(elements, index + 1);
    }

    static int buscarMenor(int[] elements, int index) {
        int menor = index;
        for (int i = index; i < elements.length; i++) {
            if (elements[i] < elements[menor]) menor = i;
        }
        return menor;
    }

    static void intercambio(int[] elements, int pos, int posIntercambio) {
        int aux = elements[pos];
        elements[pos] = elements[posIntercambio];
        elements[posIntercambio] = aux;
    }

    static void bubbleSort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {

            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) intercambio(elements, j, j + 1);
            }
        }
    }

    static void bubbleSortOp(int[] elements) {
        boolean changes = true;
        int i = 0;
        while (i < elements.length && changes) {
            changes = false;
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    intercambio(elements, j, j + 1);
                    changes = true;
                }
            }
            i++;
        }
    }

    static Random random = new Random();

    // Crea un arreglo de n elementos aleatorios
    static int[] generarArregloAleatorio(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10000); // valores entre 0 y 9999
        }
        return array;
    }

    static void seleccionSort(int[] elements) {
        int contador = 0;
        while (contador < elements.length) {
            //busca la posicion del menor
            int menor = buscarMenor(elements, contador);
            //Intercambio
            intercambio(elements, contador, menor);
            contador++;
        }
    }

    static void printArray(int[] numbers) {
        int tamanio = numbers.length - 1;
        System.out.printf("[");
        for (int i = 0; i < tamanio; i++) {
            System.out.printf(numbers[i] + ",");
        }
        System.out.printf(numbers[tamanio] + "] \n");
    }

    public static void main(String[] args) {

        // List<Integer> elementos = new ArrayList<>();
        // elementos.add(1);
        // elementos.add(3);
        // elementos.add(5);

        //for (int i = 0; i < 1; i++) {
//
        //    System.out.println("Binario de " + i + ": " + toBinary(i));
        //}
        //List l1 = new ArrayList<>();
        //fibonacci(l1,0,6);
        //System.out.println("Fibonacci " +l1 );
        //System.out.println("Esta ordenado? " + estaOrdenadoAscendente(elementos, 0, null));
//
        //System.out.println("esta el 2?" + find(elementos, 0, 2));
//
        //List<Integer> list = new ArrayList<>();
        //list.add(-3);
        //list.add(-1);
        //list.add(0);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        //list.add(6);
//
        //System.out.println("Exist any element equals to position? " + equalsToPosition(list,0));

        int[] numbers = generarArregloAleatorio(1000);
        int[] numbers2 =  numbers.clone();
        int[] numbers3 =  numbers.clone();

        printArray(numbers);
        System.out.println("Ordenar con selection sort");
        long inicio = System.nanoTime();

        seleccionSort(numbers);
        long fin = System.nanoTime();

        long duracion = (fin - inicio) / 1000 ;
        System.out.println("Tardo " + duracion + " M_Segs");

        printArray(numbers);


        printArray(numbers2);
        System.out.println("Ordenar con bubble sort");
        inicio = System.nanoTime();

        bubbleSort(numbers2);
        fin = System.nanoTime();

        duracion = (fin - inicio) / 1000;
        printArray(numbers2);
        System.out.println("Tardo " + duracion + " M_Segs");

        printArray(numbers3);
        System.out.println("Ordenar con bubble sort OP");
        inicio = System.nanoTime();

        bubbleSortOp(numbers3);
        fin = System.nanoTime();

        duracion = (fin - inicio) / 1000;
        System.out.println("Tardo " + duracion + " M_Segs");
        printArray(numbers3);

    }
}