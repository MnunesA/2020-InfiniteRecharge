/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllersTypes.simpleTypes;

import edu.wpi.first.wpilibj.VictorSP;
import frc.robot.controllersTypes.simpleTypes.speedControllerGeneric;
import java.util.List;

public class VictorSPType extends SpeedControllerTypeSimple {

  public VictorSPType(List<Integer> leftID, List<Integer> rightID) {
      super();
    for (Integer ID : leftID) {
      leftControllers.add(new VictorSP(ID));
    }
    
    for (Integer ID : rightID) {
      rightControllers.add(new VictorSP(ID));
    }
  }
  
  public VictorSPType(List<Integer> controllersID) {
      super();
    for (Integer ID : controllersID) {
      controllers.add(new VictorSP(ID));
    }
  }
}