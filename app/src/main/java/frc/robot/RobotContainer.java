/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.CommandClimber;
import frc.robot.commands.CommandElevator;
import frc.robot.subsystems.climber.SubsystemClimber;
import frc.robot.subsystems.climber.SubsystemClimberVictorSP;
import frc.robot.subsystems.elevator.SubsystemElevator;
import frc.robot.subsystems.elevator.SubsystemElevatorVictorSP;

public class RobotContainer {

  private static SubsystemClimber subsystemClimber;
  private static SubsystemElevator subsystemElevator;
  private static CommandElevator commandElevator;
  private static CommandClimber commandClimber;
  private static Joystick joystick;

  public RobotContainer() {
    configureSubsystems();
    configureCommands();
    configureJoysticks();
    configureButtonBindings();
  }

  private void configureButtonBindings() {}

  private void configureSubsystems() {
    subsystemClimber = new SubsystemClimberVictorSP(ConstantsClimber.MOTOR_CLIMBER_1_ID, 
    ConstantsClimber.MOTOR_CLIMBER_2_ID);
    
    subsystemElevator = new SubsystemElevatorVictorSP(ConstantsClimber.MOTOR_ELEVATOR_1_ID,
    ConstantsClimber.MOTOR_ELEVATOR_2_ID, ConstantsClimber.THERE_IS_ENCODER);
  }

  private void configureCommands() {
    commandElevator = new CommandElevator(subsystemElevator, ConstantsClimber.SPEED_COMMANDELEVATOR);
    commandClimber = new CommandClimber(subsystemClimber);
  }
  private void configureJoysticks() {
    joystick = new Joystick(Constants.JOYSTICK_ID);
  }
  
  public static int getPOV(){
    return joystick.getPOV();
  }

  public static double getJoystick_Y() {
    return -joystick.getRawAxis(1) * 0.6;
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
  
  public static SubsystemClimber subsystemClimber() {
    return subsystemClimber;
  }

  public static CommandClimber commandClimber() {
    return commandClimber;
  }

  public static SubsystemElevator subsystemElevator() {
    return subsystemElevator;
  }

  public static CommandElevator commandElevator() {
    return commandElevator;
  }
}