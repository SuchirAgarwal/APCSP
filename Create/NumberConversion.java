/**
 * This program consists of methods that 
 * convert numbers between different number
 * systems.
 * 
 * @author Suchir Agarwal
 */

public class NumberConversion {

    public static char charFromVal(int num) {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else   
            return (char) (num + 55);
    }

    public static int valFromChar(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    public static String baseConvert(String input, int base1, int base2) {
        int temp = toDecimal(input, base1);
        String result = fromDecimal(temp, base2);

        return result;
    }

    public static String fromDecimal(int input, int base) {
        String revResult = "";

        while (input > 0) {
            revResult += charFromVal(input % base);
            input /= base;
        }

        String result = "";

        for (int i = revResult.length() - 1; i >= 0; i--) {
            result += revResult.substring(i, i + 1);
        }

        return result;
    }


    public static int toDecimal(String input, int base) {
        int power = 1;
        int num = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            num += valFromChar(input.charAt(i)) * power;
            power *= base;
        }

        return num;
    }

}