// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.WristSubsystem;

public class PosCommand extends Command {
  /** Creates a new armCommand. */
  private ArmSubsystem arm;
  private WristSubsystem wrist;
  private final int pos;
  public PosCommand(ArmSubsystem arm, WristSubsystem wrist, int pos) {
    this.arm = arm;
    this.wrist = wrist;
    this.pos = pos;
    addRequirements(this.arm, this.wrist);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.setPos(pos);
    wrist.setPos(pos);
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
