/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.driver;

import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.ConstantsDriver.LINEAR_SPEED;
import static frc.robot.ConstantsDriver.ROTATION_SPEED;
import frc.robot.subsystems.SubsystemDriver;

public class CommandDriver extends CommandBase {

  private SubsystemDriver subsDriver;
  private double linearSpeed;
  private double rotationSpeed;

  public CommandDriver(SubsystemDriver subsystemD) {
    this.subsDriver = subsystemD;
    addRequirements(subsDriver);
  }

  /* 
    * Obtém os valores LY e RX dos analógicos do controle de XBOX
    * e os implementa no método arcadeDrive do SubsystemDriver 
    */
 
  @Override
  public void execute() {
    this.linearSpeed = LINEAR_SPEED;
    this.rotationSpeed = ROTATION_SPEED;
    this.subsDriver.arcadeDrive(this.linearSpeed, this.rotationSpeed);
  }
  
  @Override
  public boolean isFinished(){
    return false;
  }
}