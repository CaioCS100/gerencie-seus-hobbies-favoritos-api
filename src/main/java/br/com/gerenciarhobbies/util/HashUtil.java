package br.com.gerenciarhobbies.util;

public class HashUtil {

    public static String gerarSenhaCriptografada(String senha) {
        return BCryptUtil.hashpw(senha, BCryptUtil.gensalt(12));
    }

    public static Boolean validarSenha(String senha, String hash) {
        return BCryptUtil.checkpw(senha, hash);
    }
}
