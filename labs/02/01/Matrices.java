import java.util.Scanner;

class Operacion {   
    public static double[][] suma(double[][] matX, double[][] matY) {
        int filas = matX.length;
        int columnas = matX[0].length;
        double[][] matResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matResultado[i][j] = matX[i][j] + matY[i][j];
            }
        }
        return matResultado;
    }

    public static double[][] producto(double[][] matX, double[][] matY) {
        int filasX = matX.length;
        int columnasX = matX[0].length;
        int columnasY = matY[0].length;
        double[][] matResultado = new double[filasX][columnasY];

        for (int i = 0; i < filasX; i++) {
            for (int j = 0; j < columnasY; j++) {
                for (int k = 0; k < columnasX; k++) {
                    matResultado[i][j] += matX[i][k] * matY[k][j];
                }
            }
        }
        return matResultado;
    }

    public static double[][] productoEscalar(double[][] matX, double escalar) {
        int filas = matX.length;
        int columnas = matX[0].length;
        double[][] matResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matResultado[i][j] = matX[i][j] * escalar;
            }
        }
        return matResultado;
    }

    public static double[][] traspuesta(double[][] matX) {
        int filas = matX.length;
        int columnas = matX[0].length;
        double[][] matResultado = new double[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matResultado[j][i] = matX[i][j];
            }
        }
        return matResultado;  
    }
}

class Captura {
    private static Scanner lector = new Scanner(System.in);

    public static double nextDouble(String mensaje) {
        System.out.print(mensaje);
        return lector.nextDouble();
    }

    public static double[][] leerMatriz(int filas, int columnas) {
        double[][] matResultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Ingrese el elemento en la fila " + (i + 1) + " y columna " + (j + 1) + ": ");
                matResultado[i][j] = lector.nextDouble();
            }
        }
        return matResultado;
    }
}

public class Matrices {   
    public static void main(String args[]) {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("Menú de Operaciones:");
            System.out.println("1. Suma de Matrices");
            System.out.println("2. Producto de Matrices");
            System.out.println("3. Producto de Escalar con Matriz");
            System.out.println("4. Traspuesta de Matriz");
            System.out.println("5. Salir");

            int opcion = entrada.nextInt();

            if (opcion == 5) {
                System.out.println("Saliendo del programa.");
                break;
            }

            switch (opcion) {
                case 1:
                    double[][] matrizA = Captura.leerMatriz(2, 2);
                    double[][] matrizB = Captura.leerMatriz(2, 2);
                    double[][] resultadoSuma = Operacion.suma(matrizA, matrizB);
                    System.out.println("Resultado de la Suma de Matrices:");
                    imprimirMatriz(resultadoSuma);
                    break;
                case 2:
                    matrizA = Captura.leerMatriz(2, 2);
                    matrizB = Captura.leerMatriz(2, 2);
                    double[][] resultadoProducto = Operacion.producto(matrizA, matrizB);
                    System.out.println("Resultado del Producto de Matrices:");
                    imprimirMatriz(resultadoProducto);
                    break;
                case 3:
                    matrizA = Captura.leerMatriz(2, 2);
                    double escalar = Captura.nextDouble("Ingrese el escalar: ");
                    double[][] resultadoProductoEscalar = Operacion.productoEscalar(matrizA, escalar);
                    System.out.println("Resultado del Producto de un Escalar con Matriz:");
                    imprimirMatriz(resultadoProductoEscalar);
                    break;
                case 4:
                    matrizA = Captura.leerMatriz(2, 2);
                    double[][] resultadoTraspuesta = Operacion.traspuesta(matrizA);
                    System.out.println("Traspuesta de la Matriz:");
                    imprimirMatriz(resultadoTraspuesta);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }

        entrada.close();
    }

    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
