package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Indexer extends SubsystemBase{
    //Max
    private static Indexer instance;

    private TalonFX m_IndexerLeader;
    private TalonFX m_IndexerFollower;

    private Follower follow = new Follower(Constants.Ports.leftIndexer, false);

    private IndexerStates motorStates = IndexerStates.OFF;

    public static Indexer getInstance() {
        if (instance == null) {
            instance = new Indexer();
        }
        return instance;
    }

    public void Indexer() {
        m_IndexerLeader = new TalonFX(Constants.Ports.leftIndexer);
        m_IndexerFollower = new TalonFX(Constants.Ports.rightIndexer);
        m_IndexerLeader.setControl(follow);
        configMotor(m_IndexerLeader);
        configMotor(m_IndexerFollower);
    }

    public enum IndexerStates {
        ON(0.25),
        OFF(0),
        REV(-0.25);

        private double speed;

        public double getSpeed() {
            return speed;
        }

        IndexerStates(double speed) {
            this.speed = speed;
        }
    }

    private void configMotor(TalonFX motor) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        motor.getConfigurator().apply(config);
    }

    public double getMotorVoltage() {
        return m_IndexerLeader.getSupplyVoltage().getValueAsDouble();
    }

    public double getMotorCurrent() {
        return m_IndexerLeader.getSupplyCurrent().getValueAsDouble();
    }

    public void setSpeed(double speed) {
        m_IndexerLeader.set(speed);
    }

    public void setSpeed(IndexerStates states) {
        m_IndexerLeader.set(states.getSpeed());
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Indexer Motor Current", getMotorCurrent());
    }
}
