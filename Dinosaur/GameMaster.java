import java.util.Random;

public class GameMaster {
    Map mapp = new Map(5, 20, 20, 20);

    public void gameLoop() {

        for (int Tag = 0; mapp.anzahlDerHerbivore > 0;) { // Zählt die Tage

            for (int i = 0; i < mapp.map.length; i++) { // jedes Feld des Arrays
                for (int j = 0; j < mapp.map[0].length; j++) { // wird aufgerufen

                    Eat(i, j);
                    carnivoreBewegung(i, j);
                    herbivoreBewegung(i, j);
                }
            }
            Tag++;
            System.out.println(mapp.toString());
            System.out.println(Tag + ". Tag");
            System.out.println(mapp.anzahlDerHerbivore + "Herbivore ");
            System.out.println(mapp.anzahlDerCarnivore + "Carnivore");

        }
    }

    public void Eat(int i, int j) {
        if (mapp.getCoordinates(i, j).getType() == MapObjectType.CARNIVORE) { // in dieser Schleife wird ein
                                                                              // Herbivore gefressen
            int eat[] = new int[2];
            if (Nachbar(i, j, MapObjectType.HERBIVORE) != null) {
                eat = Nachbar(i, j, MapObjectType.HERBIVORE);
                if (((Carnivore) mapp.map[i][j]).attemptEat()) {
                    mapp.map[eat[0]][eat[1]] = new Empty();
                    mapp.anzahlDerHerbivore--;
                }
            }
        }
    }

    public void carnivoreBewegung(int i, int j) {
        if (mapp.getCoordinates(i, j).getType() == MapObjectType.CARNIVORE) {
            if (((Carnivore) mapp.map[i][j]).canMove()) { // in dieser Schleife wird ein Carnivore bewegen
                int[] move = new int[2];
                if (Nachbar(i, j, MapObjectType.EMPTY) != null) {
                    move = Nachbar(i, j, MapObjectType.EMPTY);
                    mapp.map[move[0]][move[1]] = mapp.map[i][j];
                    mapp.map[i][j] = new Empty();
                }
            }
        }
    }

    public void herbivoreBewegung(int i, int j) {
        if (mapp.getCoordinates(i, j).getType() == MapObjectType.HERBIVORE) {
            if (((Herbivore) mapp.map[i][j]).canMove()) { // in dieser Schleife wird ein Herbivore bewegen
                int[] move = new int[2];
                if (Nachbar(i, j, MapObjectType.EMPTY) != null) {
                    move = Nachbar(i, j, MapObjectType.EMPTY);
                    mapp.map[move[0]][move[1]] = mapp.map[i][j];
                    mapp.map[i][j] = new Empty();
                }
            }
        }
    }

    public int[] Nachbar(int i, int j, MapObjectType type) {
        int[] rowColumn = new int[2];
        int counter0 = 0;
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        // for (rowColumn[0] == 0 && rowColumn[1] == 0 || counter < 8;) {
        do {
            Random random = new Random();
            int Random = random.nextInt(8);
            if (counter0 != 0 && counter1 != 0 && counter2 != 0 && counter3 != 0 && counter4 != 0 && counter5 != 0
                    && counter6 != 0 && counter7 != 0) {
                Random = Random + 10;
            }
            switch (Random) {

                case 0:
                    counter0++;
                    if (mapp.getCoordinates(i - 1, j - 1) != null
                            && mapp.getCoordinates(i - 1, j - 1).getType() == type) {
                        rowColumn[0] = i - 1;
                        rowColumn[1] = j - 1;

                    }
                    break;
                case 1:
                    counter1++;
                    if (mapp.getCoordinates(i, j - 1) != null && mapp.getCoordinates(i, j - 1).getType() == type) {
                        rowColumn[0] = i;
                        rowColumn[1] = j - 1;
                    }
                    break;
                case 2:
                    counter2++;
                    if (mapp.getCoordinates(i + 1, j - 1) != null
                            && mapp.getCoordinates(i + 1, j - 1).getType() == type) {
                        rowColumn[0] = i + 1;
                        rowColumn[1] = j - 1;
                    }
                    break;
                case 3:
                    counter3++;
                    if (mapp.getCoordinates(i - 1, j) != null && mapp.getCoordinates(i - 1, j).getType() == type) {
                        rowColumn[0] = i - 1;
                        rowColumn[1] = j;
                    }
                    break;
                case 4:
                    counter4++;
                    if (mapp.getCoordinates(i + 1, j) != null && mapp.getCoordinates(i + 1, j).getType() == type) {
                        rowColumn[0] = i + 1;
                        rowColumn[1] = j;
                    }
                    break;
                case 5:
                    counter5++;
                    if (mapp.getCoordinates(i - 1, j + 1) != null
                            && mapp.getCoordinates(i - 1, j + 1).getType() == type) {
                        rowColumn[0] = i - 1;
                        rowColumn[1] = j + 1;
                    }
                    break;
                case 6:
                    counter6++;
                    if (mapp.getCoordinates(i, j + 1) != null && mapp.getCoordinates(i, j + 1).getType() == type) {
                        rowColumn[0] = i;
                        rowColumn[1] = j + 1;
                    }
                    break;
                case 7:
                    counter7++;
                    if (mapp.getCoordinates(i + 1, j + 1) != null
                            && mapp.getCoordinates(i + 1, j + 1).getType() == type) {
                        rowColumn[0] = i + 1;
                        rowColumn[1] = j + 1;
                    }
                    break;
                default:
                    return null;
            }
        } while (rowColumn[0] == 0 && rowColumn[1] == 0);
        return rowColumn;
    }

    public static void main(String[] args) {
        GameMaster run = new GameMaster();
        run.mapp.addCarnivore();
        run.mapp.addFence();
        run.mapp.addHerbivore();
        run.mapp.addEmpty();
        run.mapp.toString();

        run.gameLoop();
    }
}
