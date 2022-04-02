package PrimaEsercitazione.stampe;

public class StampaTSequenziale {
    public static void main(String[] args) {
        StampanteT s1=new StampanteT(1,10);
        StampanteT s2 = new StampanteT(11,20);
        s1.start();

        try {
            s1.join();
            s2.start();
            s2.join();
        }catch (InterruptedException e){
            System.out.println("Fine");
        }
    }
}
