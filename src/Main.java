/**
 * Demostración de modelado de red logística con Matriz de Adyacencia.
 */
public class Main {
    public static void main(String[] args) {
        String[] sedes = {
            "Campus Central",
            "Planta Lactea",
            "Campo Exp.",
            "Granja Avicola",
            "Bodega Central"
        };

        GrafoMatriz redLogistica = new GrafoMatriz(sedes, false);

        redLogistica.agregarArista(0, 1, 3); // Campus Central <-> Planta Lactea (3 km)
        redLogistica.agregarArista(0, 2, 5); // Campus Central <-> Campo Exp. (5 km)
        redLogistica.agregarArista(1, 4, 2); // Planta Lactea <-> Bodega Central (2 km)
        redLogistica.agregarArista(2, 3, 4); // Campo Exp. <-> Granja Avicola (4 km)
        redLogistica.agregarArista(3, 4, 6); // Granja Avicola <-> Bodega Central (6 km)

        System.out.println("Adyacencia Campus [0] a Planta [1]: " + redLogistica.existeArista(0, 1) + " (Distancia: " + redLogistica.obtenerPeso(0, 1) + " km)");
        System.out.println("Adyacencia Campus [0] a Bodega [4]: " + redLogistica.existeArista(0, 4));

        redLogistica.imprimirMatriz();
    }
}
