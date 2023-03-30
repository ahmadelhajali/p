public class Fence implements MapObject {
    public String print() {
        return "[XXXXX]";
    }

    @Override
    public MapObjectType getType() {
        return MapObjectType.FENCE;
    }

    @Override
    public boolean isEdible() {
        return false;
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
