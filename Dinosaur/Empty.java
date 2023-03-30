public class Empty implements MapObject {

    public MapObjectType getType() {
        return MapObjectType.EMPTY;
    }

    public String print() {
        return "[     ]";
    }

    public boolean isEdible() {
        return false;
    }

    public boolean canMove() {
        return false;
    }

}
