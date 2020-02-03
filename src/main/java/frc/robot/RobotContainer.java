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
import frc.robot.commands.DriverTest;
import frc.robot.commands.PIDTest;
import frc.robot.commands.ShooterMove;
import frc.robot.commands.ShooterTest;
import frc.robot.subsystems.Driver;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final double sp = 0;
  // The robot's subsystems and commands are defined here...
  private final Driver driver = new Driver();
  private final Shooter shooter = new Shooter();
  
  private final PIDTest testPID = new PIDTest (driver);
  private final ShooterMove withPID = new ShooterMove(shooter, sp);
  private final ShooterTest withoutPID = new ShooterTest(shooter);
  private final DriverTest driverT = new DriverTest(driver);


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Joystick x_box = new Joystick(0);
    Joystick manche = new Joystick(1);

    JoystickButton d_a = new JoystickButton(x_box, 1);
    JoystickButton d_b = new JoystickButton(x_box, 2);
    JoystickButton d_x = new JoystickButton(x_box, 3);

   // d_a.whenPressed(new ShooterMove(shooter, 500));
    d_b.whenPressed(new ShooterTest(shooter));
    d_x.whenPressed(new PIDTest(driver));
    d_a.whenPressed(new DriverTest(driver));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return testPID;
  }
}
