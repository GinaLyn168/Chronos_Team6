package frc.robot.Commands.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Intake;

public class SetIntake extends Command {
    private final Intake s_Intake;
    Intake.IntakeStates state;

    private Timer timer;
    private double time;

    public SetIntake(Intake.IntakeStates state, double time) {
        s_Intake = Intake.getInstance();

        this.state = state;
        this.time = time;
        timer = new Timer();

        addRequirements(s_Intake);
    }

    public SetIntake(Intake.IntakeStates state) {
        this(state, 4);
    }


    @Override
    public void initialize() {
        s_Intake.setSpeed(state);
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        // Nothing needs to run repeatedly for this command
    }

    @Override
    public void end(boolean interrupted) {
        s_Intake.setSpeed(Intake.IntakeStates.OFF);
    }

    @Override
    public boolean isFinished() { // Chronos no sensor????
        return timer.hasElapsed(time);
    }
}