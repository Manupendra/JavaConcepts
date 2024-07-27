package singleton.DoubleCheck;

public class DBConnection {
    /**
     * Double Checked Locking solves the purpose of synchronized method slowness.
     * Disadvantage - There is a memory issue(L1 Cache sync) when we have two thread in
     * two cores. If L1 cache is not sync two objects can be created
     * <p>
     * To solve the Memory issue - we can use Volatile
     */
    private static volatile DBConnection conObject;

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (conObject == null) {  // check1
            synchronized (DBConnection.class) {
                if (conObject == null) {  // check2
                    conObject = new DBConnection();
                }
            }
        }
        return conObject;
    }
}
