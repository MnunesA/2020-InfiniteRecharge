/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.shooter_and_storage.CommandShooterAndStorage;
import frc.robot.subsystems.SubsystemShooter;
import frc.robot.subsystems.SubsystemStorage;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static SubsystemStorage subsystemStorage;
  private static SubsystemShooter subsystemShooter;
  private static CommandShooterAndStorage commandShooterAndStorage;
  private static Joystick joystick;
  private static JoystickButton J_Fire;

  public RobotContainer() {
    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    configureJoysticks();
  }

  private void configureButtonBindings() {
    J_Fire = new JoystickButton(joystick, Constants.J_FIRE_NUMBER);
    J_Fire.whenPressed(commandShooterAndStorage);
  }

  private void configureSubsystems() {
    subsystemStorage = new SubsystemStorage(Constants.MOTOR_STORAGE_ID);
    subsystemShooter = new SubsystemShooter(Constants.MOTOR_SHOOTER_ID, Constants.MOTOR_SHOOTERANGLE_ID);
  }

  private void configureCommands() {
    commandShooterAndStorage = new CommandShooterAndStorage(subsystemShooter, subsystemStorage,
    Constants.MOTOR_STORAGE_SPEED_COMMANDSHOOTERANDSTORAGE, Constants.MOTOR_SHOOTER_SPEED_COMMANDSHOOTERANDSTORAGE, Constants.TIMER_COMMANDSHOOTERANDSTORAGE);
  }

  private void configureJoysticks() {
    joystick = new Joystick(Constants.JOYSTICK_ID);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*
   * public Command getAutonomousCommand() { // An ExampleCommand will run in
   * autonomous return m_autoCommand; }
   */

  public static SubsystemStorage subsStorage() {
    return subsystemStorage;
  }

  public static SubsystemShooter subsShooter() {
    return subsystemShooter;
  }

  public static CommandShooterAndStorage commShooterAndStorage() {
    return commandShooterAndStorage;
  }

  public static JoystickButton J_Fire() {
    return J_Fire;
  }
}
