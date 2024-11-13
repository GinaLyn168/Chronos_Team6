package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants;

public class Indexer {
    //Max
    private static Indexer instance;

    private TalonFX m_Indexer;

    public static Indexer getInstance() {
        if (instance == null) {
            instance = new Indexer();
        }
        return instance;
    }

    public void Indexer() {
        m_Indexer = new TalonFX(Constants.Ports.indexerMotor);
    }
}
