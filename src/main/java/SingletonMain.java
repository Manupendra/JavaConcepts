import singleton.EagerInitailization.DBConnection;

public class SingletonMain {
    public static void main(String[] args) {
        /**
         *  Singleton Class:
         *  the class objective is to create a single instance/object.
         *
         *  Different way of creating singleton class:
         *  1. Eager Initialization
         *  2. Lazy Initialization
         *  3. Synchronized Block
         *  4. Double check Lock
         *  5. Bill Pugh solution
         *  6. Enum Singleton
         *
         */

        // Eager Initialization
        DBConnection conObject = DBConnection.getInstance();
    }
}


