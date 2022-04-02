package PrimaEsercitazione;

public class SalutiT extends Thread{ //creo la classe estendendo la classe thread
    public SalutiT(String nome){
        super(nome);
    }
    public void run(){ //Creo il metodo run per avviare il thread (Questo è quello che il thread esegue)
        for (int i=0; i<10; i++){
            System.out.println("Ciao da "+getName());
        }
    }
}
