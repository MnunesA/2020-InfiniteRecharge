/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystem.driver;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SubsystemDriverTalonSRX extends SubsystemDriver {

  private WPI_TalonSRX motorLeftFront, motorLeftRear, motorRightFront, motorRightRear;

  public SubsystemDriverTalonSRX(
      int LF_ID,
      int LR_ID,
      int RF_ID,
      int RR_ID,
      double DEADB_VALUE,
      boolean thereIsEncoder) {
    super(thereIsEncoder);

    motorLeftFront = new WPI_TalonSRX(LF_ID);
    motorLeftRear = new WPI_TalonSRX(LR_ID);
    motorRightFront = new WPI_TalonSRX(RF_ID);
    motorRightRear = new WPI_TalonSRX(RR_ID);

    motorLeft = new SpeedControllerGroup(motorLeftFront, motorLeftRear);
    motorRight = new SpeedControllerGroup(motorRightFront, motorRightRear);

    drivetrain = new DifferentialDrive(motorLeft, motorRight);
    drivetrain.setDeadband(DEADB_VALUE);
  }
}
