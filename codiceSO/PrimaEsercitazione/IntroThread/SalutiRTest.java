package PrimaEsercitazione.IntroThread;

public class SalutiRTest {
    public static void main(String[] args) {
        SalutiR r = new SalutiR("Secondo thread"); //creo un instanza della classe
        Thread t = new Thread(r);//creo un instanza della classe thread passando al suo costruttore il riferimento della mia classe
        t.start();//avvio il thread
    }
}
