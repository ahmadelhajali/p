import java.util.Random;
import java.util.Scanner;

public class Card {

    // Neue 5 Kateogrien für je karte.
    private String name;
    private double height;
    private int intelligence;
    private int strength;
    private int jediPower;

    // Konstruktur für eine neue karte.
    public Card(String name, double height, int intelligence, int strength, int jediPower) {
        this.name = name;
        this.height = height;
        this.intelligence = intelligence;
        this.strength = strength;
        this.jediPower = jediPower;
    }

    // get Funktionen für je kategorie.
    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSrength() {
        return strength;
    }

    public int getJediPower() {
        return jediPower;
    }

    // Der Form
    @Override // Überschreiben
    public String toString() {
        return "Player:" + name + " height: " + height + " intelligence: " +
                intelligence + " strength:" + strength + " jediPower:" + jediPower;
    }
}

class Stack {

    private Card[] cards;
    private int top = 0;

    // Konstruktor zum Erstellenveines neuen Staples mit einer bestimmten Größe.
    public Stack(int size) {
        cards = new Card[8];
    }

    // Methode zum Himzufügen einer Karte zum Stapel.
    public void addCard(Card card) {
        cards[top++] = card;
    }

    // Methode zum ausspielen der obersten Karte vom Stapel.
    public Card playCard() {
        if (top == 0) {
            return null;
        } else {
            return cards[--top];
        }
    }

    // Methode zum Anzeigen der obersten Karte im Stapel
    public void showCard() {
        if (top == 0) {
            System.out.println("No cards left in the stack");
        } else {
            System.out.println(cards[top - 1]);
        }

    }

    // Methode zum Zäheln der Anzahl der Karten im Stapel.
    public int count() {
        return top;
    }
}

class Player {

    private String name;
    private int score = 0;
    private Stack stack;

    // Konstruktor zum Erstellein eines neuen Speilers mit einem Namen und einem
    // Stapel.
    public Player(String name, Stack stack) {
        this.name = name;
        this.stack = stack;
    }

    // der Anzahl der Karten, die der Speielr hat.
    public int countCards() {
        return stack.count();
    }

    // Hinzufügen eines Punktes
    public void addPoint() {
        score++;
    }

    // Abrufen des aktuellen Punkestands.
    public int getPoints() {
        return score;
    }

    // Methode zum Ausspielen + Angabe der Kategorie.
    public Card playCard(String category) {
        Card topCard = stack.playCard();
        switch (category) {
            case "height":
                System.out.println("Player chose height: " + topCard.getHeight());
                break;
            case "intelligence":
                System.out.println("Player chose intelligence: " + topCard.getIntelligence());
                break;
            case "strength":
                System.out.println("Player chose strength: " + topCard.getSrength());
                break;
            case "jediPower":
                System.out.println("Player chose jediPower: " + topCard.getJediPower());
                break;
            default:
                System.out.println("Invalid category chosen.");
                break;
        }
        return topCard;
    }

    // Methode zum zufälligen Spielen einer Karte.
    public Card playCard() {
        Random rand = new Random();
        int category = rand.nextInt(4); // 0-3
        Card topCard = stack.playCard();
        switch (category) {
            case 0:
                System.out.println("Computer chose height: " + topCard.getHeight());
                break;
            case 1:
                System.out.println("Computer chose intelligence: " + topCard.getIntelligence());
                break;
            case 2:
                System.out.println("Computer chose strength: " + topCard.getSrength());
                break;
            case 3:
                System.out.println("Computer chose jediPower: " + topCard.getJediPower());
                break;
        }
        return topCard;
    }

    // Oberte Karte zeigen.
    public void showCard() {
        stack.showCard();
    }
}

