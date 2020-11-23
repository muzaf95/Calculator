import java.util.*;

public class Scan {
    Convert convert = new Convert();

    Scanner scanner = new Scanner(System.in);

    public int romanNum1;
    public int romanNum2;
    public int num1;
    public int num2;
    public char operation;
    public boolean romanIs;

    String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public void expression() {

        String expression = scanner.nextLine().replaceAll(" ", "").toUpperCase();
        String[] operands = expression.split("[+-/*]");
        int romanFlagA = 0;
        int romanFlagB = 0;
        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(operands[0])) {
                romanFlagA = 1;
            }
            if (roman[i].equals(operands[1])) {
                romanFlagB = 1;
            }
        }

        if ((romanFlagA == 0) && (romanFlagB == 1)) {
            throw new IllegalArgumentException("Введите только 2 одинаковых типов чисел!!!");
        }   else if ((romanFlagA == 1) && (romanFlagB == 0))    {
            throw new IllegalArgumentException("Введите только 2 одинаковых типов чисел!!!");
        }
        operation = expression.charAt(operands[0].length());

        if ((romanFlagA == 1) && (romanFlagB == 1)) {
            romanNum1 = convert.romanToArab(operands[0]);
            romanNum2 = convert.romanToArab(operands[1]);
            romanIs = true;
        }   else if ((romanFlagA == 0) && (romanFlagB == 0)) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            romanIs = false;
                if ((num1 < 0 || num1 > 10) || (num2 < 0 || num2 > 10)) {
                    throw new IllegalArgumentException("Число не входит в диапазон от 1 до 10!!!");

                }
        }
        scanner.close();
    }

    public static int calculate(int a, int b, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак!!!");
        }
        return result;
    }
}
