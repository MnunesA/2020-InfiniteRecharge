/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.CommandDriver;
import frc.robot.subsystems.SubsystemDriver;

public class RobotContainer {

  private static SubsystemDriver driver;
  private static XboxController xboxController;
  private static CommandDriver runDriver;

  public RobotContainer() {

    driver = new SubsystemDriver(
            Constants.MOTOR_LEFT_FRONT_ID,
            Constants.MOTOR_LEFT_REAR_ID,
            Constants.MOTOR_RIGHT_FRONT_ID,
            Constants.MOTOR_RIGHT_REAR_ID,
            Constants.ENCODER_DRIVER_CHANNEL_A_ID,
            Constants.ENCODER_DRIVER_CHANNEL_B_ID,
            Constants.ENCODER_DRIVER_MAX_PERIOD,
            Constants.ENCODER_DRIVER_MIN_RATE,
            Constants.ENCODER_DRIVER_DISTANCE_PER_PULSE,
            Constants.DEADBAND_VALUE,
            Constants.ENCODER_DRIVER_INVERTED);

    xboxController = new XboxController(Constants.XBOX_ID);

    runDriver = new CommandDriver(driver);

    configureButtonBindings();
  }

  private void configureButtonBindings() {}

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
  
  public static SubsystemDriver subsDriver() {
    return driver;
  }
  
  public static XboxController xboxController(){
    return xboxController;
  }
  
  // Obtém o valor referente ao analógico direito do controle de XBOX
  public static GenericHID.Hand rHand(){
    return GenericHID.Hand.kRight;
  }
  
    // Obtém o valor referente ao analógico esquerdo do controle de XBOX
  public static GenericHID.Hand lHand(){
    return GenericHID.Hand.kLeft;
  }
  
  public static CommandDriver commDriver(){
    return runDriver;
  }
}