/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.CommandControlPanel;
import frc.robot.subsystems.SubsystemControlPanel;

public class RobotContainer {

  private static SubsystemControlPanel subsystemControlPanel;
  private static CommandControlPanel commandControlPanel;
  private static Joystick joystick;
  private static XboxController xboxController;
  private static JoystickButton X;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    X = new JoystickButton(xboxController, 3);
    X.whenPressed(commandControlPanel);
  }

  private void configureSubsystems() {
    subsystemControlPanel = new SubsystemControlPanel(ConstantsControlPanel.MOTOR_CONTROL_PANEL);
  }

  private void configureCommands() {
    commandControlPanel = new CommandControlPanel(subsystemControlPanel, ConstantsControlPanel.CONTROL_PANEL_SPEED, ConstantsControlPanel.TIMER_CONTROLPANEL);
  }
  private void configureJoysticks() {
    joystick = new Joystick(Constants.JOYSTICK_ID);
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
}