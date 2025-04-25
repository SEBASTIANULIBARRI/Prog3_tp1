import java.util.ArrayList;
import java.util.List;

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

    static void fibonacci(List<Integer> resultado,int ciclo, int number) {
        if(ciclo == 0 ||  ciclo == 1){
            resultado.add(ciclo);
            fibonacci(resultado,ciclo + 1,number);
        }
        else if (ciclo<number){
            resultado.add(resultado.get(ciclo-1) + resultado.get(ciclo-2));
            fibonacci(resultado,ciclo + 1,number);
        }

    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<Integer> elementos = new ArrayList<>();
        elementos.add(1);
        elementos.add(3);
        elementos.add(5);

        for (int i = 0; i < 1; i++) {

            System.out.println("Binario de " + i + ": " + toBinary(i));
        }
        List l1 = new ArrayList<>();
        fibonacci(l1,0,6);
        System.out.println("Fibonacci " +l1 );
        System.out.println("Esta ordenado? " + estaOrdenadoAscendente(elementos, 0, null));

        System.out.println("esta el 2?" + find(elementos, 0, 2));
    }
}