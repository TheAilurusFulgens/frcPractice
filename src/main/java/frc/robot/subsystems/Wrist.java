// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wrist extends SubsystemBase {
  /** Creates a new Wrist. */
  private CANSparkMax wristMotor = new CANSparkMax(Constants.WristConstants.WRIST_MOTOR_PORT, CANSparkMax.MotorType.kBrushless);

  public Wrist(double position) {
    setWristPos(position);
  }

  //sets wrists position 
  public void setWristPos(double pos){
    wristMotor.getEncoder().setPosition(pos);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
