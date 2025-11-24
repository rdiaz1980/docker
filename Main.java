import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // substring : [begin, end)
        //String c = "abcde";
        //c = "0" + c;
        //System.out.println(c);
        //System.out.println(c.substring(0, 2));
        long startTime = System.nanoTime();
        //System.out.println(startTime);

        System.out.println(multiply("900", "9000"));

        long stopTime = System.nanoTime();
        //System.out.println(stopTime);
        //System.out.println((stopTime - startTime) + "ns");
    }

    public static String multiply(String a, String b) {
        ArrayList<String> arrayList = new ArrayList<>();
        String result = "0";
        for (int i = a.length() - 1; i >= 0; i--) {
            String partialResult = "";
            for (int c = 0; c < a.length() - 1 - i; c++)
                partialResult += "0";
            int digitMultiply = 0;
            int carry = 0;
            for (int j = b.length() - 1; j >= 0; j--) {
                digitMultiply = Integer.parseInt(Character.toString(a.charAt(i))) * Integer.parseInt(Character.toString(b.charAt(j))) + carry;
                if (j == 0) {
                    partialResult = String.valueOf(digitMultiply) + partialResult;
                    break;
                }
                partialResult = String.valueOf(digitMultiply % 10) + partialResult;
                carry = digitMultiply / 10;
            }
            arrayList.add(partialResult);
        }

        // for (String string : arrayList) {
        //     System.out.println(string);
        // }

        for (String string : arrayList) {
            result = sum(result, string);
        }
        
        return result;
    }

    public static String sum(String a, String b) {
        String result = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int digitSum = 0;
        while (i >= 0 && j >= 0) {
            digitSum = Integer.parseInt(Character.toString(a.charAt(i))) + Integer.parseInt(Character.toString(b.charAt(j))) + carry;
            result = String.valueOf(digitSum % 10) + result;
            carry = digitSum / 10;
            i--;
            j--;
        }
        if (carry != 0 && i != j) {
            if (i > j) {
            result = sum(a.substring(0, i + 1), String.valueOf(carry)) + result;
            }
            else if (j > i) {
                result = sum(b.substring(0, j + 1), String.valueOf(carry)) + result;
            }
        }
        else if (carry != 0 && i == j) {
            result = String.valueOf(carry) + result;
        }
        else if (carry == 0) {
            if (i > j) {
            result = a.substring(0, i + 1) + result;
            }
            else if (j > i) {
            result = b.substring(0, j + 1) + result;
            }
        }
        //System.out.println(result);
        return result;
    }
}

/*
9999
 888


    0887



*/