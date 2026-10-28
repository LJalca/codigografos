/**
 * Implementación de un Grafo mediante Matriz de Adyacencia en Java.
 * Permite modelar grafos dirigidos o no dirigidos con pesos enteros.
 */
public class GrafoMatriz {
    private final int numVertices;
    private final int[][] matriz;
    private final String[] nombresVertices;
    private final boolean dirigido;

    public GrafoMatriz(String[] nombresVertices, boolean dirigido) {
        if (nombresVertices == null || nombresVertices.length == 0) {
            throw new IllegalArgumentException("El grafo debe tener al menos un vertice.");
        }
        this.numVertices = nombresVertices.length;
        this.nombresVertices = nombresVertices.clone();
        this.dirigido = dirigido;
        this.matriz = new int[numVertices][numVertices];
    }

    private void validarVertice(int v) {
        if (v < 0 || v >= numVertices) {
            throw new IndexOutOfBoundsException("Indice de vertice invalido: " + v);
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        validarVertice(origen);
        validarVertice(destino);
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso de la arista debe ser mayor a cero.");
        }
        matriz[origen][destino] = peso;
        if (!dirigido) {
            matriz[destino][origen] = peso;
        }
    }

    public void agregarArista(int origen, int destino) {
        agregarArista(origen, destino, 1);
    }

    public boolean existeArista(int origen, int destino) {
        validarVertice(origen);
        validarVertice(destino);
        return matriz[origen][destino] > 0;
    }

    public int obtenerPeso(int origen, int destino) {
        validarVertice(origen);
        validarVertice(destino);
        return matriz[origen][destino];
    }

    public int getNumVertices() {
        return numVertices;
    }

    public String getNombreVertice(int index) {
        validarVertice(index);
        return nombresVertices[index];
    }

    public void imprimirMatriz() {
        System.out.println("Matriz de Adyacencia (" + (dirigido ? "Grafo Dirigido" : "Grafo No Dirigido") + "):");
        System.out.printf("%-20s", "Vertice \\ Vertice");
        for (int j = 0; j < numVertices; j++) {
            System.out.printf("[%d] ", j);
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.printf("[%d] %-16s", i, nombresVertices[i]);
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%3d ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
