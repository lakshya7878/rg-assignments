package Week2;

public class Singleton{
    private static Singleton  instance;
    private String name;
    // Constructor is made private intentionally
    private Singleton(String name) {
        this.name = name;
    }

    public static  Singleton getInstance(String name){
        if (instance == null) {
            instance = new Singleton((name));
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance("Lakshya");
        System.out.println(instance1.name);
        Singleton instance2 = Singleton.getInstance("Sharma");
        System.out.println(instance1.name);
    }
}