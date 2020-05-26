/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.constants.Constants;
import frc.robot.constants.ConstantsDriver;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.driver.CommandDriver;
import frc.robot.controllersTypes.simpleTypes.TalonSRXType;
import frc.robot.controllersTypes.simpleTypes.VictorSPType;
import frc.robot.controllersTypes.simpleTypes.SparkType;
import frc.robot.controllersTypes.doubleTypes.TalonsrxVictorspType;
import frc.robot.subsystems.driver.SubsystemDriver;

public class RobotContainer {

  private SubsystemDriver driver;
  private XboxController xboxController;
  private CommandDriver runDriver;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  private void configureSubsystems() {
    driver =
        new SubsystemDriver(
            new TalonSRXType(ConstantsDriver.leftID, ConstantsDriver.rightID),
            Constants.DEADBAND_VALUE,
            ConstantsDriver.encoderLeft,
            ConstantsDriver.encoderRight,
            ConstantsDriver.gyro,
            ConstantsDriver.limitSwitch);
  }

  private void configureCommands() {
    runDriver = new CommandDriver(driver);
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
    public Command getAutonomousCommand() {
      // An ExampleCommand will run in autonomous
      return m_autoCommand;
    }
  */

  public static SubsystemDriver subsDriver() {
    return driver;
  }

  public static XboxController xboxController() {
    return xboxController;
  }

  public static CommandDriver commDriver() {
    return runDriver;
  }
}
