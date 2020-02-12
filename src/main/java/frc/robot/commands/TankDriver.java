/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Driver;

public class TankDriver extends CommandBase {

  Driver m_driver;
  RobotContainer robot_;
  
	double arcadeSpeed;
	double arcadeRotation;

	public static final double minR = 0.4D, difR = 0.5D;

  /**
   * Creates a new Driver.
   */
  public TankDriver(Driver driver) {
    robot_ = new RobotContainer();
    m_driver = driver;
    addRequirements(m_driver);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   // m_driver.initGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.arcadeRotation = robot_.axisLY();
    this.arcadeSpeed = robot_.axisRX();
    arcadeDrive(this.arcadeRotation, this.arcadeSpeed);

    //SmartDashboard.putNumber("getAngle", m_driver.getAngle());

  }

  public void arcadeDrive(double speed, double rotation) {
		double modifier = minR + difR * Math.pow(1 - Math.abs(speed), 2);
		double rate = Math.pow(rotation, 3) * modifier;
		m_driver.tankDriver(-(speed + rate), rate - speed);
	}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
