import java.util.Arrays;
import java.util.Random;

public class OrdenamientoMetodos {
    public static void main(String[] args) {
        int[] tamaños = { 100, 500, 1000, 5000, 10000 };

        System.out.println("Tamaño del arreglo | Tiempo  - Burbuja | Tiempo  - Inserción | Tiempo  - Selección | Tiempo  - Mergesort");

        for (int tamaño : tamaños) {
            double[] arregloAleatorio = generarArreglo(tamaño);

            double[] copiaBurbuja = Arrays.copyOf(arregloAleatorio, arregloAleatorio.length);
            long tiempoBurbuja = medirTiempo(() -> Burbuja(copiaBurbuja));

            double[] copiaInsercion = Arrays.copyOf(arregloAleatorio, arregloAleatorio.length);
            long tiempoInsercion = medirTiempo(() -> Insercion(copiaInsercion));

            double[] copiaSeleccion = Arrays.copyOf(arregloAleatorio, arregloAleatorio.length);
            long tiempoSeleccion = medirTiempo(() -> Seleccion(copiaSeleccion));

            double[] copiaMergesort = Arrays.copyOf(arregloAleatorio, arregloAleatorio.length);
            long tiempoMergesort = medirTiempo(() -> Mergesort(copiaMergesort));

            System.out.printf("%-17d | %-23d | %-24d | %-24d | %-26d%n",
                    tamaño, tiempoBurbuja, tiempoInsercion, tiempoSeleccion, tiempoMergesort);
        }
    }

    public static double[] generarArreglo(int tamaño) {
        double[] arreglo = new double[tamaño];
        Random random = new Random();
        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextDouble();
        }
        return arreglo;
    }

    public static void Burbuja(double[] arreglo) {
        int n = arreglo.length;
        boolean Intercambio;
        do {
            Intercambio = false;
            for (int i = 1; i < n; i++) {
                if (arreglo[i - 1] > arreglo[i]) {
                    double temp = arreglo[i - 1];
                    arreglo[i - 1] = arreglo[i];
                    arreglo[i] = temp;
                    Intercambio = true;
                }
            }
            n--;
        } while (Intercambio);
    }

    public static void Insercion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            double valorActual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > valorActual) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = valorActual;
        }
    }

    public static void Seleccion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                double temp = arreglo[i];
                arreglo[i] = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = temp;
            }
        }
    }

    public static void Mergesort(double[] arreglo) {
        if (arreglo.length <= 1) {
            return;
        }

        int medio = arreglo.length / 2;
        double[] mitadIzquierda = Arrays.copyOfRange(arreglo, 0, medio);
        double[] mitadDerecha = Arrays.copyOfRange(arreglo, medio, arreglo.length);

        Mergesort(mitadIzquierda);
        Mergesort(mitadDerecha);

        fusionar(arreglo, mitadIzquierda, mitadDerecha);
    }

    public static void fusionar(double[] arreglo, double[] izquierda, double[] derecha) {
        int i = 0, j = 0, k = 0;
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] < derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }
        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }
        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    public static long medirTiempo(Runnable runnable) {
        long inicio = System.currentTimeMillis();
        runnable.run();
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }
}

