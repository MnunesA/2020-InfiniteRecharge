/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.controllersTypes.doubleTypes.speedControllerGeneric;

import edu.wpi.first.wpilibj.SpeedController;
import java.util.List;
import java.util.ArrayList;

public abstract class SpeedControllerTypeDouble {

  private List<SpeedController> controllersFirstType;
  private List<SpeedController> controllersSecondType;
  
  public SpeedControllerTypeDouble() {
  
    controllersFirstType = new ArrayList<SpeedController>();
    controllersSecondType = new ArrayList<SpeedController>();
  }

  public List<SpeedController> getControllersFirstType() {
    return controllersFirstType;
  }

  public List<SpeedController> getControllersSecondType() {
    return controllersSecondType;
  }
}
