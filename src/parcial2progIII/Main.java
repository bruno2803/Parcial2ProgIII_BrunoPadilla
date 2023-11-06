/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcial2progIII;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brupa
 */
public class Main {
    
    //Verificar una matriz dada
    public static void analisisMutante(String[] matriz) {
        try {
            Validacion validacion = new Validacion();
            System.out.println("La matriz ingresada:");
            mostrarMatrix(matriz);
            if (validacion.esMutante(matriz))
                System.out.println("¡ES MUTANTE!\n");
            else
                System.out.println("¡NO ES MUTANTE!\n");
        } catch (MatrizInvalidaExcepcion e) {
            System.out.println("Matriz inválida: " + e.getMessage());
        }
    }
    
    //verifica la matriz creada por el usuario
    public static void analisisMutante() {
        String[] matriz = llenarMatriz();
        Validacion validacion = new Validacion();
        try {
            if (validacion.esMutante(matriz)) {
                System.out.println("La matriz ingresada:");
                mostrarMatrix(matriz);
                System.out.println("¡ES MUTANTE!\n");
            } else {
                System.out.println("¡NO ES MUTANTE!\n");
                System.out.println("La matriz ingresada:");
                mostrarMatrix(matriz);
            }
        } catch (MatrizInvalidaExcepcion e) {}
    }
    
    //Muestra la matriz
    public static void mostrarMatrix(String[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length(); j++) {
                System.out.print(matriz[i].charAt(j) + " ");
            }
            System.out.println("");
        }
    }
    
    //Ingresamos la matriz por pantalla
    public static String[] llenarMatriz() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> rows = new ArrayList<>();
        int n = 0;
        try {
            System.out.print("Ingrese la fila 1: ");
            String fila = sc.nextLine();
            verificarFila(fila);
            rows.add(fila);
            n = fila.length();
            if (n == 0)
                throw new MatrizInvalidaExcepcion("La matriz esta vacia");
            for (int i = 2; i <= n; i++) {
                System.out.print("Ingrese la fila " + i + ": ");
                fila = sc.nextLine();
                if (fila.length() != n) {
                    throw new MatrizInvalidaExcepcion("La matriz no es n*n");
                }
                verificarFila(fila);
                rows.add(fila);
            }
        } catch (MatrizInvalidaExcepcion e){
            System.out.println("La matriz es inválida: " + e.getMessage());
        }
        String[] matriz = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (String r : rows) {
                sb.append(r.charAt(i));
            }
            matriz[i] = sb.toString();
        }
        return matriz;
    }
    
    //Verifica la fila que se esta ingresando
    public static void verificarFila(String fila) throws MatrizInvalidaExcepcion {
        for (int i = 0; i < fila.length(); i++) {
            char c = fila.charAt(i);
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                throw new MatrizInvalidaExcepcion("Error: La matriz contiene caracteres inválidos");
            }
        }
    }
      
    public static void main(String[] args) {
        //Casos de prueba de matrices
        CasosPruebaMatrices matrices = new CasosPruebaMatrices();

        for (String[] m : matrices.getMatrices()) {
            analisisMutante(m);
        }

        //Matriz creada por el usuario
        /*analisisMutante();*/

    }
    


    
}
