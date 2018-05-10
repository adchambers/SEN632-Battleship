package systemoutgames;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer extends Player{

    private static final int gridSize = 10;

    private List<Location> hitLocations;

    public AIPlayer(String name) {
        super(name);
        hitLocations = new ArrayList<>();
    }

    @Override
    public List<Ship> selectShips() {

        List<Ship> ships = new ArrayList<>();

        ships.add(placeShip("Aircraft Carrier", 5, ships));
        ships.add(placeShip("Battle Ship", 4, ships));
        ships.add(placeShip("Submarine", 3, ships));
        ships.add(placeShip("Cruiser", 3, ships));
        ships.add(placeShip("Destroyer", 2, ships));
        return ships;
    }

    @Override
    public Location selectHit() {
        Location selection = new Location(getRandomNumber(gridSize),getRandomNumber(gridSize), getRandomDirection());
        if(selectionAlreadyMade(selection)){
            return selectHit();
        }
        return selection;
    }

    private boolean selectionAlreadyMade(Location selection) {
        return hitLocations.stream()
                .anyMatch(location -> location.equals(selection));
    }

    private int getRandomNumber(int bound) {
        Random rand = new Random();

        return rand.nextInt(bound);
    }

    private Ship placeShip(String name, int startingHealth, List<Ship> currentlyPlacedShips) {

        Ship newShip = new Ship(name, startingHealth, new Location(getRandomNumber(gridSize),getRandomNumber(gridSize), getRandomDirection()));

        if(ShipPlacementHelper.collisionDetected(newShip, currentlyPlacedShips) || ShipPlacementHelper.notInsideGrid(newShip)) {
            return placeShip(name, startingHealth, currentlyPlacedShips);
        }
        return newShip;
    }



    private Direction getRandomDirection() {
        switch (getRandomNumber(2)) {
            case 0:
                return Direction.HORIZONTAL;
            case 1:
                return Direction.VERTICLE;
            default:
                return Direction.HORIZONTAL;
        }
    }
}
