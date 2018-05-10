package systemoutgames;

import java.util.List;

public class ShipPlacementHelper {


    public static boolean collisionDetected(Ship newShip, List<Ship> currentlyPlacedShips) {

        return currentlyPlacedShips.stream()
                .flatMap( currentShip -> currentShip.getAllLocations().stream())
                .anyMatch( location -> newShip.getAllLocations().contains(location));
    }

    public static boolean notInsideGrid(Ship newShip) {
        return newShip.getAllLocations().stream()
                .anyMatch( location -> location.getStartingX() > 9 || location.getStartingY() > 9);
    }

    public static String getLocationAsString(Location location) {
        int ascii = location.getStartingX() + 97;
        Character character = new Character((char) ascii);
        int y = location.getStartingY() + 1;
        return character.toString() + y;
    }

}
