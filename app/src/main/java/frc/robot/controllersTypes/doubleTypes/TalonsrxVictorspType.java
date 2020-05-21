/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllersTypes.doubleTypes;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.controllersTypes.doubleTypes.speedControllerGeneric;

import java.util.List;

public class TalonsrxVictorspType extends SpeedControllerTypeDouble {

  public TalonsrxVictorspType(List<Integer> talonsID, List<Integer> victorsID) {
      super();
    for (Integer ID : talonsID) {
      controllersFirstType.add(new WPI_TalonSRX(ID));
    }

    for (Integer ID : victorsID) {
      controllersSecondType.add(new VictorSP(ID));
    }
  }
}
