package PrimaEsercitazione.Esercizi;

import java.util.Arrays;
//Si realizzi un’applicazione multithreaded che calcola il prodotto scalare di due array di interi di dimensione n
public class ProdottoScalare extends Thread{
    private int [] a;
    private int [] b;
    int tot;
    public ProdottoScalare (int[] a, int[] b){
        this.a = Arrays.copyOf(a, a.length);
        this.b = Arrays.copyOf(b, b.length);
    }

    public void run(){
        for (int i=0; i<a.length; i++){
            tot += a[i]*b[i];
        }
    }
}
