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
		grafito.agregarArco(1, 3, 2.5F); // Arco de 1 a 3 con etiqueta 2.5
		grafito.agregarArco(2, 4, 1.0F); // Arco de 2 a 4 con etiqueta 1.0
		grafito.agregarArco(3, 5, 4.2F); // Arco de 3 a 5 con etiqueta 4.2
		grafito.agregarArco(4, 1, 0.8F); // Arco de 4 a 1 con etiqueta 0.8
		grafito.agregarArco(5, 2, 3.3F); // Arco de 5 a 2 con etiqueta 3.3
		grafito.agregarArco(2, 3, 2.0F); // Arco de 2 a 3 con etiqueta 2.0
		grafito.agregarArco(5, 4, 1.7F);

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
		grafito.dfs();
	}

}
