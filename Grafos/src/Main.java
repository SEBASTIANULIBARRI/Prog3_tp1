import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Float> grafito = new GrafoDirigido<>();

		grafito.agregarVertice(10);
		grafito.agregarVertice(20);
		grafito.agregarVertice(30);
		grafito.agregarVertice(40);
		grafito.agregarVertice(50);
		grafito.agregarVertice(60);
		grafito.agregarVertice(70);

		grafito.agregarArco(10, 20, 1.0F);
		grafito.agregarArco(20, 30, 1.0F);
		grafito.agregarArco(30, 70, 1.0F);     // Camino corto: 10 → 20 → 30 → 70 (peso 3)

		grafito.agregarArco(10, 40, 1.0F);
		grafito.agregarArco(40, 50, 1.0F);
		grafito.agregarArco(50, 60, 1.0F);
		grafito.agregarArco(60, 70, 1.0F);

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



		grafito.dfs();

		grafito.bfs();

		System.out.println(grafito.tieneCiclos());

		System.out.println(grafito.caminoMasLargo(10,70));
		System.out.println(grafito.caminoMasCorto(10,70));
	}

}
