/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllersTypes.simpleTypes;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.controllersTypes.simpleTypes.speedControllerGeneric;
import java.util.List;

public class TalonsrxType extends SpeedControllerTypeSimple {

  public TalonsrxType(List<Integer> leftID, List<Integer> rightID) {
      super();
    for (Integer ID : leftID) {
      leftControllers.add(new WPI_TalonSRX(ID));
    }
    
    for (Integer ID : rightID) {
      rightControllers.add(new WPI_TalonSRX(ID));
    }
    
  public TalonsrxType(List<Integer> controllersID) {
      super();
    for (Integer ID : controllersID) {
      controllers.add(new WPI_TalonSRX(ID));
    }
}