package QuartaEsercitazione.MatriceTS;

public class ThIncr extends Thread{
    private matriceAbstract matrice;
    private int colonna;
    private int numRipetizioni;

    public ThIncr(matriceAbstract m, int c, int numR){
        this.matrice=m;
        this.colonna=c;
        this.numRipetizioni=numR;
    }

    public void run(){
        try {
            for (int i=0; i<numRipetizioni; i++){
                matrice.incrementa(colonna);
            }
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}
