package ProgramacionIII.tp1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static <T extends Comparable<T>>  MySimpleLinkedList<T> unionListas(MySimpleLinkedList<T> lista1,MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> listaFinal = new MySimpleLinkedList<T>();
        for(T elemento : lista1){
            if (lista2.indexOf(elemento) > -1)
                listaFinal.insertarOrdenado(elemento);
        }
        return listaFinal;
    }

    static <T extends Comparable<T>>  MySimpleLinkedList<T> unionListasOrdenadas(MySimpleLinkedList<T> lista1,MySimpleLinkedList<T> lista2) {
        MySimpleLinkedList<T> listaFinal = new MySimpleLinkedList<T>();
        MyIterator<T> iter1 = lista1.iterator();
        MyIterator<T> iter2 = lista2.iterator();
        while (iter1.hasNext()&&iter2.hasNext()){
            int comparador = (iter1.getValor().compareTo(iter2.getValor()));
            if (comparador < 0){
                iter1.next();
            } else if (comparador >0 ){
                iter2.next();
            }
            else {
                listaFinal.insertarOrdenado(iter1.getValor());
                iter1.next();
                iter2.next();
            }

        }

        return listaFinal;
    }

    static <T extends Comparable<T>>  MySimpleLinkedList<T> diferenciaListas(MySimpleLinkedList<T> lista1,MySimpleLinkedList<T> lista2){
        MySimpleLinkedList<T> listaFinal = new MySimpleLinkedList<T>();
        for(T elemento : lista1){
            if (lista2.indexOf(elemento) == -1)
                listaFinal.insertarOrdenado(elemento);
        }
        return listaFinal;
    }

    public static void main(String[] args){
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista3 = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista4 = new MySimpleLinkedList<Integer>();

        Node<Integer> n1 = new Node<Integer>(1,null);
        Node<Integer> n2 = new Node<Integer>(2,null);
        Node<Integer> n3 = new Node<Integer>(3,null);
        Node<Integer> n4 = new Node<Integer>(4,null);
        Node<Integer> n5 = new Node<Integer>(5,null);

        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros); // Desordenar la lista

        for (int num : numeros) {
            lista.insertarOrdenado(num);
        }

        Collections.shuffle(numeros);
        for (int num : numeros) {
            lista2.insertarOrdenado(num);
        }


        long inicio = System.nanoTime();
        MySimpleLinkedList<Integer> listaFinal = unionListasOrdenadas(lista,lista2);
        long fin = System.nanoTime();

        System.out.println(listaFinal);
        long duracion = fin - inicio;     // Duración en nanosegundos

        System.out.println("Duración: " + duracion + " nanosegundos");
        System.out.println("Duración: " + (duracion / 1_000_000.0) + " milisegundos");



        Collections.shuffle(numeros);
        for (int i = 0; i < numeros.size()/2; i++) {
            lista3.insertFront(numeros.get(i));
        }

        long inicio2 = System.nanoTime();
        MySimpleLinkedList<Integer> listaFinal3 = diferenciaListas(lista,lista3);
        long fin2 = System.nanoTime();

        System.out.println("DIFERENCIA : " + listaFinal3);
        long duracion2 = fin2 - inicio2;     // Duración en nanosegundos

        System.out.println("Duración: " + duracion2 + " nanosegundos");
        System.out.println("Duración: " + (duracion2 / 1_000_000.0) + " milisegundos");
    }
}
