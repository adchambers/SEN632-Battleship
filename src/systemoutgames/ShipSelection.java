package systemoutgames;

public class ShipSelection {

    private String name;
    private String coordinant;
    private String direction;
    private int startingHealth;

    public ShipSelection(String name, String coordinant, String direction, int startingHealth) {
        this.name = name;
        this.coordinant = coordinant;
        this.direction = direction;
        this.startingHealth = startingHealth;
    }

    public String getName() {
        return name;
    }

    public String getCoordinant() {
        return coordinant;
    }

    public String getDirection() {
        return direction;
    }

    public int getStartingHealth() {
        return startingHealth;
    }
}
