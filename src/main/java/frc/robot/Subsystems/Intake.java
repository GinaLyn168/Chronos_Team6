package frc.robot.Subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    // Grace
    
    private static Intake instance;

    public static Intake getInstance() {
        if (instance == null) {
            instance = new Intake();
        }
        return instance;
    }

    private IntakeStates currentState = IntakeStates.OFF;

    private TalonFX intakeM;

    public Intake() {
        // Rollers
        intakeM = new TalonFX(Constants.Ports.intake);
        configMotor(intakeM);
    }

    private void configMotor(TalonFX motor) {
        TalonFXConfiguration config = new TalonFXConfiguration();
        CurrentLimitsConfigs currentLimitsConfigs = new CurrentLimitsConfigs();
        config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        config.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = 0.5;

        config.CurrentLimits = currentLimitsConfigs;
        motor.getConfigurator().apply(config);
    }

    private void configMotor(TalonFX motor, boolean inverted) {
        motor.setInverted(false);
    }

    public double getMotorVoltage() {
        return intakeM.getMotorVoltage().getValueAsDouble();
    }

    public enum IntakeStates {
        ON(0.45),
        INDEX(0.5),
        OFF(0),
        REV(-0.4);

        private double speed;

        public double getValue() {
            return speed;
        }

        IntakeStates(double speed) {
            this.speed = speed;
        }
    }

    public void setSpeed(IntakeStates state) {
        // intakeM.setControl(dutyCycleRequest.withOutput(state.speed));
        currentState = state;
    }

    @Override
    public void periodic() {
        //
    }

    @Override
    public void simulationPeriodic() {
    }
}