package jogo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Classe de utilidades gerais.
 *
 * @author Lucas
 */
public class Util {

    /**
     * Gera um valor random, dentro de limites
     *
     * @param min valor mínimo
     * @param max valor máximo
     * @return random number
     */
    public static double generateValue(double min, double max) {
        return min + (Math.random() * (max - min));
    }

    public static double multGenerateValue(double min, double max, int mult) {
        double r = 0;
        for (int j = 1; j <= mult; j++) {
            r += generateValue(min, max) / j;
        }
        return (r % max);
    }

    public static boolean isNullOrEnpty(final String s) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        try {
            bd = bd.setScale(places, RoundingMode.HALF_UP);
        } catch (Exception e) {
        }
        return bd.doubleValue();
    }

    public static double roundFtoD(float value, int places) {
        return Double.parseDouble(String.valueOf(round(value, places)));
    }

    public static float round(float value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = BigDecimal.valueOf(value);
        try {
            bd = bd.setScale(places, RoundingMode.HALF_UP);
        } catch (Exception e) {
        }
        return bd.floatValue();
    }

    public static float roundDtoF(double value, int places) {
        return Float.parseFloat(String.valueOf(round(value, places)));
    }

    public static char getRandomChar(int bound) {
        return ((char) (new Random().nextInt(26) + 'a'));
    }

    public static char getRandomCharBetweenAandZ() {
        return getRandomChar(26);
    }

    public static String getSequencialRandomCharBetweenAandZ(int size) {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += getRandomChar(26);
        }
        return s;
    }

    public static String tryCutString(String s, int start, int end) {
        for (int i = end; i >= 0; i--) {
            try {
                return s.substring(start, end);
            } catch (Exception e) {
            }
        }
        return s;
    }
}