class Quartet {
    public static void main(String[] args) {

        // 8 Karten
        Card[] cards = new Card[8];
        cards[0] = new Card("Grogu", 0.5, 8, 9, 1);
        cards[1] = new Card("Lue", 0.6, 5, 1, 2);
        cards[2] = new Card("Gu", 0.7, 4, 8, 3);
        cards[3] = new Card("Nuke", 0.8, 6, 3, 5);
        cards[4] = new Card("Begu", 0.9, 7, 2, 4);
        cards[5] = new Card("Lu", 0.4, 2, 5, 6);
        cards[6] = new Card("Gro", 0.2, 9, 4, 7);
        cards[7] = new Card("Ben", 0.3, 3, 7, 9);

        // spieler und computerstapel erstellen
        Stack playerStack = new Stack(4);
        Stack computerStack = new Stack(4);
        int counter1 = 0;
        int counter2 = 0;
        // Verteielung der karten ziufällig
        for (int i = 0; i < 8; i++) {
            int random = (int) (Math.random() * 2);
            switch (random) {
                case 0:
                    counter1++;
                    if (counter1 > 4) {
                        random = 1;
                        break;
                    }
                    playerStack.addCard(cards[i]);
                default:
                    counter2++;
                    if (counter2 > 4) {
                        random = 0;
                        break;
                    }
                    computerStack.addCard(cards[i]);
            }

        }
        // player und computer erstellen.
        Player player = new Player("Player", playerStack);
        Player computer = new Player("Computer", computerStack);

        // Erste Runde einleiten
        Scanner scanner = new Scanner(System.in);
        boolean Turn = true;
        // Game loop
        while (player.countCards() > 0 && computer.countCards() > 0) {
            System.out.println("Enter command: play, show, stats");
            String input = scanner.nextLine();
            if (input.equals("play")) {
                System.out.println("Enter category to play: height, intelligence, strength, jediPower");
                String category = scanner.nextLine();
                Card playerCard = player.playCard(category);
                Card computerCard = computer.playCard();
                System.out.println("Player card: " + playerCard);
                System.out.println("Computer card: " + computerCard);
                if (category.equals("height")) {
                    if (playerCard.getHeight() > computerCard.getHeight()) {
                        player.addPoint();
                        System.out.println("Player wins this round!");
                        Turn = true;
                    } else {
                        computer.addPoint();
                        System.out.println("Computer wins this round!");
                        Turn = false;
                    }
                } else if (category.equals("intelligence")) {
                    if (playerCard.getIntelligence() > computerCard.getIntelligence()) {
                        player.addPoint();
                        System.out.println("Player wins this round!");
                        Turn = true;
                    } else {
                        computer.addPoint();
                        System.out.println("Computer wins this round!");
                        Turn = false;
                    }
                } else if (category.equals("strength")) {
                    if (playerCard.getSrength() > computerCard.getSrength()) {
                        player.addPoint();
                        System.out.println("Player wins this round!");
                        Turn = true;
                    } else {
                        computer.addPoint();
                        System.out.println("Computer wins this round!");
                        Turn = false;
                    }
                } else if (category.equals("jediPower")) {
                    if (playerCard.getJediPower() > computerCard.getJediPower()) {
                        player.addPoint();
                        System.out.println("Player wins this round!");
                        Turn = true;
                    } else {
                        computer.addPoint();
                        System.out.println("Computer wins this round!");
                        Turn = false;
                    }
                }
            } else if (input.equals("show")) {
                player.showCard();
                // computer.showCard();
            } else if (input.equals("stats")) {
                System.out.println("Player cards: " + player.countCards() + " Player points: " + player.getPoints());
                System.out.println(
                        "Computer cards: " + computer.countCards() + " Computer points: " + computer.getPoints());
            } else {
                System.out.println("Invalid command entered.");
            }

        }
        // Results.
        if (player.getPoints() > computer.getPoints()) {
            System.out.println("Player wins the game");

        }
        if (computer.getPoints() > player.getPoints()) {
            System.out.println("The computer wins");

        }
        if (computer.getPoints() == player.getPoints()) {
            System.out.println("DRAW");

        }

    }
}