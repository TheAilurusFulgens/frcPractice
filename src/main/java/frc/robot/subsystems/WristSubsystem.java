// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



/*
 * REQUIERMENTS
 * 
 * 2 Positions for wrist 
 * Set their position...
 */
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WristSubsystem extends SubsystemBase {
  private final CANSparkMax wristMotor = new CANSparkMax(Constants.WristConstants.PORT, MotorType.kBrushless);
  /** Creates a new WristSubsystem. */
  public WristSubsystem(double position) {
    setWristPosition(position);
  }

  public void setWristPosition(double position) {
    wristMotor.getEncoder().setPosition(position);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
