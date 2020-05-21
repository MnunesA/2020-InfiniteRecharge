/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllersTypes.simpleTypes;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.controllersTypes.simpleTypes.speedControllerGeneric;
import java.util.List;

public class SparkType extends SpeedControllerTypeSimple {

  public SparkType(List<Integer> leftID, List<Integer> rightID) {
      super();
    for (Integer ID : leftID) {
      leftControllers.add(new Spark(ID));
    }
    
    for (Integer ID : rightID) {
      rightControllers.add(new Spark(ID));
    }
  }
  
  public SparkType(List<Integer> controllersID) {
      super();
    for (Integer ID : controllersID) {
      controllers.add(new Spark(ID));
    }
  }
}