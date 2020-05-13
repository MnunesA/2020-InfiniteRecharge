/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.VictorSP;

public class SubsystemElevatorVictorSP extends SubsystemElevator {

  private VictorSP motorElevator_1, motorElevator_2;

  public SubsystemElevatorVictorSP(int ME1_ID, int ME2_ID, boolean thereIsEncoder) {
    super(thereIsEncoder);

    motorElevator_1 = new VictorSP(ME1_ID);
    motorElevator_2 = new VictorSP(ME2_ID);

    this.motorsElevator = new SpeedControllerGroup(motorElevator_1, motorElevator_2);
  }
}
