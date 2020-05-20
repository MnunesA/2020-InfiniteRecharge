/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.driver;

import edu.wpi.first.wpilibj.VictorSP;
import java.util.ArrayList;
import java.util.List;
import static frc.robot.ConstantsDriver.*;
import edu.wpi.first.wpilibj.SpeedController;

public class SubsystemDriverVictorSP implements SpeedControllerType {

  private List<VictorSP> leftControllers;
  private List<VictorSP> rightControllers;

  public SubsystemDriverVictorSP(
      List<Integer> leftID, List<Integer> rightID) {

    leftControllers = new ArrayList<VictorSP>();
    rightControllers = new ArrayList<VictorSP>();

    for (Integer ID : leftID) {
      leftControllers.add(new VictorSP(ID));
    }
    
    for (Integer ID : rightID) {
      leftControllers.add(new VictorSP(ID));
    }
    
  @Override
  public List<SpeedController> getLeftControllers() {
    return leftControllers;
  }
  
  @Override
  public List<SpeedController> getRightControllers() {
    return rightControllers;
  }
}
