// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.SpinForIntake;
import frc.robot.commands.SpinForOuttake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pivot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Intake m_intakeMotor = new Intake();
  private SpinForIntake m_intakeSpin = new SpinForIntake(m_intakeMotor);
  private SpinForOuttake m_outtakeSpin = new SpinForOuttake(m_intakeMotor);
  private Joystick m_joystick = new Joystick(0);
  private JoystickButton m_intakeButton = new JoystickButton(m_joystick, 8);
  private JoystickButton m_outtakeButton = new JoystickButton(m_joystick, 7);

  private Drivetrain m_drivetrain = new Drivetrain();
  private ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_joystick, m_drivetrain);

  //private Pivot m_pivot = new Pivot();
  //private PivotToPosition m

  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_intakeButton.whileTrue(m_intakeSpin); //while the "x" button is pressed, do this
    m_outtakeButton.whileTrue(m_outtakeSpin); //while the "y" button is pressed, do this
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getTeleopCommand() {
    m_drivetrain.setDefaultCommand(m_arcadeDrive);
    return null;
  }
   
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
