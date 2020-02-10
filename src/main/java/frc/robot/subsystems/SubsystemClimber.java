/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubsystemClimber extends SubsystemBase {
  
  int MOTOR_ELE_1_ID;
  int MOTOR_ELE_2_ID;
  int MOTOR_C_1_ID;
  int MOTOR_C_2_ID;

  VictorSP motorClimber_1;
  VictorSP motorClimber_2;
  VictorSP motorElevator_1;
  VictorSP motorElevator_2;

  SpeedControllerGroup motorsElevator;
  SpeedControllerGroup motorsClimber;


  public SubsystemClimber(int MOTOR_ELE_1_ID, int MOTOR_ELE_2_ID, int MOTOR_CLIMBER_1_ID, int MOTOR_CLIMBER_2_ID) {
    this.MOTOR_ELE_1_ID = MOTOR_ELE_1_ID;
    this.MOTOR_ELE_2_ID = MOTOR_ELE_2_ID;
    this.MOTOR_C_1_ID = MOTOR_CLIMBER_1_ID;
    this.MOTOR_C_2_ID = MOTOR_CLIMBER_2_ID;

    motorElevator_1 = new VictorSP(MOTOR_ELE_1_ID);
    motorElevator_2 = new VictorSP(MOTOR_ELE_2_ID);
    motorClimber_1 = new VictorSP(MOTOR_C_1_ID);
    motorClimber_2 = new VictorSP(MOTOR_C_2_ID);

    motorsElevator = new SpeedControllerGroup(motorElevator_1, motorElevator_2);
    motorsClimber = new SpeedControllerGroup(motorClimber_1, motorClimber_2);
  }

  public void setSpeedClimber(double speed) {
    motorsClimber.set(speed);
  }

  public void setSpeedElevator(double speed) {
    motorsElevator.set(speed);
  }

  public void getSpeedClimber() {
    motorsClimber.get();
  }

  public void getSpeedElevator() {
    motorsElevator.get();
  }

  @Override
  public void periodic() {
  }
}
