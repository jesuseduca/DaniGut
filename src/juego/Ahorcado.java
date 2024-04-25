/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego;

import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {
        jugarAhorcado();
    }

    public static void jugarAhorcado() {
        String[] palabras = {"hola", "adios", "programacion", "aprobado", "datos", "buenas"};
        String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];
        char[] palabraAdivinada = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraAdivinada.length; i++) {
            palabraAdivinada[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);

        int intentos = 7;
        while (intentos > 0) {
            System.out.println("Palabra: " + String.valueOf(palabraAdivinada));
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().charAt(0);

            boolean letraAdivinada = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraAdivinada[i] = letra;
                    letraAdivinada = true;
                }
            }

            if (!letraAdivinada) {
                intentos--;
            }

            boolean juegoTerminado = true;
            for (char c : palabraAdivinada) {
                if (c == '_') {
                    juegoTerminado = false;
                    break;
                }
            }

            if (juegoTerminado) {
                System.out.println("Â¡Que Pena AJJAJAJAJAJAJA! Has adivinado la palabra: " + palabraSecreta);
                break;
            }
        }

        if (intentos == 0) {
            System.out.println("Ahorcado. Game Over. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }
}