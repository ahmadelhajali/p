public class Carnivore extends Dino implements MapObject {

    public Carnivore(int ID, String name) {
        super(ID, name);
    }

    public MapObjectType getType() {
        return MapObjectType.CARNIVORE;
    }

    public String print() {
        return "[C:" + toString() + "]";
    }

    public boolean isEdible() {
        return false;
    }

    public boolean canMove() {
        return true;
    }

    public boolean attemptEat() {
        int random = ((int) Math.random() * 3); // generiert ein nummer zwischen 0 und 2
        if (random == 0) {
            return true;
        } else {
            return false;
        }
    }
}
