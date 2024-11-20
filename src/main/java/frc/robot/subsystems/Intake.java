// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private TalonFX m_intakeMotor = new TalonFX(0);//change ID later
  /** Creates a new Intake. */
  public Intake() {}

  public void setIntakeSpeed(double intakeSpeed) {
    m_intakeMotor.set(intakeSpeed);
  }

  public void setOuttakeSpeed(double outtakeSpeed) {
    m_intakeMotor.set(outtakeSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
