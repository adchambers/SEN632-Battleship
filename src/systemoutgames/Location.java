package systemoutgames;

public class Location {

    private int x;
    private int y;
    private Direction direction;

    public Location(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Location(Character x, Character y, Direction direction) {
        this.x = getXValueFromString(x);
        this.y = y == '0' ?  9 : Integer.parseInt(y.toString())-1;
        this.direction = direction;
    }

    public int getStartingX() {
        return x;
    }

    public int getStartingY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    protected int getXValueFromString(Character x) {
        char ch  = Character.toLowerCase(x);
        int temp = (int)ch;
        int temp_integer = 97;

        return temp - temp_integer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (x != location.x) return false;
        return y == location.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
