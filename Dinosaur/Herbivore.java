public class Herbivore extends Dino implements MapObject {

    public Herbivore(int ID, String name) {
        super(ID, name);
    }

    MapObjectType type = MapObjectType.HERBIVORE;

    public MapObjectType getType() {
        return MapObjectType.HERBIVORE;
    }

    public String print() {
        return "[H:" + toString() + "]";
    }

    public boolean isEdible() {
        return true;
    }

    public boolean canMove() {
        return true;
    }
}
