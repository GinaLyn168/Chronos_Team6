package frc.robot.Commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter;
import frc.robot.Subsystems.Shooter.ShooterState;

public class SetShooter extends Command {
    Shooter s_Shooter;

    private double velocity;
    private ShooterState state;

    public SetShooter(double velocity) {
        s_Shooter = Shooter.getInstance();

        this.velocity = velocity;
    }
    
    public SetShooter(ShooterState state) {
        s_Shooter = Shooter.getInstance();

        this.state = state;
        velocity = this.state.getValue();
    }

    @Override
    public void initialize() {
        s_Shooter.setSpeed(velocity);
    }

    @Override
    public void execute() {

    }

    @Override
	public boolean isFinished() {
        return true;
	}
		
	@Override
	public void end(boolean interrupted) {

	}
}
