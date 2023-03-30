import java.util.Random;
import java.util.Scanner;

 public class  selberRaten {
     public static void main(String[] args) {

         Random rand = new Random();
         int randomNumber = rand.nextInt(100) + 1;
         
         int nextNumber;
         while (true){
             System.out.println("Your Guess? (1-100):");
             Scanner sc = new Scanner(System.in);
             nextNumber = sc.nextInt();
             if (nextNumber > randomNumber) {
                 System.out.println("Der Nummer ist kleiner, versuchen sie wieder");
             }
             if (nextNumber < randomNumber) {
                 System.out.println("Der Nummer ist größer, nochmals");
             } else if (nextNumber == randomNumber) {
                 System.out.println("Richtig!:D");
                 break;
             }


         }
     }
 }