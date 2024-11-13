package frc.robot.Subsystems;

public class Indexer {
    //Max
    private static Indexer instance;

    public static Indexer getInstance() {
        if (instance == null) {
            instance = new Indexer();
        }
        return instance;
    }
}
