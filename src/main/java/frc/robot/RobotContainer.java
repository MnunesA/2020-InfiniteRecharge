/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.SubsystemClimber;

public class RobotContainer {

  SubsystemClimber subsystemClimber;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  private void configureSubsystems() {
    subsystemClimber = new SubsystemClimber(ConstantsClimber.MOTOR_ELEVATOR_1_ID, ConstantsClimber.MOTOR_ELEVATOR_2_ID, 
    ConstantsClimber.MOTOR_CLIMBER_1_ID, ConstantsClimber.MOTOR_CLIMBER_2_ID);
  }

  private void configureCommands() {

  }
  private void configureJoysticks() {
  
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
  
  // Obtém o valor referente ao eixo LY do controle de XBOX
}