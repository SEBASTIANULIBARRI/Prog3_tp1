
import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private LinkedHashMap<Integer, List<Arco<T>>> grafo = new LinkedHashMap<>();


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


    public void dfs() {

        Map<Integer, Boolean> visitados = new HashMap<>();
        Iterator<Integer> it1 = obtenerVertices();
        while (it1.hasNext()) {
            int v = it1.next();
            visitados.put(v, false);
        }

        it1 = obtenerVertices(); // reiniciar iterador
        while (it1.hasNext()) {
            int v = it1.next();
            if (!visitados.get(v)) {
                dfsRecursivo(v, visitados);
            }
        }


    }

    private void dfsRecursivo(Integer v, Map<Integer, Boolean> visitados) {
        System.out.println("pase por " + v);
        visitados.put(v, true);
        Iterator<Integer> it1 = obtenerAdyacentes(v);
        while (it1.hasNext()) {
            Integer i = it1.next();
            if (!visitados.get(i)) dfsRecursivo(i, visitados);
        }
    }


    public void bfs() {
        //Tomo el primer vertice
        Iterator<Integer> it1 = obtenerVertices();
        if (it1 == null) return;
        Map<Integer, Boolean> visitados = new HashMap<>();
        while (it1.hasNext()) {
            int v = it1.next();
            visitados.put(v, false);
        }
        it1 = obtenerVertices();

        Queue<Integer> fila = new LinkedList<>();
        while (it1.hasNext()) {
            Integer i = it1.next();
            if (!visitados.get(i)) {
                fila.add(i);
                visitados.put(i, true);
            }
            while (!fila.isEmpty()) {
                Integer first = fila.poll();
                System.out.println("Visitando: " + first);
                Iterator<Integer> itAdy = obtenerAdyacentes(first);
                while (itAdy.hasNext()) {
                    Integer ady = itAdy.next();
                    if (!visitados.getOrDefault(ady, true)) {
                        fila.add(ady);
                        visitados.put(ady, true);
                    }
                }

            }
        }
    }

    public boolean tieneCiclos() {
        Map<Integer, String> visitados = new HashMap<>();
        Iterator<Integer> it1 = obtenerVertices();
        while (it1.hasNext()) {
            int v = it1.next();
            visitados.put(v, "Blanco");
        }

        it1 = obtenerVertices(); // reiniciar iterador
        Boolean encontreCiclo = false;
        while (it1.hasNext() && !encontreCiclo) {
            int v = it1.next();
            if (visitados.get(v).equals("Blanco")) {
                encontreCiclo = ciclosRecursivo(v, visitados);
            }
        }
        return encontreCiclo;

    }

    private boolean ciclosRecursivo(Integer v, Map<Integer, String> visitados) {
        System.out.println("pase por " + v);
        visitados.put(v, "Gris");
        Iterator<Integer> it1 = obtenerAdyacentes(v);
        while (it1.hasNext()) {
            Integer i = it1.next();
            if (visitados.get(i).equals("Blanco")) return ciclosRecursivo(i, visitados);
            if (visitados.get(i).equals("Gris")) return true;

        }
        visitados.put(v, "Negro");
        return false;
    }

    public List<Integer> caminoMasLargo(int v1, int v2) {
        Map<Integer, Boolean> visitados = new HashMap<>();
        Iterator<Integer> it1 = obtenerVertices();
        while (it1.hasNext()) {
            int v = it1.next();
            visitados.put(v, false);
        }

        List<Integer> solParcial = new ArrayList<>();
        List<Integer> mejorSolucion = new ArrayList<>();

        solParcial.add(v1);

        visitados.put(v1, true);
        caminoMasLargoRecursivo(v1, v2, solParcial, mejorSolucion, visitados);
        return mejorSolucion;
    }
    private void caminoMasLargoRecursivo(int vActual, int vDestino, List<Integer> solucionParcial, List<Integer> mejorSolucion, Map<Integer, Boolean> visitados) {
        if (vActual == vDestino) {
            if (solucionParcial.size() > mejorSolucion.size()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(solucionParcial); // copiar contenido
            }
        } else {
            Iterator<Integer> it1 = obtenerAdyacentes(vActual);
            while (it1.hasNext()) {
                Integer vertice = it1.next();
                if (!visitados.getOrDefault(vertice, false)) {
                    visitados.put(vertice, true);
                    solucionParcial.add(vertice);

                    caminoMasLargoRecursivo(vertice, vDestino, solucionParcial, mejorSolucion, visitados);

                    solucionParcial.remove(solucionParcial.size() - 1); // backtrack
                    visitados.put(vertice, false); // backtrack
                }
            }
        }
    }
    public List<Integer> caminoMasCorto(int v1, int v2) {
        Map<Integer, Boolean> visitados = new HashMap<>();
        Iterator<Integer> it1 = obtenerVertices();
        while (it1.hasNext()) {
            int v = it1.next();
            visitados.put(v, false);
        }

        List<Integer> solParcial = new ArrayList<>();
        List<Integer> mejorSolucion = new ArrayList<>();

        solParcial.add(v1);

        visitados.put(v1, true);
        caminoMasCortoRecursivo(v1, v2, solParcial, mejorSolucion, visitados);
        return mejorSolucion;
    }

    private void caminoMasCortoRecursivo(int vActual, int vDestino, List<Integer> solucionParcial, List<Integer> mejorSolucion, Map<Integer, Boolean> visitados) {
        if (vActual == vDestino) {
            if (solucionParcial.size() < mejorSolucion.size() || mejorSolucion.isEmpty()) {
                mejorSolucion.clear();
                mejorSolucion.addAll(solucionParcial); // copiar contenido
            }
        } else {
            Iterator<Integer> it1 = obtenerAdyacentes(vActual);
            while (it1.hasNext()) {
                Integer vertice = it1.next();
                if (!visitados.getOrDefault(vertice, false)) {
                    visitados.put(vertice, true);
                    solucionParcial.add(vertice);

                    caminoMasCortoRecursivo(vertice, vDestino, solucionParcial, mejorSolucion, visitados);

                    solucionParcial.remove(solucionParcial.size() - 1); // backtrack
                    visitados.put(vertice, false); // backtrack
                }
            }
        }
    }
}