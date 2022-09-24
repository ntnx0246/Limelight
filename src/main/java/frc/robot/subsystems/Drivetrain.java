// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;



public class Drivetrain extends SubsystemBase {
  private TalonSRX frontL;
  private TalonSRX frontR;
  private TalonSRX backL;
  private TalonSRX backR;
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    frontL = new TalonSRX(Constants.ID.DRIVETRAIN_FRONT_LEFT);
    frontR = new TalonSRX(Constants.ID.DRIVETRAIN_FRONT_RIGHT);
    backL = new TalonSRX(Constants.ID.DRIVETRAIN_BACK_LEFT);
    backR = new TalonSRX(Constants.ID.DRIVETRAIN_BACK_RIGHT);

    // frontL.
    backL.follow(frontL);
    backR.follow(frontR);

    frontL.setInverted(true);
    backL.setInverted(true);
    frontR.setInverted(false);
    backR.setInverted(false);

    frontL.setNeutralMode(NeutralMode.Brake);
    frontR.setNeutralMode(NeutralMode.Brake);
    backL.setNeutralMode(NeutralMode.Brake);
    backR.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadedrive(double a, double b){
    frontL.set(ControlMode.PercentOutput, b - a);
    frontR.set(ControlMode.PercentOutput, b + a);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    frontL.set(ControlMode.PercentOutput, leftSpeed);
    frontR.set(ControlMode.PercentOutput, rightSpeed);
  }
}
