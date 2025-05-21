
import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, List<Arco<T>>> grafo = new HashMap<>();

    @Override
    public void agregarVertice(int verticeId) {
        if (!contieneVertice(verticeId)) {
            grafo.put(verticeId, new ArrayList<>());
        }
        // TODO Auto-generated method stub
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (contieneVertice(verticeId)) {
            // Borrar aristas salientes
            grafo.get(verticeId).clear();
            grafo.remove(verticeId);

            // Borrar aristas entrantes
            for (List<Arco<T>> listaAdyacentes : grafo.values()) {
                listaAdyacentes.removeIf(arco -> arco.getVerticeDestino() == verticeId);
            }
        }
    }
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            Arco<T> a = new Arco<>(verticeId1, verticeId2, etiqueta);
            grafo.get(verticeId1).add(a);
        }
        // TODO Auto-generated method stub
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contieneVertice(int verticeId) {
        // TODO Auto-generated method stub
        return grafo.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        // TODO Auto-generated method stub
        List<Arco<T>> adyacentes = grafo.get(verticeId1);
        return adyacentes != null && adyacentes.contains(new Arco<Integer>(verticeId1, verticeId2, 0));
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (!contieneVertice(verticeId1))
            return null;
        for (Arco<T> arco : grafo.get(verticeId1)) {
            if (arco.getVerticeDestino() == verticeId2) {
                return arco;
            }
        }

        return null; // si no se encontró el arco
    }

@Override
public int cantidadVertices() {
    // TODO Auto-generated method stub
    return grafo.keySet().size();
}

@Override
public int cantidadArcos() {
    // TODO Auto-generated method stub
    Iterator<Arco<T>> it = obtenerArcos();
    int count = 0;
    while (it.hasNext()) {
        it.next();
        count++;
    }
    return count;
}

@Override
public Iterator<Integer> obtenerVertices() {
    // TODO Auto-generated method stub
    return grafo.keySet().iterator();
}

@Override
public Iterator<Integer> obtenerAdyacentes(int verticeId) {
    if (!contieneVertice(verticeId))
        return Collections.emptyIterator();

    List<Arco<T>> adyacentes = grafo.get(verticeId);
    List<Integer> destinos = new ArrayList<>();

    for (Arco<T> arco : adyacentes) {
        destinos.add(arco.getVerticeDestino()); // suponiendo que tenés un getDestino()
    }

    return destinos.iterator();
}

@Override
public Iterator<Arco<T>> obtenerArcos() {
    // TODO Auto-generated method stub
    List<Arco<T>> todosLosArcos = new ArrayList<>();

    for (Integer i : grafo.keySet()) {
        Iterator<Arco<T>> it = obtenerArcos(i); // este es tu método por vértice
        while (it.hasNext()) {
            todosLosArcos.add(it.next());
        }
    }

    return todosLosArcos.iterator();
}

@Override
public Iterator<Arco<T>> obtenerArcos(int verticeId) {
    List<Arco<T>> arcos = grafo.get(verticeId);
    // TODO Auto-generated method stub
    return (arcos == null) ? null : arcos.iterator();
}


public void dfs(){
    Set<Integer> g = grafo.keySet();
    boolean[] visitados = new boolean[g.size()];
    for(Integer i : g ){
        if(!visitados[i]){
            Iterator<Integer> ady = obtenerAdyacentes(i);
            dfsRecursivo(ady,visitados);
        }
    }


}

private void dfsRecursivo(Iterator<Integer> it,boolean[] visitados){

}

}
