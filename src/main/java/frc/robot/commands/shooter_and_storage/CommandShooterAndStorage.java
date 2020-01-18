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
private double SHOOTER_SPEED;
private double STORAGE_SPEED;
private Timer timer;
private double TIMER_DURATION;

  public CommandShooterAndStorage(SubsystemShooter subsystemShooter, SubsystemStorage subsystemStorage, double STORAGE_SPEED, double SHOOTER_SPEED, double TIMER) {
    this.subsShooter = subsystemShooter;
    this.subsStorage = subsystemStorage;
    this.SHOOTER_SPEED = SHOOTER_SPEED;
    this.STORAGE_SPEED = STORAGE_SPEED;
    this.TIMER_DURATION = TIMER;
    this.timer = new Timer();
    addRequirements(subsShooter, subsStorage);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.subsShooter.setSpeedShooter(this.SHOOTER_SPEED);
    this.subsStorage.setSpeedStorage(this.STORAGE_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.timer.stop();
    this.timer.reset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.timer.get() >= TIMER_DURATION;
  }
}