package systemoutgames;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ship {

    private String name;
    private int health;
    private Location location;
    private int size;

    public Ship(String name, int startingHealth, Location location) {
        this.name = name;
        this.health = startingHealth;
        this.size = startingHealth;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public List<Location> getAllLocations() {
        List<Location> locations = IntStream.range(0, size).boxed().map(n -> {
            if(location.getDirection().equals(Direction.HORIZONTAL)){
                return new Location(location.getStartingX(), location.getStartingY()+n, location.getDirection());
            }

            return new Location(location.getStartingX() + n, location.getStartingY(), location.getDirection());
        }).collect(Collectors.toList());

        return locations;
    }

    public int hit() {
        health--;
        return health;
    }
}
