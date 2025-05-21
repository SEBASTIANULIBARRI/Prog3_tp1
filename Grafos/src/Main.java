import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3F);
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta

		Iterator<Integer> it = grafito.obtenerVertices();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println(i);
		}

		Iterator<Integer> it1 = grafito.obtenerAdyacentes(1);
		while (it1.hasNext()) {
			Integer i = it1.next();
			System.out.println(i);
		}
		Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();

		System.out.println(etiqueta);


	}

}
