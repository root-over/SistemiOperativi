package QuartaEsercitazione.MatriceTS;

import java.util.Arrays;

public abstract class matriceAbstract {
    protected int[][] mat;

    public matriceAbstract(int[][] mat){
        this.mat=mat;
    }

    public int[][] inizializza(){
        for (int i=0; i<mat.length; i++){
            Arrays.fill(mat[i], 0);
        }
        return mat;
    }

    public String toString(){
        String s="";
        for (int i=0; i<mat.length;i++){
            for (int j=0; j<mat[i].length; j++){
                s+=mat[i][j];
                s+=(j<(mat[i].length-1))?",":"";
            }
            s+="\n";
        }
        return s;
    }
}
