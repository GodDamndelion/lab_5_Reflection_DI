package lab5;

/**
 * Stormtrooper class
 */
public class Stormtrooper {
    @AutoInjectable
    public Weapon primaryWeapon;
    @AutoInjectable
    private Weapon secondaryWeapon;
    public void shoot() {
        primaryWeapon.shoot();
        secondaryWeapon.shoot();
    }
}
