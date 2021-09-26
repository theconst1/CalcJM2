import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        for (; ; ) {
            try {
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                String[] input = str.split("\"");

                String result = "";
                String num2 = "";
                String stringM = "";
                if (Validator.stringLength(input[1])) {
                    throw new Exception("Ошибка: Строка больше 10 символов");
                }


                if (input[2].contains("+")) {
                    if (Validator.stringLength(input[3])) {
                        throw new Exception("Ошибка: Строка больше 10 символов");
                    }
                    result = input[1] + input[3];

                }
                if (input[2].contains("-")) {
                    if (Validator.stringLength(input[3])) {
                        throw new Exception("Ошибка: Строка больше 10 символов");
                    }
                    result = input[1].replace(input[3], "");
                }
                if (input[2].contains("*")) {
                    num2 = input[2].replaceAll("\\D", "");
                    Integer num = Integer.valueOf(num2);
                    if (Validator.numbersInRangeCheck(num)) {
                        throw new Exception("Ошибка: Число вне диапазона");
                    }
                    for (int i = 0; i < num; i++) {
                        result += input[1];
                    }
                }
                if (input[2].contains("/")) {
                    int l = input[1].length();
                    num2 = input[2].replaceAll("\\D", "");
                    Integer num3 = Integer.valueOf(num2);
                    if (Validator.numbersInRangeCheck(num3)) {
                        throw new Exception("Ошибка: Число вне диапазона");
                    }
                    int lDel = l / num3;
                    char[] simbol = input[1].toCharArray();
                    for (int i = 0; i < lDel; i++) {
                        result += simbol[i];

                    }
                }
                int lResult = result.length();
                if (lResult > 40) {
                    char[] simbolRes = result.toCharArray();
                    for (int i = 0; i < 40; i++) {
                        stringM += simbolRes[i];

                    }
                    result = stringM + "...";
                }
                System.out.println("\"" + result + "\"");


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}