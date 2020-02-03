/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.intake.CommandToTake;
import frc.robot.subsystems.*;

public class RobotContainer {

  private static SubsystemIntake intake;
  private static SubsystemStorage storage;
  private static XboxController xboxController;
  private static CommandToTake commandToTake;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  private void configureSubsystems() {
    intake = new SubsystemIntake(ConstantsIntake.MOTOR_ANGULATION_ID, ConstantsIntake.MOTOR_TO_TAKE_ID,
        ConstantsIntake.LIMITSWITCH_UP_ID, ConstantsIntake.LIMITSWITCH_DOWN_ID);
    storage = new SubsystemStorage(ConstantsStorage.MOTOR_STORAGE_ID);
  }

  private void configureCommands() {
    commandToTake = new CommandToTake(intake, storage, ConstantsIntakeEStorage.LIMITER_SPEED_COMMANDTOTAKE);
  }

  private void configureJoysticks() {
    xboxController = new XboxController(Constants.XBOX_ID);
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

  public static SubsystemIntake subsIntake() {
    return intake;
  }

  public static XboxController xboxController() {
    return xboxController;
  }

  // obtém a soma dos dois eixos
  public static double axis_sum() {
    double axis_LT = -((xboxController.getRawAxis(2) + 1) / 2);
    double axis_RT = (xboxController.getRawAxis(3) + 1) / 2;
    double cancel = axis_LT + axis_RT;
    return cancel;
  }

  public static CommandToTake commandToTake() {
    return commandToTake;
  }

  public static SubsystemStorage subsStorage() {
    return storage;
  }
}