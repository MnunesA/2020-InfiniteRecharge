/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.ConstantsClimber.ENCODER_ELEVATOR_A;
import static frc.robot.ConstantsClimber.ENCODER_ELEVATOR_B;
import static frc.robot.ConstantsClimber.ENCODER_ELEVATOR_INVERTED;

public abstract class SubsystemElevator extends SubsystemBase {

  protected Encoder encoderElevator;

  protected SpeedControllerGroup motorsElevator;

  public SubsystemElevator(boolean thereIsEncoder) {
  
  if (thereIsEncoder == true) {

    encoderElevator = new Encoder(ENCODER_ELEVATOR_A, ENCODER_ELEVATOR_B, ENCODER_ELEVATOR_INVERTED, Encoder.EncodingType.k2X);
    }
  }

  public void setSpeedElevator(double speed) {
    motorsElevator.set(speed);
  }

  public void getSpeedElevator() {
    motorsElevator.get();
  }

  public int getEncoder(){
    return encoderElevator.get();
  }

  public void resetEncoder(){
    encoderElevator.reset();
  }

  @Override
  public void periodic() {
  }
}
