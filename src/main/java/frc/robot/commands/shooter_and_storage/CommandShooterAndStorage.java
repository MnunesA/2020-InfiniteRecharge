/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.shooter_and_storage;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SubsystemShooter;
import frc.robot.subsystems.SubsystemStorage;

public class CommandShooterAndStorage extends CommandBase {

private SubsystemShooter subsShooter;
private SubsystemStorage subsStorage;
private double shooterSpeed;
private double storageSpeed;
private Timer timer;

  public CommandShooterAndStorage(SubsystemShooter subsystemShooter, SubsystemStorage subsystemStorage, double speedStorage, double speedShooter) {
    this.subsShooter = subsystemShooter;
    this.subsStorage = subsystemStorage;
    this.shooterSpeed = shooterSpeed;
    this.storageSpeed = storageSpeed;
    addRequirements(subsShooter, subsStorage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.timer = new Timer();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.subsShooter().setSpeedShooter(this.shooterSpeed);
    RobotContainer.subsStorage().setSpeedStorage(this.storageSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.timer.get() > 2.5;
  }
}