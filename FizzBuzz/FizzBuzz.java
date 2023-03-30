public class FizzBuzz {
    public static void main(String[] args) {
    int[] Zahlen = new int[Integer.parseInt(args[0])]; // new Array mit der Länge der Zahl
    for (int i = 0; i<Integer.parseInt(args[0]); i++ ){ // hochzahlen von 1 bis der eingegebenen Zahl
        Zahlen[i] = i+1;
    }
    for (int j=0; j < Zahlen.length; j++){
        if  (Zahlen[j] % 3==0 && Zahlen[j] % 5 == 0) { // Abfragen von beide Modulo 3 und 5 ohne Rest
            System.out.println("Fizz-Buzz");
        }
        else if (Zahlen[j] % 3 == 0) { // Abfragen von modulo 3 ohne Rest
            System.out.println("Fizz");
        }
        else if (Zahlen[j] % 5 == 0) { // Abfragen von modulo 5 ohne Rest
            System.out.println("Buzz");
        }
        else {
            System.out.println(Zahlen[j]);
        }
     }
    }
}