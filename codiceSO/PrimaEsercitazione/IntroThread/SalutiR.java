package PrimaEsercitazione.IntroThread;

public class SalutiR implements Runnable{
    private String nome; //Instanzo una variabile che contine il nome del thread

    public SalutiR(String nome){ //Creo un costruttore che passi pubblicamente il nome del thread
        this.nome=nome;
    }

    public void run() { //creo il metodo run che il thread eseguirà quando verrà invocato
        for (int i=0; i<10; i++){
            System.out.println("Ciao da "+nome);
        }
    }
}
