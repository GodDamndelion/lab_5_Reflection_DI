package lab5;

/**
 * @author Большаков Павел Алексеевич 3 курс 61 гр ПММ
 */
public class Main {
    public static void main(String[] args) {
        Injector injector = new Injector();
        Stormtrooper stormtrooper = (Stormtrooper) injector.inject(new Stormtrooper());
        stormtrooper.shoot();
    }
}
