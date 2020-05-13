/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SubsystemElevatorTalonSRX extends SubsystemElevator {

  private WPI_TalonSRX motorElevator_1, motorElevator_2;

  public SubsystemElevatorTalonSRX(int ME1_ID, int ME2_ID, boolean thereIsEncoder) {
    super(thereIsEncoder);

    motorElevator_1 = new WPI_TalonSRX(ME1_ID);
    motorElevator_2 = new WPI_TalonSRX(ME2_ID);

    this.motorsElevator = new SpeedControllerGroup(motorElevator_1, motorElevator_2);
  }
}
