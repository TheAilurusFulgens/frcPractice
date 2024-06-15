// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wrist;

public class ArmWristCommand extends Command {
  /** Creates a new ArmWristCommand. */
  Arm arm;
  private final int armPosition;
  Wrist wrist;
  private final int wristPosition;
  public ArmWristCommand(Arm arm, int armPosition, Wrist wrist,int wristPosition) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm;
    this.armPosition = armPosition;
    addRequirements(this.arm);
    this.wrist = wrist;
    this.wristPosition = wristPosition;
    addRequirements(this.wrist);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.setArmPos(armPosition);
    wrist.setWristPos(wristPosition);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}