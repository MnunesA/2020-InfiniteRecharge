/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.shooter.CommandAngle;
import frc.robot.commands.shooter.CommandShooter;
import frc.robot.subsystems.SubsystemShooter;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

private static SubsystemShooter shooter;
private static CommandShooter commandShooter;
private static CommandAngle commandAngleUp;
private static CommandAngle commandAngleDown; 
private static Joystick joystick;
private static JoystickButton J_Thumb;
private static JoystickButton J_Fire;
private static JoystickButton Test;

  public RobotContainer() {

    configureButtonBindings();
    configureSubsystems();
    configureCommands();
    configureJoysticks();
  }

  private void configureButtonBindings() {

    J_Fire = new JoystickButton(joystick, Constants.J_FIRE);
    J_Thumb = new JoystickButton(joystick, Constants.J_THUMB);
    Test = new JoystickButton(joystick, Constants.TEST);

    J_Fire.whileHeld(commandShooter);
    J_Thumb.whileHeld(commandAngleUp);
    Test.whileHeld(commandAngleDown);
  }

  private void configureSubsystems() {
    shooter = new SubsystemShooter(ConstantsShooter.MOTOR_SHOOTER_ID, ConstantsShooter.MOTOR_ANGLE_ID);
  }

  private void configureCommands() {
    commandShooter = new CommandShooter(shooter, ConstantsShooter.SHOOTERSPEED);
    commandAngleUp = new CommandAngle(shooter, ConstantsShooter.ANGLE_SPEED_POSITIVE);
    commandAngleDown = new CommandAngle(shooter, ConstantsShooter.ANGLE_SPEED_NEGATIVE);
  }

  private void configureJoysticks() {
    joystick = new Joystick(Constants.JOYSTICK);
  }

  public static SubsystemShooter subsShooter(){
    return shooter;
  }

}