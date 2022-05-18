package QuartaEsercitazione.MatriceTS;

public class TestMatrice {
    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        int numRipetizioni = 500000;

        int [][] matrice= new int [N][M];

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                matrice[i][j]=0;
            }
        }

        matriceAbstract matAbs = new MatriceNoThSf(matrice);
        //matriceAbstract matAbs = new MatriceThSf(matrice);

        ThIncr[] TIncr = new ThIncr[M];
        ThDecr[] TDecr = new ThDecr[N];

        for (int riga=0; riga<N; riga++){
            TIncr[riga] = new ThIncr(matAbs,riga,numRipetizioni);
            TIncr[riga].start();
        }

        for (int colonna=0; colonna<M; colonna++){
            TDecr[colonna] = new ThDecr(matAbs,colonna,numRipetizioni);
            TDecr[colonna].start();
        }

        for (int i=0; i<N; i++){
            try {
                TDecr[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        for (int i=0; i<M; i++){
            try {
                TIncr[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(matAbs);

    }
}
