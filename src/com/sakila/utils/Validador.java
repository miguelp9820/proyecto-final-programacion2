package com.sakila.utils;

import java.util.Scanner;
/**
 * Clase utilitaria para validar entradas del usuario en consola.
 * Incluye validaciones de texto obligatorio y enteros positivos.
 */

public class Validador {
	/**
     * Solicita un texto obligatorio al usuario.
     * @param scanner Scanner para leer la entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Texto ingresado y validado.
     */
	
    // Leer texto obligatorio (no vacío)
    public static String leerTextoObligatorio(Scanner scanner, String mensaje) {
        String entrada;
        do {
            System.out.print(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("⚠️ El campo no puede estar vacio.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    /**
     * Solicita un número entero positivo al usuario.
     * @param scanner Scanner para leer la entrada.
     * @param mensaje Mensaje a mostrar.
     * @return Número entero válido.
     */
    
    // Leer número entero positivo
    public static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero < 0) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero < 0) {
                    System.out.println("⚠️ El numero debe ser mayor o igual a 0.");
                }
            } else {
                System.out.println("❌ Entrada no valida. Intenta con un numero.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
        scanner.nextLine(); // Limpiar salto de línea
        return numero;
    }
}
