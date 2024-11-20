// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private VictorSPX m_rightPrimary = new VictorSPX(0); //ask for port later
  private VictorSPX m_rightSecondary = new VictorSPX(0);
  private VictorSPX m_leftPrimary = new VictorSPX(0);
  private VictorSPX m_leftSecondary = new VictorSPX(0);
  /** Creates a new Drivetrain. */
  public Drivetrain() {}

  public void setRightSpeed(double rightSpeed) {
    m_rightPrimary.set(ControlMode.PercentOutput, rightSpeed);
    m_rightSecondary.set(ControlMode.PercentOutput, rightSpeed);
  }

  public void setLeftSpeed(double leftSpeed) {
    m_leftPrimary.set(ControlMode.PercentOutput, leftSpeed);
    m_leftSecondary.set(ControlMode.PercentOutput, leftSpeed);
  }

  public void setSpeed(double speed) {
    m_rightPrimary.set(ControlMode.PercentOutput, speed);
    m_rightSecondary.set(ControlMode.PercentOutput, speed);
    m_leftPrimary.set(ControlMode.PercentOutput, speed);
    m_leftSecondary.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
