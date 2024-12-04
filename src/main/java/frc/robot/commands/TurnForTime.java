// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class TurnForTime extends Command {
  private Drivetrain m_drivetrain;
  private double m_turnTime;
  private Timer m_timer = new Timer();
  private double m_speed;
  private boolean m_turningLeft;
  /** Creates a new TurnForTime. */
  public TurnForTime(Drivetrain drivetrain, double time, double speed, boolean turningLeft) {
    m_drivetrain = drivetrain;
    m_turnTime = time;
    m_speed = speed;
    m_turningLeft = turningLeft;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  private double timeStarted;

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.setSpeed(0);
    m_timer.start();
    timeStarted = m_timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_turningLeft) {
      m_drivetrain.setLeftSpeed(m_speed);
    } else {
      m_drivetrain.setRightSpeed(m_speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_timer.get() - timeStarted >= m_turnTime) {
      return true;
    }
    return false;
  }
}