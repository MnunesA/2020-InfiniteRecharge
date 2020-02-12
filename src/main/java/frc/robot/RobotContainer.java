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
import frc.robot.commands.Auto;
import frc.robot.commands.Autonomous;
import frc.robot.commands.DriverTarget;
import frc.robot.commands.TankDriver;
import frc.robot.subsystems.Driver;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final double sp = 0;
  private final Driver driver = new Driver();
  
  private final Auto auto_ = new Auto(driver);
  private final TankDriver tankD = new TankDriver(driver);
  private final DriverTarget target = new DriverTarget(driver, 0);
  private final Autonomous auto = new Autonomous(driver);
    
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();
   driver.setDefaultCommand(tankD); 
  }

  public double axisLY(){
    return this.axisLY();
  }

  public double axisRX(){
    return axisRX();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   XboxController xbox = new XboxController(0);
    Joystick manche = new Joystick(1);

    JoystickButton d_a = new JoystickButton(xbox, 1);
    JoystickButton d_b = new JoystickButton(xbox, 2);
    JoystickButton d_x = new JoystickButton(xbox, 3);

    double axis_LY = xbox.getRawAxis(1);
    double axis_RX = xbox.getRawAxis(2);

    d_a.whenHeld(new DriverTarget(driver, 5000));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return auto;
  }
}
