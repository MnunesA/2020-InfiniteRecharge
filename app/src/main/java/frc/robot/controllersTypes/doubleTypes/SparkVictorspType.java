/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllersTypes.doubleTypes;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.controllersTypes.doubleTypes.speedControllerGeneric;

import java.util.List;

public class SparkVictorspType extends SpeedControllerTypeDouble {

  public SparkVictorspType(List<Integer> sparksID, List<Integer> victorsID) {
      super();
    for (Integer ID : sparksID) {
      controllersFirstType.add(new Spark(ID));
    }

    for (Integer ID : victorsID) {
      controllersSecondType.add(new VictorSP(ID));
    }
  }
}
