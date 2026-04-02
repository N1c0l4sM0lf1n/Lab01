import java.util.Random;
import java.util.Scanner;

public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    public static int[] historialNumeros = new int[MAX_HISTORIAL];
    public static int[] historialApuestas = new int[MAX_HISTORIAL];
    public static boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    public static int historialSize = 0;
    public static Random rng = new Random();
    public static int[] numerosRojos =
            {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    /**
     * Método principal: inicia el programa llamando al menú.
     */
    public static void main(String[] args) {
        menu();
    }
    /**
     * Controla el flujo principal del programa mostrando un menú en consola.
     */
    public static void menu() {
        Scanner in = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(in);
            ejecutarOpcion(opcion, in);
        } while (opcion != 3);
        in.close();
    }
    /**
     * Muestra en consola las opciones disponibles del menú.
     */
    public static void mostrarMenu() {
        System.out.print("\n Escoja una opcion \n");
        System.out.print("1. Iniciar una Ronda \n");
        System.out.print("2. Ver Estadisticas \n");
        System.out.print("3. Salir \n");
    }
    /**
     * Lee la opción elegida por el usuario desde teclado.
     * @param in Scanner para entrada por consola.
     * @return número de opción ingresado.
     */
    public static int leerOpcion(Scanner in) {
        int opcion;

        while (true) {
            if (in.hasNextInt()) {
                opcion = in.nextInt();

                if (opcion >= 1 && opcion <= 3) {
                    return opcion;
                } else {
                    System.out.print("Opción inválida. Ingrese 1, 2 o 3: \n");
                }

            } else {
                System.out.print("Debe ingresar un número, no una letra \n");
                in.next(); // limpia lo inválido
            }
        }
    }
    /**
     * Ejecuta la acción correspondiente a la opción del menú.
     * @param opcion opción elegida por el usuario.
     * @param in Scanner para entrada por consola.
     */
    public static void ejecutarOpcion(int opcion, Scanner in) {
        switch (opcion){
            case 1 -> iniciarRonda(in);
            case 2 -> mostrarEstadisticas();
            case 3 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción inválida");
        };
    }
    /**
     * Inicia una ronda de la ruleta: leer apuesta, girar, evaluar y mostrar resultado.
     * @param in Scanner para entrada por consola.
     */
    public static void iniciarRonda(Scanner in) {
        char tipo = leerTipoApuesta(in);

        int monto = leerMonto(in);

        int numero = girarRuleta();
        boolean acierto = evaluarResultado(numero, tipo);

        registrarResultado(numero, monto, acierto);
        mostrarResultado(numero, tipo, monto, acierto);
    }
    /**
     * Muestra en consola el resultado de la ronda.
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta realizada.
     * @param monto monto apostado.
     * @param acierto si el jugador ganó o perdió.
     */

    private static void mostrarResultado(int numero, char tipo, int monto, boolean acierto) {
        System.out.println("\nNúmero obtenido: " + numero);
        System.out.println("Apuesta: " + tipo);
        System.out.println("Monto: " + monto);

        if (acierto) {
            System.out.println("¡Ganaste!");
        } else {
            System.out.println("Perdiste.");
        }
    }

    /**
     * Permite al usuario seleccionar el tipo de apuesta (R/N/P/I).
     * @param in Scanner para entrada por consola.
     * @return el tipo de apuesta elegido.
     */
    public static char leerTipoApuesta(Scanner in) {
        char tipo;

        do {
            System.out.print("Tipo de apuesta (R=Rojo, N=Negro, P=Par, I=Impar): ");
            tipo = in.next().toUpperCase().charAt(0);

            if (tipo != 'R' && tipo != 'N' && tipo != 'P' && tipo != 'I') {
                System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (tipo != 'R' && tipo != 'N' && tipo != 'P' && tipo != 'I');

        return tipo;
    }
    /**
     * Simula el giro de la ruleta generando un número aleatorio de 0 a 36.
     * @return número de la ruleta.
     */
    public static int girarRuleta() {
        return rng.nextInt(37);
    }
    /**
     * Evalúa si la apuesta realizada por el jugador fue acertada.
     * @param numero número obtenido en la ruleta.
     * @param tipo tipo de apuesta elegida.
     * @return true si acertó, false si perdió.
     */
    public static boolean evaluarResultado(int numero, char tipo) {
        if (numero == 0) return false;

        return switch (tipo) {
            case 'R' -> esRojo(numero);
            case 'N' -> !esRojo(numero);
            case 'P' -> numero % 2 == 0;
            case 'I' -> numero % 2 != 0;
            default -> false;
        };
    }
    /**
     * Determina si un número corresponde a color rojo.
     * @param n número de la ruleta.
     * @return true si es rojo, false en caso contrario.
     */
    public static boolean esRojo(int n) {
        for (int rojo : numerosRojos) {
            if (rojo == n) return true;
        }
        return false;
    }
    /**
     * Registra los resultados de la ronda en los arreglos de historial.
     * @param numero número obtenido en la ruleta.
     * @param apuesta monto apostado.
     * @param acierto si el jugador acertó o no.
     */
    public static void registrarResultado(int numero, int apuesta, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = apuesta;
            historialAciertos[historialSize] = acierto;
            historialSize++;
        }
    }
    /**
     * Muestra estadísticas generales de todas las rondas jugadas.
     */

    public static void mostrarEstadisticas() {
        if (historialSize == 0) {
            System.out.println("No hay datos.");
            return;
        }

        int totalApostado = 0;
        int aciertos = 0;

        for (int i = 0; i < historialSize; i++) {
            totalApostado += historialApuestas[i];
            if (historialAciertos[i]) aciertos++;
        }

        double porcentaje = (double) aciertos / historialSize * 100;
        int ganancia = 0;

        for (int i = 0; i < historialSize; i++) {
            if (historialAciertos[i]) {
                ganancia += historialApuestas[i];
            } else {
                ganancia -= historialApuestas[i];
            }
        }

        System.out.println("\n--- ESTADÍSTICAS ---");
        System.out.println("Rondas jugadas: " + historialSize);
        System.out.println("Total apostado: " + totalApostado);
        System.out.println("Aciertos: " + aciertos);
        System.out.println("Porcentaje de acierto: " + porcentaje + "%");
        System.out.println("Ganancia/Pérdida neta: " + ganancia);
    }
    public static int leerMonto(Scanner in) {
        int monto;

        while (true) {
            System.out.print("Ingrese monto a apostar: ");

            if (in.hasNextInt()) {
                monto = in.nextInt();

                if (monto > 0) {
                    return monto;
                } else {
                    System.out.println("El monto debe ser mayor a 0.");
                }

            } else {
                System.out.println("Debe ingresar un número válido.");
                in.next(); // limpia entrada inválida
            }
        }
    }
}
