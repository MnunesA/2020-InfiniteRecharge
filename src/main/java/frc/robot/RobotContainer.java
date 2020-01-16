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
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.shooter.CommandShooter;
import frc.robot.commands.shooter.CommandAngle;
import frc.robot.subsystems.SubsystemShooter;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

private static SubsystemShooter shooter;
private static CommandShooter cshooter;
private static CommandAngle angle;
private static Joystick joystick;
private static JoystickButton J_Fire;
private static JoystickButton J_Thumb;

  public RobotContainer() {

    shooter = new SubsystemShooter(Constants.SHOOTER_ID, Constants.ANGLE_ID);

    cshooter = new CommandShooter(shooter);

    angle = new CommandAngle(shooter);

    joystick = new Joystick(Constants.JOYSTICK);

    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    J_Fire = new JoystickButton(joystick, Constants.J_FIRE);
    J_Thumb = new JoystickButton(joystick, Constants.J_THUMB);

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

   public static SubsystemShooter subsShooter(){
     return shooter;
   }

   public static CommandShooter commShooter(){
     return cshooter;
   }

   public static CommandAngle commAngle(){
    return angle;
   }

   public static JoystickButton J_Fire(){
     return J_Fire;
   }

   public static JoystickButton J_Thumb(){
     return J_Thumb;
   }

}
