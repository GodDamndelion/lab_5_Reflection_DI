package lab5;

/**
 * Some weapon class
 */
public class Glock17 implements Weapon {
    @Override
    public void shoot() {
        System.out.println("The shot was fired from Glock17");
    }
}
