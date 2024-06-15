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
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.WristConstants;

public class WristSubsystem extends SubsystemBase {
  
  
  private final CANSparkMax wristMotor;
  private SparkPIDController m_pidController;
  private RelativeEncoder m_encoder;
  
  /** Creates a new WristSubsystem. */
  public WristSubsystem(double position) {
    wristMotor = new CANSparkMax(WristConstants.deviceID, MotorType.kBrushless);

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    wristMotor.restoreFactoryDefaults();

    // initialze PID controller and encoder objects
    m_pidController = wristMotor.getPIDController();
    m_encoder = wristMotor.getEncoder();

    // set PID coefficients
    m_pidController.setP(WristConstants.kP);
    m_pidController.setI(WristConstants.kI);
    m_pidController.setD(WristConstants.kD);
    m_pidController.setIZone(WristConstants.kIz);
    m_pidController.setFF(WristConstants.kFF);
    m_pidController.setOutputRange(WristConstants.kMinOutput, WristConstants.kMaxOutput);
    m_pidController.setSmartMotionMaxVelocity(WristConstants.maxVel, WristConstants.smartMotionSlot);
    m_pidController.setSmartMotionMinOutputVelocity(WristConstants.minVel, WristConstants.smartMotionSlot);
    m_pidController.setSmartMotionMaxAccel(WristConstants.maxAcc, WristConstants.smartMotionSlot);
    m_pidController.setSmartMotionAllowedClosedLoopError(WristConstants.allowedErr, WristConstants.smartMotionSlot);
    setWristPosition(position);
  }

  public void setWristPosition(double position) {
    //wristMotor.getEncoder().setPosition(position); 
    // use smart motion for this
    m_pidController.setReference(position, CANSparkMax.ControlType.kSmartMotion);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
