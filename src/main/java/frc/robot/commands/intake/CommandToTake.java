/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubsystemIntake;

public class CommandToTake extends CommandBase {

  private double speed;
  private double LIM_SPEED;

  private SubsystemIntake subsIntake;

  public CommandToTake(SubsystemIntake subsystemIntake, double LIMITER_SPEED) {
    this.subsIntake = subsystemIntake;
    this.LIM_SPEED = LIMITER_SPEED;
    addRequirements(subsIntake);
  }

  @Override
  public void execute() {
    speed = RobotContainer.axis_cancel() * LIM_SPEED;
    subsIntake.setSpeedToTake(speed);
  }
  
  @Override
  public boolean isFinished(){
    return false;
  }
}