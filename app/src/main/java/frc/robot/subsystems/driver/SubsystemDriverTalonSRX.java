/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.driver;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.ConstantsDriver.*;

public class SubsystemDriverTalonSRX extends SubsystemDriver {

  public SubsystemDriverTalonSRX(
      WPI_TalonSRX[] leftControllers,
      WPI_TalonSRX[] rightControllers,
      double DEADB_VALUE,
      boolean thereIsEncoder) {
    super(thereIsEncoder);

    for (int i = 0; i < leftControllers.length; i++) {
      leftControllers[FIRST_CONTROLLER_OF_THE_LEFT_ID + i] =
          new WPI_TalonSRX(FIRST_CONTROLLER_OF_THE_LEFT_ID + i);
    }

    for (int i = 0; i < rightControllers.length; i++) {
      rightControllers[FIRST_CONTROLLER_OF_THE_RIGHT_ID + i] =
          new WPI_TalonSRX(FIRST_CONTROLLER_OF_THE_RIGHT_ID + i);
    }

    motorsLeft = new SpeedControllerGroup(leftControllers);
    motorsRight = new SpeedControllerGroup(rightControllers);

    drivetrain = new DifferentialDrive(motorsLeft, motorsRight);
    drivetrain.setDeadband(DEADB_VALUE);
  }
}
