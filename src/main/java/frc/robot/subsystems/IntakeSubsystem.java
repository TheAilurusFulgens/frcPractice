// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private CANSparkMax intakeMotor = new CANSparkMax(Constants.MotorConstants.INTAKE_MOTOR_PORT, CANSparkMax.MotorType.kBrushless);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem(double speed) {
    setIntakeSpeed(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setIntakeSpeed(double speed){
    intakeMotor.set(speed);
  }
}
