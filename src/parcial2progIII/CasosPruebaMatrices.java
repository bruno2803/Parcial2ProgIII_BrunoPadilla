/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcial2progIII;

/**
 *
 * @author brupa
 */
public class CasosPruebaMatrices {
    public String[][] matrices = {
            //MUTANTE
            {"AGAACG",
             "CAGTGC",
             "TTAGGT",
             "AGGAGG",
             "GCCCTA",
             "TCACTG"
            },
           //NO MUTANTE
            {"ATGCGA",
             "CAGTTC",
             "TTATGT",
             "AGCAGG",
             "CCTATA",
             "TCACTG"
            },
            //VACIA
            {
            },
            //NO MUTANTE
            {"ATCGGA",
             "CTCATC",
             "GGCTAG",
             "TCCAAT",
             "TCACGT",
             "AGATAG"
            },
            //NO ES CUADRADA
            {"GTCGTA",
             "CAGTGC",
             "TTATGT",
             "AGAAGG",
             "CGCCTA"
            },
            //CARACTERES INVALIDOS
            {"ACAATA",
             "CAG1GC",
             "TTATAT",
             "AGFAGG",
             "CCACTA",
             "TAACTG"
            }         
    };

    public String[][] getMatrices() {
        return matrices;
    }

    public void setBancoMatrices(String[][] matrices) {
        this.matrices = matrices;
    }

    public CasosPruebaMatrices(){

    };

    public CasosPruebaMatrices(String[][] matrices) {
        this.matrices = matrices;
    }
}
