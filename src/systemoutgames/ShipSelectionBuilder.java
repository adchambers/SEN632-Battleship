package systemoutgames;

public class ShipSelectionBuilder {

    private String name;
    private String coordinant;
    private String direction;
    private int startingHealth;

    private ShipSelectionBuilder() {}

    public static ShipSelectionBuilder shipSelectionBuilder() {
        return  new ShipSelectionBuilder();
    }

    public ShipSelectionBuilder coordinants(String coordinants) {
        this.coordinant = coordinants;
        return this;
    }

    public ShipSelectionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ShipSelectionBuilder direction(String direction) {
        this.direction = direction;
        return this;
    }

    public  ShipSelectionBuilder startingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
        return this;
    }

    public ShipSelection build() {
        return new ShipSelection(
                name,
                coordinant,
                direction,
                startingHealth
        );
    }
}
