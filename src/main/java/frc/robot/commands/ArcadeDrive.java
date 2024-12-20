// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
  private Joystick m_joystick;
  private Drivetrain m_drivetrain;
  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Joystick joystick, Drivetrain drivetrain) {
    m_joystick = joystick;
    m_drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.setRightSpeed(0);
    m_drivetrain.setLeftSpeed(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turn = m_joystick.getRawAxis(1)*0.25;//axis 1 is vertical axis of left stick
    double speed = m_joystick.getRawAxis(4)*0.25;//axis 4 is vertical axis of right stick
    
    double left = speed + turn;
    double right = speed - turn;

    //setnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn left and rightn
    m_drivetrain.setRightSpeed(right);
    m_drivetrain.setLeftSpeed(left);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //set left and right to 0
    m_drivetrain.setRightSpeed(0);
    m_drivetrain.setLeftSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
