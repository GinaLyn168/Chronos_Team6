// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Indexer.MoveIndexer;
import frc.robot.Commands.Intake.SetIntake;
import frc.robot.Commands.Shooter.SetShooter;
import frc.robot.Subsystems.CommandSwerveDriveTrain;
import frc.robot.Subsystems.Indexer;
import frc.robot.Subsystems.Intake;
import frc.robot.Subsystems.Indexer.IndexerStates;
import frc.robot.Subsystems.Intake.IntakeStates;
import frc.robot.Subsystems.Shooter.ShooterState;
import frc.robot.Constants;

public class RobotContainer {

  public final CommandXboxController driver = new CommandXboxController(0); // Driver joystick
  private RobotContainer container;
  public RobotContainer getInstance() {
    if (container == null) {
      container = new RobotContainer();
    }
    return container;
  }
  
  private final CommandSwerveDriveTrain drivetrain = CommandSwerveDriveTrain.getInstance(); // Drivetrain
  
    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(Constants.MaxSpeed * translationDeadband).withRotationalDeadband(Constants.MaxAngularRate * rotDeadband)
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // I want field-centric

    public static final double translationDeadband = 0.1;
    public static final double rotDeadband = 0.1;
    

    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();
    //private final Telemetry logger = new Telemetry(Constants.MaxSpeed);

  /* Driver Buttons */
  private final Trigger driverBack = driver.back();
  private final Trigger driverStart = driver.start();
  private final Trigger driverA = driver.a();
  private final Trigger driverB = driver.b();
  private final Trigger driverX = driver.x();
  private final Trigger driverY = driver.y();
  private final Trigger driverRightBumper = driver.rightBumper();
  private final Trigger driverLeftBumper = driver.rightBumper();
  private final Trigger driverLeftTrigger = driver.leftTrigger();
  private final Trigger driverRightTrigger = driver.rightTrigger();
  private final Trigger driverDpadUp = driver.povUp();
  private final Trigger driverDpadDown = driver.povDown();
  private final Trigger driverDpadLeft = driver.povLeft();
  private final Trigger driverDpadRight = driver.povRight();

  private final Indexer s_Indexer = Indexer.getInstance();

  public RobotContainer() {
    configureBindings();
    driver.a().onTrue(new MoveIndexer(IndexerStates.ON, 1));
    driver.b().onTrue(new MoveIndexer(IndexerStates.REV, 1));
    driver.x().onTrue(new MoveIndexer(IndexerStates.OFF, 1));
    driver.y().onTrue(new SetIntake(IntakeStates.ON, 1));
    driver.rightBumper().onTrue(new SetIntake(IntakeStates.REV, 1));
    driver.leftBumper().onTrue(new SetIntake(IntakeStates.OFF, 1));
    driver.rightTrigger().onTrue(new SetShooter(ShooterState.SHOOT));
    driver.leftTrigger().onTrue(new SetShooter(ShooterState.STANDBY));
    
        
    /*
      * Drivetrain bindings
      */
    drivetrain.setDefaultCommand( // Drivetrain will execute this command periodically
            drivetrain.applyRequest(() -> drive.withVelocityX(-driver.getLeftY() * Constants.MaxSpeed) // Drive forward with
                    // negative Y (forward)
                    .withVelocityY(-driver.getLeftX() * Constants.MaxSpeed) // Drive left with negative X (left)
                    .withRotationalRate(-driver.getRightX() * Constants.MaxAngularRate) // Drive counterclockwise with negative X (left)
            ));

    // reset the field-centric heading. AKA reset odometry
    driverBack.onTrue(new InstantCommand(() -> drivetrain.resetOdo(new Pose2d(0, 0, new Rotation2d()))));
    driverStart.onTrue(new ZeroShooter());
  }
  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
