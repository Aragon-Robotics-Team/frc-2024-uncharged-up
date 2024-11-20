// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pivot extends SubsystemBase {

  private CANSparkMax m_pivotMotorLeft = new CANSparkMax(0, MotorType.kBrushless);
  private CANSparkMax m_pivotMotorRight = new CANSparkMax(0, MotorType.kBrushless);
  private DutyCycleEncoder m_encoder = new DutyCycleEncoder(0);

  /** Creates a new Pivot. */
  public Pivot() {}


  public void setPivotSpeed(double speed) {
    m_pivotMotorLeft.set(speed);
    m_pivotMotorRight.set(-speed);
    //ask which neo is negative 
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  } 
}
