// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WristConstants;

public class WristSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final CANSparkMax wristMotor = new CANSparkMax(WristConstants.port, MotorType.kBrushless);
  private RelativeEncoder encoder;
  public WristSubsystem() {
      
  }
  public void setPos(int pos){
    int tick;
    switch(pos){
      case 0:
      tick = WristConstants.pos0;
      break;
      case 1:
      tick = WristConstants.pos1;
      break;
      case 2:
      tick = WristConstants.pos2;
      break;
      case 3:
      tick = WristConstants.pos3;
      break;
      default:
      tick = WristConstants.pos0;  
    }
    while(encoder.getPosition() > 1.02 * tick || encoder.getPosition() < .98*tick){
      if(encoder.getPosition()>tick){
        wristMotor.set(-1);
      }
      else{
        wristMotor.set(1);
      }
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}