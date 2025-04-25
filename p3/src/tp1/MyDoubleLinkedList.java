package ProgramacionIII.tp1;

public class MyDoubleLinkedList<T extends Comparable<T>> implements  Iterable<T>{

	private Node<T> first;
	private int size;

	public MyDoubleLinkedList() {
		this.first = null;
		size= 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null,null);
		tmp.setNext(this.first);
		if(first != null) first.setPrevious(null);
		this.first = tmp;
		size++;
	}

	public T insertarOrdenado(T info) {
		// Crear el nuevo nodo con la información que deseas insertar
		Node<T> puntero = first;

		// Si la lista está vacía o el primer elemento es mayor que el nuevo
		if (puntero == null || puntero.getInfo().compareTo(info) > 0) {
			insertFront(info);
		} else {
			Node<T> tmp = new Node<T>(info, null,null);
			// Recorre la lista hasta encontrar el lugar correcto para insertar
			while (puntero.getNext() != null && puntero.getNext().getInfo().compareTo(tmp.getInfo()) < 0) {
				puntero = puntero.getNext();
			}

			// Inserta el nuevo nodo después de 'puntero'
			tmp.setNext(puntero.getNext());
			tmp.setPrevious(puntero);
			puntero.setNext(tmp);
			if (tmp.getNext() != null) {
				tmp.getNext().setPrevious(tmp);  // este paso es clave
			}
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


	public T delete(int index) {
		if (posicionValida(index)) {
		Node<T> eliminado;

		if (index == 0) {
			eliminado = first;
			first = first.getNext();
			if (first != null) {
				first.setPrevious(null);
			}
		} else {
			Node<T> puntero = first;
			for (int i = 0; i < index - 1; i++) {
				puntero = puntero.getNext();
			}

			eliminado = puntero.getNext();
			Node<T> siguiente = eliminado.getNext();

			puntero.setNext(siguiente);
			if (siguiente != null) {
				siguiente.setPrevious(puntero);
			}
		}

		size--;
		return eliminado.getInfo(); }
		return null;
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