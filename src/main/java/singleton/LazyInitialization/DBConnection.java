package singleton.LazyInitialization;

public class DBConnection {
    // It solves the purpose of Eager Initialization but if two threads access at same time
    // can create two object.
    private static DBConnection conObject;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (conObject == null) {
            conObject = new DBConnection();
        }
        return conObject;
    }
}
