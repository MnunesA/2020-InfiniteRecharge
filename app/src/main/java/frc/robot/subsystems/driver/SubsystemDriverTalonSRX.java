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

  private List<WPI_TalonSRX> leftControllers;
  private List<WPI_TalonSRX> rightControllers;

  public SubsystemDriverTalonSRX(
      List<Integer> leftID, List<Integer> rightID, double DEADB_VALUE, boolean thereIsEncoder) {
    super(thereIsEncoder);

    leftControllers = new ArrayList<WPI_TalonSRX>();
    rightControllers = new ArrayList<WPI_TalonSRX>();

    for (Integer ID : leftID) {
      leftControllers.add(new WPI_TalonSRX(ID));
    }
    
    for (Integer ID : rightID) {
      rightControllers.add(new WPI_TalonSRX(ID));
    }
    
    motorsLeft = new SpeedControllerGroup(leftControllers);
    motorsRight = new SpeedControllerGroup(rightControllers);

    drivetrain = new DifferentialDrive(motorsLeft, motorsRight);
    drivetrain.setDeadband(DEADB_VALUE);
  }
}