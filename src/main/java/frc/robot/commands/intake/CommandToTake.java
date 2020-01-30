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

  private SubsystemIntake subsIntake;

  public CommandToTake(SubsystemIntake subsystemIntake) {
    this.subsIntake = subsystemIntake;
    addRequirements(subsIntake);
  }

  /* 
    * Obtém os valores LY e RX dos analógicos do controle de XBOX
    * e os implementa no método arcadeDrive do SubsystemDriver 
    */
 
  @Override
  public void execute() {
  }
  
  @Override
  public boolean isFinished(){
    return false;
  }
}