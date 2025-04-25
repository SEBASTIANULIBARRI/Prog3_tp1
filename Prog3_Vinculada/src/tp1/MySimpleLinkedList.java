package ProgramacionIII.tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements  Iterable<T>{

	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		size= 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		size++;
	}

	public T insertarOrdenado(T info) {
		// Crear el nuevo nodo con la información que deseas insertar
		Node<T> tmp = new Node<T>(info, null);
		Node<T> puntero = first;

		// Si la lista está vacía o el primer elemento es mayor que el nuevo
		if (puntero == null || puntero.getInfo().compareTo(tmp.getInfo()) > 0) {
			tmp.setNext(first);  // El nuevo nodo apunta al primer elemento
			this.first = tmp;    // El primer nodo de la lista es el nuevo
			size++;
		} else {
			// Recorre la lista hasta encontrar el lugar correcto para insertar
			while (puntero.getNext() != null && puntero.getNext().getInfo().compareTo(tmp.getInfo()) < 0) {
				puntero = puntero.getNext();
			}

			// Inserta el nuevo nodo después de 'puntero'
			tmp.setNext(puntero.getNext());
			puntero.setNext(tmp);
			size++;
		}

		return info;  // Retorna la información insertada
	}

	public T extractFront() {
		// TODO
		return first.getInfo();
	}

	private boolean posicionValida(int index){
		System.out.println("entre");
	return (!isEmpty() && index<size());

	}

	public T delete(int index){
		Node<T> puntero = first;
		Node<T> punteroAnterior = first;
		if(posicionValida(index)){
			for (int i = 0; i < index; i++) {
				if (i>0) punteroAnterior = punteroAnterior.getNext();
				puntero = puntero.getNext();
			}
		}
		punteroAnterior.setNext(puntero.getNext());
		puntero.setNext(null);
		return puntero.getInfo();
	}

	public boolean isEmpty() {
		// TODO
		return size==0;
	}

	public T get(int index) {
		// TODO
		if(posicionValida(index)){
			Node<T> puntero = first;
			for (int i = 0; i < index; i++) {
				puntero = puntero.getNext();
			}
			return puntero.getInfo();
		}
		return null;
	}

	public int size() {
		// TODO
		return size;
	}

	public int indexOf(T info){
		int index = 0;

		Node<T> puntero = first;
		while (puntero != null && !puntero.getInfo().equals( info)) {
			puntero = puntero.getNext();
			index++;
		}
		if(puntero == null){
			return -1;
		}
		return index;
	}

	@Override
	public String toString() {
		Node<T> puntero = first;
		if(puntero == null){
			return null;
		}

		String texto = "";
		int i = 0;
		while (puntero != null && i <size()) {
			texto += puntero.getInfo() + " > ";
			puntero = puntero.getNext();
			i++;
		}
		return texto;
	}

	@Override
	public MyIterator<T> iterator() {
		return new MyIterator<T>(this.first);
	}
}