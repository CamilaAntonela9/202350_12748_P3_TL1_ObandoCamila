package grafos;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrafoMatriz grafo = new GrafoMatriz();
        int opcion;
        System.out.println("\n--------------------------------------------------");
        System.out.println("\n     UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE");
        System.out.println("            ESTRUCTURAS DE DATOS");
        System.out.println("       TEMA: GRAFOS MATRIZ ADYACENTE");
        System.out.println("   ESTUDIANTE: CAMILA ANTONELA OBANDO BUITRON");
        System.out.println("            FECHA: 02 / 08 / 2023");
        System.out.println("\n--------------------------------------------------");
        System.out.println("\n    TE PRESENTO LA CREACIÓN DE GRAFOS...");
        System.out.println("\n Ingresa un vertice inicial ");
        agregarVertice(grafo, scanner);

        do {
        	 System.out.println("\n--------------------------------------------------");
             System.out.println("\n                  MENÚ GRAFOS");
             System.out.println("\n--------------------------------------------------");
             System.out.println("  1. Insertar nuevo vértice");
             System.out.println("  2. Conectar vértices");
             System.out.println("  3. Buscar nodos conectados a un vértice");
             System.out.println("  4. Salir");
             System.out.print("Ingrese la opción deseada: ");
             System.out.println("\n--------------------------------------------------");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarVertice(grafo, scanner);
                    break;
                case 2:
                    conectarVertices(grafo, scanner);
                    break;
                case 3:
                    buscarNodosConectados(grafo, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }


    public static void agregarVertice(GrafoMatriz grafo, Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo vértice: ");
        String nombreVertice = scanner.next();

        grafo.nuevoVertice(nombreVertice);
        System.out.println("Vértice '" + nombreVertice + "' agregado correctamente.");
    }

    public static void conectarVertices(GrafoMatriz grafo, Scanner scanner) {
        System.out.print("Ingrese el nombre del primer vértice: ");
        String vertice1 = scanner.next();

        System.out.print("Ingrese el nombre del segundo vértice: ");
        String vertice2 = scanner.next();

        try {
            grafo.nuevoArco(vertice1, vertice2);
            System.out.println("Arista entre '" + vertice1 + "' y '" + vertice2 + "' agregada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al conectar los vértices: " + e.getMessage());
        }
    }

    public static void buscarNodosConectados(GrafoMatriz grafo, Scanner scanner) {
        System.out.print("Ingrese el nombre del vértice para buscar los nodos conectados: ");
        String nombreVertice = scanner.next();

        try {
            List<Vertice> nodosConectados = grafo.nodosConectados(nombreVertice);
            System.out.println("Nodos conectados a '" + nombreVertice + "': ");
            for (Vertice vertice : nodosConectados) {
                System.out.println(vertice.nomVertice());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
