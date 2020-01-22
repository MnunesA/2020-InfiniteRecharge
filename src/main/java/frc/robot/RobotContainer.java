/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.ConstantsShooterEStorage;
import frc.robot.commands.shooter_and_storage.CommandShooterEStorage;
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
  private static CommandShooterEStorage commandShooterEStorage;
  private static Joystick joystick;
  private static JoystickButton j_Fire;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    j_Fire = new JoystickButton(joystick, Constants.J_FIRE_NUMBER);
    j_Fire.whileHeld(commandShooterEStorage);
  }

  private void configureSubsystems() {
    subsystemStorage = new SubsystemStorage(ConstantsStorage.MOTOR_STORAGE_ID);
    subsystemShooter = new SubsystemShooter(ConstantsShooter.MOTOR_SHOOTER_ID, ConstantsShooter.MOTOR_SHOOTERANGLE_ID);
  }

  private void configureCommands() {
    commandShooterEStorage = new CommandShooterEStorage(subsystemShooter, subsystemStorage,
    ConstantsShooterEStorage.STORAGE_SPEED_COMMANDSHOOTERESTORAGE, 
    ConstantsShooterEStorage.SHOOTER_SPEED_COMMANDSHOOTERESTORAGE);
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

  public static CommandShooterEStorage commShooterAndStorage() {
    return commandShooterEStorage;
  }

  public static JoystickButton j_Fire() {
    return j_Fire;
  }
}
