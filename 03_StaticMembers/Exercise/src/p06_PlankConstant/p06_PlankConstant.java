package p06_PlankConstant;

import java.util.Locale;

class Calculation {
    private static Double plank;
    private static Double pi;

    static {
        plank = 6.62606896e-34;
        pi = 3.14159;
    }

    public static Double reduced() {
        return plank / (2 * pi);
    }
}

public class p06_PlankConstant {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Calculation calc = new Calculation();
        System.out.println(Calculation.reduced());
    }
}
