/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.intake.CommandToTake;
import frc.robot.subsystems.SubsystemIntake;

public class RobotContainer {

  private static SubsystemIntake intake;
  private static XboxController xboxController;
  private static CommandToTake commandToTake;
  private static Joystick joystick;
  private static JoystickButton j_Three;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    j_Three = new JoystickButton(joystick, Constants.J_THREE_NUMBER);
  }

  private void configureSubsystems() {
    intake = new SubsystemIntake(ConstantsIntake.MOTOR_ANGULATION_ID, ConstantsIntake.MOTOR_TO_TAKE_ID,
    ConstantsIntake.LIMITSWITCH_UP_ID, ConstantsIntake.LIMITSWITCH_DOWN_ID);
  }

  private void configureCommands() {
    commandToTake = new CommandToTake(intake);
  }
  private void configureJoysticks() {
    xboxController = new XboxController(Constants.XBOX_ID);
    joystick = new Joystick(Constants.JOYSTICK_ID);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  /*
    public Command getAutonomousCommand() {
      // An ExampleCommand will run in autonomous
      return m_autoCommand;
    }
  */
  
  public static SubsystemIntake subsIntake() {
    return intake;
  }
  
  public static XboxController xboxController(){
    return xboxController;
  }
  
  // Obtém o valor referente ao eixo LY do controle de XBOX
  public static double axis_RT(){
    return xboxController.getTriggerAxis(GenericHID.Hand.kRight);
  }
  
    // Obtém o valor referente ao eixo RX do controle de XBOX invertido
  public static double axis_LT(){
    return xboxController.getTriggerAxis(GenericHID.Hand.kLeft);
  }
  
  public static CommandToTake commandToTake(){
    return commandToTake;
  }
}