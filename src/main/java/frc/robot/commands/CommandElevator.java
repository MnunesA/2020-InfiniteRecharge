/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ConstantsClimber;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubsystemElevator;

public class CommandElevator extends CommandBase {

  private SubsystemElevator subsElevator;
  private double SPEED;

  public CommandElevator(SubsystemElevator subsElevator, double SPEED) {
    this.subsElevator = subsElevator;
    this.SPEED = SPEED;
    addRequirements(this.subsElevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsElevator.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(RobotContainer.getPOV()) {
      case 0:
      subsElevator.setSpeedElevator(SPEED);
      break;
      case 180:
      subsElevator.setSpeedElevator(-SPEED);
      break;
      default:
      subsElevator.setSpeedElevator(0.0);
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsElevator.setSpeedElevator(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs((double)subsElevator.getEncoder()) > ConstantsClimber.ENCODER_ELEVATOR_MAX;
  }
}
