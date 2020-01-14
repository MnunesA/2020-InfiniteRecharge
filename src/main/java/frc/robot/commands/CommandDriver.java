/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubsystemDriver;

public class CommandDriver extends CommandBase {

  private SubsystemDriver subsDriver;
  private double linearSpeed;
  private double rotationSpeed;

  public CommandDriver(SubsystemDriver subsystemD) {
    this.subsDriver = subsystemD;
    addRequirements(subsDriver);
  }

  @Override
  public void execute() {
    this.linearSpeed = RobotContainer.joystick().getY(RobotContainer.lHand());
    this.rotationSpeed = RobotContainer.joystick().getX(RobotContainer.rHand());
    RobotContainer.subsDriver().arcadeDrive(this.linearSpeed, this.rotationSpeed);
  }
  
  @Override
  public boolean isFinished(){
    return false;
  }
}