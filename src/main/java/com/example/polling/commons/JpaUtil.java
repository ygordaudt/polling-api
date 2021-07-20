package com.example.polling.commons;

public class JpaUtil {

    private static final String NAO = "Não";
    private static final String SIM = "Sim";

    public static String toSimNao(Boolean value) {
        if (value == null)
            return null;
        else if (value)
            return SIM;
        else
            return NAO;
    }

    public static Boolean toBoolean(String simNao) {
        if (simNao == null)
            return null;
        else if (SIM.equals(simNao))
            return true;
        else if (NAO.equals(simNao))
            return false;
        else
            throw new RuntimeException("valor sim/não inesperado: " + simNao);
    }

}
