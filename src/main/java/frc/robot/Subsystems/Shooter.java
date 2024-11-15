package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants;

public class Shooter {
    private TalonFX m_ShooterLeader;
    private TalonFX m_ShooterFollower;

    private ShooterState state;

    private static Shooter instance;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }

        return instance;
    }

    public Shooter() {
        m_ShooterLeader = new TalonFX(Constants.Ports.shooterLeader);
        m_ShooterFollower = new TalonFX(Constants.Ports.shooterFollower);

        configMotor(m_ShooterLeader, false);
        configMotor(m_ShooterFollower, false);
    }

    private void configMotor(TalonFX motor, Boolean invert) {
        motor.setInverted(invert);

        var config = new TalonFXConfiguration();

        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        motor.getConfigurator().apply(config);
    }

    public void setState(ShooterState state) {
        this.state = state;
    }

    public ShooterState getState() {
        return state;
    }

    public void setSpeed(double speed) {
        m_ShooterLeader.set(speed);
    }

    public enum ShooterState {
        SHOOT(1.0),
        STANDBY(0.0);

        private double speed;

        public double getValue() {
            return speed;
        }

        ShooterState(double speed) {
            this.speed = speed;
        }
    }
}
