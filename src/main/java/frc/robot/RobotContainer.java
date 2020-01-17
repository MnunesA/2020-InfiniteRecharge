/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.storage.CommandStorage;
import frc.robot.subsystems.SubsystemStorage;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static SubsystemStorage storage;
  private static CommandStorage cstorage;
  private static XboxController xboxController;
  private static JoystickButton RB;

  public RobotContainer() {
 
    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    configureJoysticks();
  }

  private void configureButtonBindings() {
    RB = new JoystickButton(xboxController, Constants.RB);

    RB().whileHeld(RobotContainer.commStorage());
  }

  private void configureSubsystems() {
    storage = new SubsystemStorage(Constants.STORAGE_ID);
  }

  private void configureCommands() { 
    cstorage = new CommandStorage(storage);
  }

  private void configureJoysticks() {
    xboxController = new XboxController(Constants.XBOX_ID);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/

  public static SubsystemStorage subsStorage(){
    return storage;
  }

  public static CommandStorage commStorage(){
    return cstorage;
  }

  public static JoystickButton RB(){
    return RB;
  }
}
