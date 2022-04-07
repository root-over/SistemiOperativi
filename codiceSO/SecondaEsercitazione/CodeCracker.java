package SecondaEsercitazione;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;


public class CodeCracker extends Thread{
    private int da;
    private final int a;
    StringBuilder codice = new StringBuilder();

    public CodeCracker(int da, int a){
        this.da=da;
        this.a=a;
    }

    @Override //TODO 214748365 > 2147483647
    public void run() {
        while (da<=a) {
            int len = 0;
            len = 16 - String.valueOf(da).length();
            codice.append("0".repeat(Math.max(0, len)));
            codice.append(da);
            da+=1;
            try {
                decripta(codice.toString());
                codice= new StringBuilder("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void decripta(String codice) throws Exception {
        String key = codice;
        File inputFile = new File("document.txt");
        File encryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.encrypted");
        File decryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.decrypted");
        try{
            CryptoUtils.decrypt(key,encryptedFile,decryptedFile);
        }catch (CryptoException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int M=10;
        int da=0;
        int a=214748364;
        Thread[] threads = new Thread[M];
        for (int i=0; i<M; i++){
            threads[i] = new CodeCracker(da,a);
            da=a+1;
            a=a+a;
        }
        for (int i=0; i<M; i++){
            threads[i].start();
        }
    }
}
