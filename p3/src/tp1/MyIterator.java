package ProgramacionIII.tp1;

import java.util.Iterator;

public class MyIterator<T extends Comparable<T>> implements Iterator<T> {
    private Node<T> cursor;

    public MyIterator(Node<T> cursor) {
        this.cursor = cursor;
    }


    public T getValor() {
        T info = this.cursor.getInfo();
        return info;
    }
    @Override
    public T next() {
        T info = this.cursor.getInfo();

        this.cursor = this.cursor.getNext();
        return info;
    }
    public boolean hasNext() {
        return cursor != null && cursor.getNext() != null;
    }

    public boolean hasPrevious() {
        return cursor != null && cursor.getPrevious() != null;
    }


    public T previous() {
        T info = cursor.getInfo();
        cursor = cursor.getPrevious();
        return info;
    }
}
