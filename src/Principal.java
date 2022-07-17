import criptadores.CriptoDES;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Texto: ");
        String mensagem = scan.next();

        try {
            Key chave = CriptoDES.keyDES();
            System.out.println("Chave: " + chave);

            String criptografada = CriptoDES.criptogaphy(mensagem, chave);
            String descriptagrafada = CriptoDES.descriptogaphy(criptografada, chave);

            System.out.println("Criptografada: " + criptografada);
            System.out.println("Descriptofada: " + descriptagrafada);
        } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
                 InvalidKeyException e) {
            System.out.println("Unable to do de criptography.");
        }

        scan.close();
        System.out.println("System has ended.");
    }
}
/*
* com.sun.crypto.provider.DESKey@18466
* ?skY??*/