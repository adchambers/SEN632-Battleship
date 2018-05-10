package systemoutgames;

public class Square {

    private Ship ship;
    private boolean beenHit;
    private Location location;

    public Square(Ship ship, Location location) {
        this.ship = ship;
        this.location = location;
        this.beenHit = false;
    }

    public  Location getLocation() {
        return location;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public HitResult hit() {

        if(hasShip()){
            int healthLeft = ship.hit();
            boolean shipSunk = healthLeft == 0;
            beenHit = true;
            return new HitResult(true, shipSunk, ship);
        }
        return new HitResult(false, false,null);
    }

    public boolean hasBeenHit() {
        return beenHit;
    }

    public boolean hasShip() {
        return ship != null;
    }
}
