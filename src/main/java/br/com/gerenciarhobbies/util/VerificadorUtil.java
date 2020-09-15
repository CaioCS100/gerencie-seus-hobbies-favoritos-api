package br.com.gerenciarhobbies.util;

import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class VerificadorUtil {

    public static Boolean estaNulo(Object object) {
        return object == null;
    }

    public static boolean naoEstaNulo(Object objeto) {
        return !estaNulo(objeto);
    }

    public static Boolean estaVazio(Object objeto) {
        return objeto instanceof Collection ? ((Collection)objeto).isEmpty() : StringUtils.isEmpty(objeto.toString());
    }

    public static Boolean estaVazioOuNulo(Object objeto) {
        return estaNulo(objeto) || estaVazio(objeto);
    }

    public static Boolean listaNulaEVazia(List<? extends Object> lista) {
        return estaNulo(lista) && estaVazio(lista);
    }

    public static Boolean listaNulaOuVazia(List<? extends Object> lista) {
        return estaNulo(lista) || estaVazio(lista);
    }
}
