package frc.robot.Commands.Drivetrain;

import java.util.List;

import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.CommandSwerveDrivetrain;
// import frc.robot.subsystems.Vision;
import frc.robot.RobotContainer;

public class SlowDrive extends Command {

    public SlowDrive() {
    }



    @Override
    public void initialize() {
        Constants.MaxAngularRate = 1*Math.PI;
        Constants.MaxSpeed = 2;
    }
    
    @Override
    public void execute(){
    }

    @Override
    public void end(boolean interrupted) {
        Constants.MaxAngularRate = 3*Math.PI;
        Constants.MaxSpeed = 6;
    }

    @Override
    public boolean isFinished() { //always use in WhileTrue
        return false;
    }   
}