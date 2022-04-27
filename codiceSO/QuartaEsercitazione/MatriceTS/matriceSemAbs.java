package QuartaEsercitazione.MatriceTS;

import java.util.concurrent.Semaphore;

public class matriceSemAbs extends matriceAbstract{
    private Semaphore[][] matriceMutex;

    public matriceSemAbs(int[][] mat) {
        super(mat);
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                matriceMutex[i][j] = new Semaphore(1);
            }
        }
    }
}
