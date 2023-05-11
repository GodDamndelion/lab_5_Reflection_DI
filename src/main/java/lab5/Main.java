package lab5;

/**
 * Main class
 * @author Большаков Павел Алексеевич 3 курс 61 гр ПММ
 */
public class Main {
    /**
     * main function
     * @param args arguments
     */
    public static void main(String[] args) {
        Injector injector = new Injector();
        Stormtrooper stormtrooper = (Stormtrooper) injector.inject(new Stormtrooper());
        stormtrooper.shoot();
    }
}
