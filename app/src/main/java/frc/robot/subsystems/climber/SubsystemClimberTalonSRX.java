/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SubsystemClimberTalonSRX extends SubsystemClimber {

  private WPI_TalonSRX motorClimber_1, motorClimber_2;

  public SubsystemDriverTalonSRX(int MC1_ID, int MC2_ID) {

    motorClimber_1 = new WPI_TalonSRX(MC1_ID);
    motorClimber_2 = new WPI_TalonSRX(MC2_ID);

    this.motorsClimber = new SpeedControllerGroup(motorClimber_1, motorClimber_2);
  }
}
