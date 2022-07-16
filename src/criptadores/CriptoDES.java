package criptadores;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class CriptoDES {

    //Criando a cifra de criptografia
    private static Cipher cifraDES;

    //Gerador de chave de Criptografia simétrica
    private static KeyGenerator keyGenerator;

    //Criando a chave de Criptografia simétrica
    private static SecretKey chaveDES;

    public static Object chave_cripEdes() {
        try {
            //Criador de chave de criptografia, utilizando o algoritmo DES
            keyGenerator = KeyGenerator.getInstance("DES");

            //Ativando a chave de criptografia
            chaveDES = keyGenerator.generateKey();
            return chaveDES;

        } catch (NoSuchAlgorithmException e) {
            return e.getMessage();
        }
    }

    public static Object criptografia(byte[] mensagem) {
        try {
            //Utiliza a chave gerada
            Object chave_criptografia = chave_cripEdes();

            //Método de transformação da cifra em questão
            cifraDES = Cipher.getInstance("DES/CBC/PKCS5Padding");

            //Inicializa o método de criptografia
            cifraDES.init(Cipher.ENCRYPT_MODE, (Key) chave_criptografia);

            //A criptação em andamento
            byte[] texto_encriptografado = cifraDES.doFinal(mensagem);
            return texto_encriptografado;

        }catch(NoSuchAlgorithmException e){
            return "Erro no algoritmo de descriptografia.";
        }catch(NoSuchPaddingException e){
            return "Padding não encontrado.";
        }catch(InvalidKeyException e){
            return "Chave de descriptografia inválida.";
        }catch(IllegalBlockSizeException e){
            return "Tamanho de bloco ilegal.";
        }catch(BadPaddingException e){
            return "Erro no padding.";
        }
    }

    public static Object descriptografia(byte[] mensagem, Key chave) {
        try {
            //Método de transformação da cifra em questão
            cifraDES = Cipher.getInstance("DES/CBC/PKCS5Padding");

            //Inicializa o método de descriptografia
            cifraDES.init(Cipher.DECRYPT_MODE, chave);

            //A criptação em andamento
            byte[] texto_descriptografado = cifraDES.doFinal(mensagem);
            return texto_descriptografado;

        }catch(NoSuchAlgorithmException e){
            return "Erro no algoritmo de descriptografia.";
        }catch(NoSuchPaddingException e){
            return "Padding não encontrado.";
        }catch(InvalidKeyException e){
            return "Chave de descriptografia inválida.";
        }catch(IllegalBlockSizeException e){
            return "Tamanho de bloco ilegal.";
        }catch(BadPaddingException e){
            return "Erro no padding.";
        }
    }
}
