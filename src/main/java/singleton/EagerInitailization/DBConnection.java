package singleton.EagerInitailization;

public class DBConnection {

    // created as program starts and not even used yet
    private static DBConnection conObject = new DBConnection();

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        return conObject;
    }
}
