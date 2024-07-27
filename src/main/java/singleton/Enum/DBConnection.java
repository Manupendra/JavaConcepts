package singleton.Enum;

/**
 * In ENUM all constructor are private and only one object is created per JVM.
 */
enum DBConnection {
    INSTANCE;
}
