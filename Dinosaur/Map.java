import java.util.Random;

public class Map {
    MapObject[][] map;
    int anzahlDerCarnivore;
    int anzahlDerHerbivore;
    int row;
    int column;

    String[] nameCarnivore = { "Tyrannosaurus Rex", "Allosaurus", "Dimetrodon", "Plesiosaurus", "Velociraptor" };
    String[] nameHerbivore = { "Ankylosaurus", "Bagaceratops", "Barapasaurus", "Barosaurus", "Cedarpelta",
            "Dacentrurus", "Eolambia", "Fukuisaurus", "Gastonia", "Hesperosaurus",
            "Isisaurus", "Janenschia", "Kentrosaurus", "Lambeosaurus", "Maiasaura",
            "Nigersaurus", "Omeisaurus", "Pantydraco", "Quaesitosaurus", "Supersaurus" };

    int[] IdC = { 10, 15, 20, 25, 30 };
    int[] IdH = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 23, 11, 22, 33, 44, 55, 66, 77, 88, 99, 67 };

    public Map(int anzahlDerCarnivore, int anzahlDerHerbivore, int row, int column) {
        this.map = new MapObject[row][column];
        this.anzahlDerCarnivore = anzahlDerCarnivore;
        this.anzahlDerHerbivore = anzahlDerHerbivore;
    }

    public void addFence() {
        int counter;
        for (counter = 0; counter < map.length * map[0].length * 0.1;) {
            Random roww = new Random();
            int i = roww.nextInt(map.length);
            Random columnn = new Random();
            int j = columnn.nextInt(map[0].length);
            if (map[i][j] == null) {
                counter++;
                map[i][j] = new Fence();
            }
        }
    }

    public void addHerbivore() {
        int counter;
        for (counter = 0; counter < anzahlDerHerbivore;) {
            Random roww = new Random();
            int i = roww.nextInt(map.length);
            Random columnn = new Random();
            int j = columnn.nextInt(map[0].length);
            if (map[i][j] == null) {
                map[i][j] = new Herbivore(IdH[counter], nameHerbivore[counter]);
                counter++;
            }
        }

    }

    public void addCarnivore() {
        int counter;
        for (counter = 0; counter < anzahlDerCarnivore;) {
            Random roww = new Random();
            int i = roww.nextInt(map.length);
            Random columnn = new Random();
            int j = columnn.nextInt(map[0].length);
            if (map[i][j] == null) {
                map[i][j] = new Carnivore(IdC[counter], nameCarnivore[counter]);
                counter++;
            }
        }

    }

    public void addEmpty() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == null) {
                    map[i][j] = new Empty();
                }
            }
        }

    }

    public boolean checkCoordinates(int x, int y) {
        if (map[x][y] == null) {
            return false;
        } else {
            return true;
        }

    }

    public MapObject getCoordinates(int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return null;
        }
        return map[x][y];
    }

    public String toString() {
        String Kart = "-------\n";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                Kart += map[i][j].print();
            }
            Kart = Kart + "\n";
        }
        return Kart;
    }
}
