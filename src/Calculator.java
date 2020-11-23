public class Calculator {

    public static void main(String[] args) {

        Convert convert = new Convert();
        Scan scan = new Scan();
        scan.expression();

        if (scan.romanIs) {
            int romanResult = scan.calculate(scan.romanNum1, scan.romanNum2, scan.operation);

            if (romanResult < 0) {
                System.out.println("-" + convert.romanNumerals(-romanResult));
            } else {
                System.out.println(convert.romanNumerals(romanResult));
            }
        } else {
            int result = scan.calculate(scan.num1, scan.num2, scan.operation);
            System.out.println(result);
        }
    }
}
