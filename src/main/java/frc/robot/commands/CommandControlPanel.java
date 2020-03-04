/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SubsystemControlPanel;

public class CommandControlPanel extends CommandBase {

  private SubsystemControlPanel subsystemControlPanel;
  private double SPEED;
  private double TIME;
  private Timer timer;

  public CommandControlPanel(SubsystemControlPanel subsystemControlPanel, double SPEED, double TIME) {
    this.subsystemControlPanel = subsystemControlPanel;
    timer = new Timer();
    this.SPEED = SPEED;
    this.TIME = TIME;
    addRequirements(subsystemControlPanel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    timer.start();
    subsystemControlPanel.setSpeed(SPEED);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    subsystemControlPanel.setSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() > TIME;
  }
}
