package systemoutgames;

import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private String name;



    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> selectShips() {
        List<Ship> ships = new ArrayList<>();

        ships.add(new Ship(
                "Aircarft Carrier",
                5,
                new Location('A', '1', Direction.HORIZONTAL)
        ));

        ships.add(new Ship(
                "Battle Ship",
                4,
                new Location('B', '2', Direction.VERTICLE)
        ));

        ships.add(new Ship(
                "Submarine",
                3,
                new Location('C', '5', Direction.HORIZONTAL)
        ));

        ships.add(new Ship(
                "Crusier",
                3,
                new Location('H', '8', Direction.HORIZONTAL)
        ));

        ships.add(new Ship(
                "Destroyer",
                2,
                new Location('F', '2', Direction.HORIZONTAL)
        ));

        return ships;
    }

    protected Direction getShipDirection(String shipDirection) {
        String direction = shipDirection.toLowerCase();

        switch(direction){
            case "horizontal":
                return Direction.HORIZONTAL;
            case "vertical":
                return Direction.VERTICLE;
            default:
                return Direction.HORIZONTAL;
        }
    }


    public List<Ship> selectShips(List<ShipSelection> selections) {

        return selections.stream()
                .map(selection -> {
                    return new Ship(
                            selection.getName(),
                            selection.getStartingHealth(),
                            new Location(selection.getCoordinant().charAt(0), selection.getCoordinant().charAt(1), getShipDirection(selection.getDirection()))
                    );
                }).collect(Collectors.toList());

    }

    public Location selectHit() {
        return null;
    }
}
