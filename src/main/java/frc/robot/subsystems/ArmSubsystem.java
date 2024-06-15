// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
   private static final int deviceID1 = ArmConstants.motor1Port;
   private static final int deviceID2 = ArmConstants.motor2Port;
  private CANSparkMax motor1, motor2;
  private SparkPIDController pidController1, pidController2;
  private RelativeEncoder encoder1, encoder2;
  public double kP1, kI1, kD1, kIz1, kFF1, kMaxOutput1, kMinOutput1, kP2, kI2, kD2, kIz2, kFF2, kMaxOutput2, kMinOutput2;

    public ArmSubsystem(){
    // initialize motor
    motor1 = new CANSparkMax(deviceID1, MotorType.kBrushless);
    motor1.restoreFactoryDefaults();
    pidController1 = motor1.getPIDController();
    encoder1 = motor1.getEncoder();
    kP1 = 0.1; 
    kI1 = 1e-4;
    kD1 = 1; 
    kIz1 = 0; 
    kFF1 = 0; 
    kMaxOutput1 = 1; 
    kMinOutput1 = -1;
    pidController1.setP(kP1);
    pidController1.setI(kI1);
    pidController1.setD(kD1);
    pidController1.setIZone(kIz1);
    pidController1.setFF(kFF1);
    pidController1.setOutputRange(kMinOutput1, kMaxOutput1);
    SmartDashboard.putNumber("P Gain", kP1);
    SmartDashboard.putNumber("I Gain", kI1);
    SmartDashboard.putNumber("D Gain", kD1);
    SmartDashboard.putNumber("I Zone", kIz1);
    SmartDashboard.putNumber("Feed Forward", kFF1);
    SmartDashboard.putNumber("Max Output", kMaxOutput1);
    SmartDashboard.putNumber("Min Output", kMinOutput1);
    SmartDashboard.putNumber("Set Rotations", 0);

    // read PID coefficients from SmartDashboard
    double p1 = SmartDashboard.getNumber("P Gain", 0);
    double i1 = SmartDashboard.getNumber("I Gain", 0);
    double d1 = SmartDashboard.getNumber("D Gain", 0);
    double iz1 = SmartDashboard.getNumber("I Zone", 0);
    double ff1 = SmartDashboard.getNumber("Feed Forward", 0);
    double max1 = SmartDashboard.getNumber("Max Output", 0);
    double min1 = SmartDashboard.getNumber("Min Output", 0);
    double rotations1 = SmartDashboard.getNumber("Set Rotations", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
    if((p1 != kP1)) { pidController1.setP(p1); kP1 = p1; }
    if((i1 != kI1)) { pidController1.setI(i1); kI1 = i1; }
    if((d1 != kD1)) { pidController1.setD(d1); kD1 = d1; }
    if((iz1 != kIz1)) { pidController1.setIZone(iz1); kIz1 = iz1; }
    if((ff1 != kFF1)) { pidController1.setFF(ff1); kFF1 = ff1; }
    if((max1 != kMaxOutput1) || (min1 != kMinOutput1)) { 
      pidController1.setOutputRange(min1, max1); 
      kMinOutput1 = min1; kMaxOutput1 = max1; 
    }
    
    SmartDashboard.putNumber("SetPoint", rotations1);
    SmartDashboard.putNumber("ProcessVariable", encoder1.getPosition());

    motor2 = new CANSparkMax(deviceID2, MotorType.kBrushless);
    motor2.restoreFactoryDefaults();
    pidController2 = motor2.getPIDController();
    encoder2 = motor2.getEncoder();
    kP2 = 0.1; 
    kI2 = 1e-4;
    kD2 = 1; 
    kIz2 = 0; 
    kFF2 = 0; 
    kMaxOutput2 = 1; 
    kMinOutput2 = -1;
    pidController2.setP(kP2);
    pidController2.setI(kI2);
    pidController2.setD(kD2);
    pidController2.setIZone(kIz2);
    pidController2.setFF(kFF2);
    pidController2.setOutputRange(kMinOutput2, kMaxOutput2);
    SmartDashboard.putNumber("P Gain", kP2);
    SmartDashboard.putNumber("I Gain", kI2);
    SmartDashboard.putNumber("D Gain", kD2);
    SmartDashboard.putNumber("I Zone", kIz2);
    SmartDashboard.putNumber("Feed Forward", kFF2);
    SmartDashboard.putNumber("Max Output", kMaxOutput2);
    SmartDashboard.putNumber("Min Output", kMinOutput2);
    SmartDashboard.putNumber("Set Rotations", 0);

    // read PID coefficients from SmartDashboard
    double p2 = SmartDashboard.getNumber("P Gain", 0);
    double i2 = SmartDashboard.getNumber("I Gain", 0);
    double d2 = SmartDashboard.getNumber("D Gain", 0);
    double iz2 = SmartDashboard.getNumber("I Zone", 0);
    double ff2 = SmartDashboard.getNumber("Feed Forward", 0);
    double max2 = SmartDashboard.getNumber("Max Output", 0);
    double min2 = SmartDashboard.getNumber("Min Output", 0);
    double rotations2 = SmartDashboard.getNumber("Set Rotations", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
    if((p2 != kP2)) { pidController2.setP(p2); kP2 = p2; }
    if((i2 != kI2)) { pidController2.setI(i2); kI2 = i2; }
    if((d2 != kD2)) { pidController2.setD(d2); kD2 = d2; }
    if((iz2 != kIz2)) { pidController2.setIZone(iz2); kIz2 = iz2; }
    if((ff2 != kFF2)) { pidController2.setFF(ff2); kFF2 = ff2; }
    if((max2 != kMaxOutput2) || (min2 != kMinOutput2)) { 
      pidController2.setOutputRange(min2, max2); 
      kMinOutput2 = min2; kMaxOutput2 = max2; 
    }
    
    SmartDashboard.putNumber("SetPoint", rotations2);
    SmartDashboard.putNumber("ProcessVariable", encoder2.getPosition());
      pidController1.setReference(rotations1, CANSparkMax.ControlType.kPosition);
    }
    public void setPos(int pos){
        switch(pos){
          case 0:
          pidController1.setReference(ArmConstants.pos10, CANSparkMax.ControlType.kPosition);
          pidController2.setReference(ArmConstants.pos20, CANSparkMax.ControlType.kPosition);
          break;
          case 1:
          pidController1.setReference(ArmConstants.pos11, CANSparkMax.ControlType.kPosition);
          pidController2.setReference(ArmConstants.pos21, CANSparkMax.ControlType.kPosition);
          break;
          case 2:
          pidController1.setReference(ArmConstants.pos12, CANSparkMax.ControlType.kPosition);
          pidController2.setReference(ArmConstants.pos22, CANSparkMax.ControlType.kPosition);
          break;
          case 3:
          pidController1.setReference(ArmConstants.pos13, CANSparkMax.ControlType.kPosition);
          pidController2.setReference(ArmConstants.pos23, CANSparkMax.ControlType.kPosition);
          break;
        }



    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}