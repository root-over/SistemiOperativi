package PrimaEsercitazione_CreazioneThread;

public class StampanteR {
    public class StampanteT implements Runnable {
        private int da;
        private int a;

        public StampanteT(int da, int a) {
            this.a = a;
            this.da = da;
        }

        public void run() {
            for (int i = da; i <= a; i++) {
                System.out.println(i + " ");
            }
            System.out.println();
        }
    }
}
