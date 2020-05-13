/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class SubsystemClimber extends SubsystemBase {

  protected SpeedControllerGroup motorsClimber;

  public SubsystemClimber() {
  }

  public void setSpeedClimber(double speed) {
    motorsClimber.set(speed);
  }

  public void getSpeedClimber() {
    motorsClimber.get();
  }

  @Override
  public void periodic() {
  }
}
