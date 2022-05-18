package QuartaEsercitazione.MatriceTS;

public class ThDecr extends Thread{

    private matriceAbstract matrice;
    private int riga;
    private int numRipetizioni;

    public ThDecr(matriceAbstract m, int r, int numR){
        this.matrice=m;
        this.riga=r;
        this.numRipetizioni=numR;
    }

    public void run(){
        try {
            for (int i=0; i<numRipetizioni; i++){
                matrice.decrementa(riga);
            }
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}
