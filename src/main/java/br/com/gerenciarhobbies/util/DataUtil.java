package br.com.gerenciarhobbies.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DataUtil {

    public static Date dataAtual() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("pt-BR"));
        return calendar.getTime();
    }
}
