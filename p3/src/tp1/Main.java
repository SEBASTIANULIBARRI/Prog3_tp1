package ProgramacionIII.tp1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static <T extends Comparable<T>>  MyDoubleLinkedList<T> unionListas(MyDoubleLinkedList<T> lista1,MyDoubleLinkedList<T> lista2) {
        MyDoubleLinkedList<T> listaFinal = new MyDoubleLinkedList<T>();
        for(T elemento : lista1){
            if (lista2.indexOf(elemento) > -1)
                listaFinal.insertarOrdenado(elemento);
        }
        return listaFinal;
    }

    static <T extends Comparable<T>>  MyDoubleLinkedList<T> unionListasOrdenadas(MyDoubleLinkedList<T> lista1,MyDoubleLinkedList<T> lista2) {
        MyDoubleLinkedList<T> listaFinal = new MyDoubleLinkedList<T>();
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

    static <T extends Comparable<T>>  MyDoubleLinkedList<T> diferenciaListas(MyDoubleLinkedList<T> lista1,MyDoubleLinkedList<T> lista2){
        MyDoubleLinkedList<T> listaFinal = new MyDoubleLinkedList<T>();
        for(T elemento : lista1){
            if (lista2.indexOf(elemento) == -1)
                listaFinal.insertarOrdenado(elemento);
        }
        return listaFinal;
    }

    public static void main(String[] args){
        MyDoubleLinkedList<Integer> lista = new MyDoubleLinkedList<Integer>();
        MyDoubleLinkedList<Integer> lista2 = new MyDoubleLinkedList<Integer>();
        MyDoubleLinkedList<Integer> lista3 = new MyDoubleLinkedList<Integer>();
        MyDoubleLinkedList<Integer> lista4 = new MyDoubleLinkedList<Integer>();


        lista.insertarOrdenado(10);
        lista.insertarOrdenado(5);
        lista.insertarOrdenado(15);
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(12);

        lista.delete(0); // Borra el primero (5)
        lista.delete(2); // Borra el que estaba en posición 2 (15)


        System.out.println(lista);
        MyIterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }



    }
}
