// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Pivot;

public class PivotToPosition extends Command {
  private Pivot m_pivot;
  private double m_pivotSpeed = 0; //change later
  private double m_goalPosition;
  private double m_error;
  private double m_currentPosition;
  private double m_initialPosition;
  /** Creates a new PivotToPosition. */
  public PivotToPosition(Pivot pivot, double goal) {
    m_pivot = pivot;
    m_goalPosition = goal;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_pivot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_pivot.setPivotSpeed(0);
    m_initialPosition = m_pivot.getPivotPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pivot.setPivotSpeed(m_pivotSpeed);
    m_currentPosition = m_pivot.getPivotPosition() - m_initialPosition;
    m_error = m_goalPosition - m_currentPosition;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_pivot.setPivotSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_error < 0.1 && m_error > -0.1) {
      return true;
    }
    return false;
  }
}
