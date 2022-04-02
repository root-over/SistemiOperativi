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


public class CodeCracker implements Runnable{
    ArrayList<Integer> ar = new ArrayList<>();

    @Override
    public void run() {
        while (ar.size()<Integer.MAX_VALUE) {
            Random r = new Random();
            StringBuilder codice = new StringBuilder();
            int len = 0;
            int num = r.nextInt(Integer.MAX_VALUE);
            if (ar.contains(num)) {
                Thread.currentThread().interrupt();
            }
            ar.add(num);
            len = 16 - String.valueOf(num).length();
            for (int i = 0; i < len; i++) {
                codice.append("0");
            }
            codice.append(String.valueOf(num));
            try {
                decripta(codice.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void decripta(String codice) throws Exception {
        String key = codice;
        File inputFile = new File("document.txt");
        File encryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/document2022.encrypted");
        File decryptedFile = new File("/home/root_over/Documents/Universita/Anno 2/Sistemi operativi/Eserciztazioni/codiceSO/SecondaEsercitazione/prove/document2022.decrypted");

        try{
            CryptoUtils.decrypt(key,encryptedFile,decryptedFile);
        }catch (CryptoException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
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
