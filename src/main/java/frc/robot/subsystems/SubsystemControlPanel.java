/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubsystemControlPanel extends SubsystemBase {
  
  private VictorSP motorControlPanel;

  public SubsystemControlPanel(int MOTOR_CONTROL_PANEL_ID) {
    motorControlPanel = new VictorSP(MOTOR_CONTROL_PANEL_ID);
  }

  public void setSpeed(double speed) {
    motorControlPanel.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
