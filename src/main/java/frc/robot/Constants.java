// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{

  public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag

  public static final class AutonConstants
  {

    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0, 0);
    public static final PIDConstants ANGLE_PID   = new PIDConstants(0.4, 0, 0.01);
  }

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND  = 0.1;
    public static final double LEFT_Y_DEADBAND  = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
    public static final double TURN_CONSTANT    = 6;
  }
  public static class MotorConstants
  {

    // Motor Ports
    public static final int INTAKE_MOTOR_PORT = 0;

  }
  public static class IntakeConstants
  {

    // Intake Speeds
    public static final int INTAKE_SPEED = 1;
    public static final int STOP_SPEED   = 0;
    public static final int INTAKE_REVERSE_SPEED = -1;
  }
  public static class ControllerConstants{
    public static final int DRIVER_PORT = 0;
    public static final int OPERATOR_PORT = 0;
  }
  public static class WristConstants
  {
    public static final int POSITION_DOWN = 0; //default encoder position
    public static final int POSITION_UP = 1;  // encoder position for up
    public static final double kP = 5e-5;
    public static final double kI = 1e-6;
    public static final double kD = 0;
    public static final double kIz = 0;
    public static final double kFF = 0.000156;
    public static final double kMaxOutput = 1;
    public static final double kMinOutput = -1;
    public static final double maxRPM = 5700;
    public static final double maxVel = 2000;
    public static final double maxAcc = 1500;
    public static final double maxVoltage = 10;
    public static final double kS = 0.171;
    public static final double kV = 0.0597;
    public static final double kA = 0.009;
    public static final double minVel = 0;
    public static final double allowedErr = 0;
    public static final int smartMotionSlot = 0;
    public static final int deviceID = 1;
  }
  public static class ArmConstants
  {
    public static final double kP = 5e-5;
    public static final double kI = 1e-6;
    public static final double kD = 0;
    public static final double kIz = 0;
    public static final double kFF = 0.000156;
    public static final double kMaxOutput = 1;
    public static final double kMinOutput = -1;
    public static final double maxRPM = 5700;
    public static final double maxVel = 2000;
    public static final double maxAcc = 1500;
    public static final double maxVoltage = 10;
    public static final double kS = 0.171;
    public static final double kV = 0.0597;
    public static final double kA = 0.009;
    public static final double minVel = 0;
    public static final double allowedErr = 0;
    public static final int smartMotionSlot = 0;
    public static final int deviceID = 1;
    public static final int POSITION_LEVEL_0 = 0;  // default encoder position
    public static final int POSITION_LEVEL_1 = 1;  // HUMAN PLAYER STATION
    public static final int POSITION_LEVEL_2 = 2;  // SCORE LEVEL 2
    public static final int POSITION_LEVEL_3 = 3;  // SCORE LEVEL 3
  }
}