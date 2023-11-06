/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2progIII;

/**
 *
 * @author brupa
 */
public class Validacion {
    
    public boolean esMutante(String[] dna) throws MatrizInvalidaExcepcion {
        int n = dna.length;
        //verificamos que la matriz no este vacia
        if (n == 0) {
            throw new MatrizInvalidaExcepcion("La matriz esta vacia");
        }
        for (int i = 0; i < n; i++) {
            //verificamos que la matriz sea n*n
            if (dna[i].length() != n) {
                throw new MatrizInvalidaExcepcion("La matriz no es n*n");
            }
            for (int j = 0; j < n; j++) {
                char c = dna[i].charAt(j);
                //verificamos que los caracteres ingresados sean validos
                if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                    throw new MatrizInvalidaExcepcion("La matriz tiene caracteres inválidos");
                }
            }
        }
        //vamos agregando al contador todo tipo de posibilidades, mientras que sea menor
        int cont = 0;
        cont += contVertical(dna);
        cont += contHorizontal(dna);
        cont += contDiagonal(dna);
        return cont >= 2;
    }
    
    //verificamos las lineas verticales
    private int contVertical(String[] dna) {
        int cont = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length(); j++) {
                if (dna[i].charAt(j)==dna[i+1].charAt(j) && dna[i].charAt(j)==dna[i+2].charAt(j) && dna[i].charAt(j)==dna[i+3].charAt(j)) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    //verificamos las lineas horizontales
    private int contHorizontal(String[] dna) {
        int cont = 0;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length() - 3; j++) {
                if (dna[i].charAt(j)==dna[i].charAt(j+1) && dna[i].charAt(j)==dna[i].charAt(j+2) && dna[i].charAt(j)==dna[i].charAt(j+3)) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    //verificamos las lineas diagonales
    private int contDiagonal(String[] dna) {
        int cont = 0;
        cont += contDiagonalAbajoIzqArribaDer(dna);
        cont += contDiagonalArribaIzqAbajoDer(dna);
        return cont;
    }
    
    //verificamos la diagonal inferior izquierda hacia arriba a la derecha
    private int contDiagonalAbajoIzqArribaDer(String[] dna) {
        int cont = 0;
        for (int i = 3; i < dna.length; i++) {
            for (int j = 0; j < dna[i].length() - 3; j++) {
                if (dna[i].charAt(j)==dna[i-1].charAt(j+1) && dna[i].charAt(j)==dna[i-2].charAt(j+2) && dna[i].charAt(j)==dna[i-3].charAt(j+3)) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    //verificamos la diagonal superior izquierda hacia abajo a al derecha
    private int contDiagonalArribaIzqAbajoDer(String[] dna) {
        int cont = 0;
        for (int i = 0; i < dna.length - 3; i++) {
            for (int j = 0; j < dna[i].length() - 3; j++) {
                if (dna[i].charAt(j)==dna[i+1].charAt(j+1) && dna[i].charAt(j)==dna[i+2].charAt(j+2) && dna[i].charAt(j)==dna[i+3].charAt(j+3)) {
                    cont++;
                }
            }
        }
        return cont;
    }
}
