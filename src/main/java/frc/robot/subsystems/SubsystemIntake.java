/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ConstantsIntake;


public class SubsystemIntake extends SubsystemBase {

  VictorSP motorAngulation;
  VictorSP motorToTake;

  DigitalInput limitSwitchUp;
  DigitalInput limitSwitchDown; 

  int MOTOR_ANG_ID;
  int MOTOR_TT_ID;
  int LS_UP_ID;
  int LS_DOWN_ID;

public SubsystemIntake(int MOTOR_ANGULATION_ID, int MOTOR_TO_TAKE_ID, int LIMITSWITCH_UP_ID,
int LIMITSWITCH_DOWN_ID) {
  
  MOTOR_ANG_ID = MOTOR_ANGULATION_ID;
  MOTOR_TT_ID = MOTOR_TO_TAKE_ID;
  LS_UP_ID = LIMITSWITCH_UP_ID;
  LS_DOWN_ID = LIMITSWITCH_DOWN_ID;
  
  motorAngulation = new VictorSP(MOTOR_ANG_ID);
  motorToTake = new VictorSP(MOTOR_TT_ID);

  limitSwitchUp = new DigitalInput(LS_UP_ID);
  limitSwitchDown = new DigitalInput(LS_DOWN_ID); 
 }

  public void setSpeedAngulation(double speed) {
    motorAngulation.set(speed);
  }
  
  public void setSpeedToTake(double speed) {
    motorToTake.set(speed);
  }

  public boolean getLSUp() {
    return limitSwitchUp.get();
  }

  public boolean getLSDown() {
    return limitSwitchDown.get();
  }

 @Override
 public void periodic() {
   SmartDashboard.putBoolean("Limit Switch Up", getLSUp());
   SmartDashboard.putBoolean("Limit Switch Down", getLSDown());
 }

}