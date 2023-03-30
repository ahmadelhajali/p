import java.util.Scanner;
import java.util.Random;

public class Mastermind {
    public static void main(String[] args) {

        // Generiere einen zufälligen 4-stelligen Code ohne Doppelte Zahl und von 1 bis 8.
        Random random = new Random();
        int[] code = new int[4];
        for (int i = 0; i < code.length; i++) {
            code[i] = random.nextInt(8) + 1;
            // System.out.println(code[i]); // Nur zu wissen was der 4-stelligen Code ist.
        }    

        // Input vom User durch Scanner 
        for (int i = 0; i < 10; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("rate mal was der 4-stelligen Code ist:");
            String input = scanner.nextLine();

            // Der User kann nur 4-stelligen Code screiben, sonst gilt es als Ungültige Eingabe.
            while (input.length() != 4) {
            System.out.println("Ungültige Eingabe. Bitte geben Sie eine 4-stellige Zahl ein:");
            input = scanner.nextLine();
            }

            // gibt das erste Zeichen in unserem String zurück
            int[] guess = new int[4];
            for (int j = 0; j < 4; j++) {
                guess[j] = input.charAt(j) - '0';
            }

            // Überprüfe die Vermutung und drucke das Ergebnis.
            int[] result = check(guess, code);
            System.out.println(result[0] + " Ziffern sind korrekt und an der richtigen Position");
            System.out.println(result[1] + " Ziffern sind richtig, aber an der falschen Position");


            // Überprüfen Sie, ob der Spieler gewonnen hat
            if (result[0] == 4) {
                System.out.println("Herzlichen Glückwunsch. Du hast gewonnen.");
                }
            }

            // Wenn der User verlierst, indem er sein 10 versuche verbraucht hat.
            System.out.println("Hard luck. Der richtige Code war: " + code[0] + code[1] + code[2] + code[3] + ";)");
    }

    public static int[] check(int[] guess, int[] code) {

        // Überprüfe die Vermutung und gib die Anzahl der richtigen Ziffern an der richtigen Position zurück
        // und die Anzahl der richtigen Ziffern an der falschen Stelle.
        int richtigerPos = 0;
        int richtigerNum = 0;

        for (int i = 0; i < 4; i++) {
          if (guess[i] == code[i]) {
            richtigerPos++;
          } else {
            for (int j = 0; j < 4; j++) {
                if (guess[i] == code[j]) {
                    richtigerNum++;
                break;
                }
            }
            }
        }
        return new int[] {richtigerPos, richtigerNum};
    }
}
