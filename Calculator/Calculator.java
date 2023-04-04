public class Calculator {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        double ersteZahl = Double.valueOf(args[0]);
        String rechenoperation = args[1];
        double zweiteZahl = Double.valueOf(args[2]);
        ersteZahl = Double.valueOf(ersteZahl);
        zweiteZahl = Double.valueOf(zweiteZahl);
        switch (rechenoperation) {
            case "+":
                System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + calc.add(ersteZahl, zweiteZahl));
                break;
            case "-":
                System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + calc.subs(ersteZahl, zweiteZahl));
                break;
            case "x":
                System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + calc.mult(ersteZahl, zweiteZahl));
                break;
            case "/":
                System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + calc.div(ersteZahl, zweiteZahl));
                break;
            default:
                System.out.println("Bitte geben Sie +, -, x oder /");
        }

    }

    public double add(double a, double b) { // a method to add two numbers
        double c = a + b;
        return c;
    }

    public double subs(double a, double b) { // a method to substract two numbers 
        double c = a - b;
        return c;
    }

    public double mult(double a, double b) { // a method to multiply two numbers 
        double c = a * b;
        return c;
    }

    public double div(double a, double b) { // a method to divide two numbers
        double c = a / b;
        return c;
    }

}
