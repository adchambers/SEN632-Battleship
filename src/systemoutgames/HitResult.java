package systemoutgames;

public class HitResult {

    private boolean shipHit;
    private boolean shipSunk;
    private Ship sunkShip;

    public HitResult(boolean shipHit, boolean shipSunk, Ship sunkShip) {
        this.shipHit = shipHit;
        this.shipSunk = shipSunk;
        this.sunkShip = sunkShip;
    }

    public Ship getSunkShip() {
        return sunkShip;
    }

    public boolean isShipHit() {
        return shipHit;
    }

    public boolean isShipSunk() {
        return shipSunk;
    }
}
