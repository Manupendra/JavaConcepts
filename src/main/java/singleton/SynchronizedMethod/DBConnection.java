package singleton.SynchronizedMethod;

public class DBConnection {
    /**
     * It solves the purpose of when two thread access at same time but only one thread can
     * initial.
     * Disadvantage - It is very very slow.
     */
    private static DBConnection conObject;

    private DBConnection() {
    }

    synchronized public static DBConnection getInstance() {
        if (conObject == null) {
            conObject = new DBConnection();
        }
        return conObject;
    }
}
