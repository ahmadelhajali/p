public class Dino {
    private int ID;
    private String name;

    public Dino(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public String getname() {
        return this.name;
    }

    public String toString() {
        String str = String.valueOf(this.name.charAt(0)) + this.ID;
        return str;

    }
}
