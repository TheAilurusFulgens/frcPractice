// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private CANSparkMax armMotor1;
  private CANSparkMax armMotor2;



  private static final int deviceID = 1;
  private SparkPIDController m_pidController;
  private  RelativeEncoder m_encoder;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM, maxVel, minVel, maxAcc, allowedErr;

  
  /** Creates a new Arm. */
  public Arm(Double position) {
    armMotor1  = new CANSparkMax(Constants.ArmConstants.ARM_MOTOR1_PORT, CANSparkMax.MotorType.kBrushless);
    armMotor2 =  new CANSparkMax(Constants.ArmConstants.ARM_MOTOR2_PORT, CANSparkMax.MotorType.kBrushless);
    armMotor2.follow(armMotor1);

    m_pidController = armMotor1.getPIDController();
     m_encoder = armMotor1.getEncoder();

     // PID coefficients
    kP = 5e-5; 
    kI = 1e-6;
    kD = 0; 
    kIz = 0; 
    kFF = 0.000156; 
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 5700;

    // Smart Motion Coefficients
    maxVel = 2000; // rpm
    maxAcc = 1500;

    // set PID coefficients
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    int smartMotionSlot = 0;
    m_pidController.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
    m_pidController.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
    m_pidController.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
    m_pidController.setSmartMotionAllowedClosedLoopError(allowedErr, smartMotionSlot);
    setArmPos(position);
  }

  //sets wrists position 
  public void setArmPos(double pos){
 //   wristMotor.getEncoder().setPosition(pos);
 m_pidController.setReference(pos, CANSparkMax.ControlType.kSmartMotion);
 

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
