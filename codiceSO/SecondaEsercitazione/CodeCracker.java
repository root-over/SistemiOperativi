package SecondaEsercitazione;
import java.util.ArrayList;
import java.util.Random;


public class CodeCracker implements Runnable{
    ArrayList<Integer> ar = new ArrayList<>();

    @Override
    public void run() {
        Random r = new Random();
        int len =0;
        int num = r.nextInt(Integer.MAX_VALUE);
        StringBuilder codice= new StringBuilder();
        if (ar.contains(num)) {
            Thread.currentThread().interrupt();
        }
        ar.add(num);
        len = 16-String.valueOf(num).length();
        for (int i=0; i<len; i++) {
            codice.append("0");
        }
        codice.append(String.valueOf(num));
        //TODO PROVA IL CODICE PER DECRIPTARE IL FILE
    }

    public static void main(String[] args) {
        CodeCracker CC1 = new CodeCracker();
        Thread t1 = new Thread(CC1);
        CodeCracker CC2 = new CodeCracker();
        Thread t2 = new Thread(CC2);
        CodeCracker CC3 = new CodeCracker();
        Thread t3 = new Thread(CC3);
        CodeCracker CC4 = new CodeCracker();
        Thread t4 = new Thread(CC4);
        CodeCracker CC5 = new CodeCracker();
        Thread t5 = new Thread(CC5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        }
    }
