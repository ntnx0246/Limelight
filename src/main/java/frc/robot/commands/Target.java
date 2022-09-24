// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.Constants;

public class Target extends CommandBase {
  /** Creates a new Target. */
  Drivetrain driveTrain;
  Limelight limelight;
  public Target() {
    addRequirements(driveTrain, limelight);
    this.driveTrain = driveTrain;
    this.limelight = limelight;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println(limelight.x);
    if (Constants.ERROR_LIMELIGHT < Math.abs(limelight.x)){
      driveTrain.tankDrive(limelight.x * 0.1, -limelight.y * 0.1);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}