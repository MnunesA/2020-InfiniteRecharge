/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.driver;

import edu.wpi.first.wpilibj.VictorSP;
import static frc.robot.ConstantsDriver.*;

public class SubsystemDriverVictorSP extends SubsystemDriver {

  public SubsystemDriverVictorSP(
      VictorSP[] leftControllers,
      VictorSP[] rightControllers,
      double DEADB_VALUE,
      boolean thereIsEncoder) {
    super(thereIsEncoder);

    for (int i = 0; i < leftControllers.length; i++) {
      leftControllers[FIRST_CONTROLLER_OF_THE_LEFT_ID + i] =
          new VictorSP(FIRST_CONTROLLER_OF_THE_LEFT_ID + i);
    }

    for (int i = 0; i < rightControllers.length; i++) {
      rightControllers[FIRST_CONTROLLER_OF_THE_RIGHT_ID + i] =
          new VictorSP(FIRST_CONTROLLER_OF_THE_RIGHT_ID + i);
    }

    motorsLeft = new SpeedControllerGroup(leftControllers);
    motorsRight = new SpeedControllerGroup(rightControllers);

    drivetrain = new DifferentialDrive(motorsLeft, motorsRight);
    drivetrain.setDeadband(DEADB_VALUE);
  }
}
