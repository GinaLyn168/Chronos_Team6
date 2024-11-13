package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

public class Shooter {
    public TalonFX m_ShooterLeader;
    public TalonFX m_ShooterFollower;

    public static Shooter instance;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }

        return instance;
    }
}
