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
import frc.robot.subsystems.SubsystemStorage;

public class CommandToTake extends CommandBase {

  private double speedStorage;
  private double speedIntake;
  private double LIM_SPEED;

  private SubsystemIntake subsIntake;
  private SubsystemStorage subsStorage;

  public CommandToTake(SubsystemIntake subsystemIntake, SubsystemStorage subsystemStorage, double LIMITER_SPEED) {
    this.subsIntake = subsystemIntake;
    this.subsStorage = subsystemStorage;
    this.LIM_SPEED = LIMITER_SPEED;
    addRequirements(subsIntake, subsStorage);
  }

  @Override
  public void execute() {
    speedIntake = RobotContainer.axis_sum() * LIM_SPEED;
    speedStorage = RobotContainer.axis_sum() * LIM_SPEED;
    subsIntake.setSpeedToTake(speedIntake);
    subsStorage.setSpeedStorage(speedStorage);
  }
  
  @Override
  public boolean isFinished(){
    return false;
  }
}