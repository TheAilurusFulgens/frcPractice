// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.text.Position;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Constants.ArmConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private final CANSparkMax topArmMotor;
  private final CANSparkMax bottomArmMotor = new CANSparkMax(0, MotorType.kBrushless);
  private SparkPIDController m_pidController;
  private RelativeEncoder m_encoder;
  public ArmSubsystem(double position) {
    topArmMotor = new CANSparkMax(ArmConstants.deviceID, MotorType.kBrushless);
    bottomArmMotor.follow(topArmMotor);

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    topArmMotor.restoreFactoryDefaults();

    // initialze PID controller and encoder objects
    m_pidController = topArmMotor.getPIDController();
    m_encoder = topArmMotor.getEncoder();
    m_pidController.setP(ArmConstants.kP);
    // set PID coefficients
    m_pidController.setI(ArmConstants.kI);
    m_pidController.setD(ArmConstants.kD);
    m_pidController.setIZone(ArmConstants.kIz);
    m_pidController.setFF(ArmConstants.kFF);
    m_pidController.setOutputRange(ArmConstants.kMinOutput, ArmConstants.kMaxOutput);
    m_pidController.setSmartMotionMaxVelocity(ArmConstants.maxVel, ArmConstants.smartMotionSlot);
    m_pidController.setSmartMotionMinOutputVelocity(ArmConstants.minVel, ArmConstants.smartMotionSlot);
    m_pidController.setSmartMotionMaxAccel(ArmConstants.maxAcc, ArmConstants.smartMotionSlot);
    m_pidController.setSmartMotionAllowedClosedLoopError(ArmConstants.allowedErr, ArmConstants.smartMotionSlot);
    setArmPosition(position);
  }

  public void setArmPosition(double position) {
    m_pidController.setReference(position, CANSparkMax.ControlType.kSmartMotion);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
