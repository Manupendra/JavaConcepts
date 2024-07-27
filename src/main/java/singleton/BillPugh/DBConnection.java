package singleton.BillPugh;

public class DBConnection {
    /**
     * So Bill Pugh solution rectify the issue of eager initialization by putting the object
     * inside private static nested class because this nested class do not get loaded on
     * program START-UP
     */
    private DBConnection() {
    }

    private static class DBConnectionHelper {
        private static final DBConnection INSTANCE_OBJECT = new DBConnection();
    }

    public static DBConnection getInstance() {
        return DBConnectionHelper.INSTANCE_OBJECT;
    }
}
