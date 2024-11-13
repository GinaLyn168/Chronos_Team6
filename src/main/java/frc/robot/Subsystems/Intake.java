package frc.robot.Subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
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

    private TalonFX intakeLeaderM;

    // private TalonFX intakeFollowerM;
    // private TalonFX serialM;

    public Intake() {
        // Rollers
        // intakeLeaderM = new TalonFX(Constants.HardwarePorts.intakeLeaderM);
        // intakeFollowerM = new TalonFX(Constants.HardwarePorts.intakeFollowerM);
        // configMotor(intakeLeaderM);
        // configMotor(intakeFollowerM);
        // intakeFollowerM.setInverted(true);

        // Serial
        // serialM = new TalonFX(Constants.HardwarePorts.serialM);
        // configMotor(serialM, false);
    }

    private void configMotor(TalonFX motor) {

        // TalonFXConfiguration config = new TalonFXConfiguration();
        // CurrentLimitsConfigs currentLimitsConfigs = new CurrentLimitsConfigs();

        // currentLimitsConfigs.SupplyCurrentLimit = Constants.intakeContinuousCurrentLimit;
        // currentLimitsConfigs.SupplyCurrentLimitEnable = true;
        // currentLimitsConfigs.SupplyCurrentThreshold = Constants.intakePeakCurrentLimit;
        // config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        // config.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = 0.5;

        // Slot0Configs slot0Configs = new Slot0Configs();

        // config.CurrentLimits = currentLimitsConfigs;
        // motor.getConfigurator().apply(config);
    }

    private void configMotor(TalonFX motor, boolean inverted) {
        // motor.setInverted(false);
    }

    public double getMotorVoltage() {
        // return intakeLeaderM.getMotorVoltage().getValueAsDouble();
    }

    public enum IntakeStates {
        ON(0.45, 0.85),
        INDEX(0.5, 0.5),
        OFF(0, 0),
        REV(-0.4, -0.8);

        private double speed;
        private double serialSpeed;

        public double getValue() {
            return speed;
        }

        IntakeStates(double speed, double serialSpeed) {
            this.speed = speed;
            this.serialSpeed = serialSpeed;
        }
    }

    public void setSpeed(IntakeStates state) {
        // intakeLeaderM.setControl(dutyCycleRequest.withOutput(state.speed));
        
        // intakeFollowerM.setControl(follow);
        // serialM.set(state.serialSpeed);
        // currentState = state;
    }

    @Override
    public void periodic() {
        // SmartDashboard.putBoolean("Intake/Intake On", intakeLeaderM.getMotorVoltage().getValueAsDouble() > 2);
    }

    @Override
    public void simulationPeriodic() {
    }
}