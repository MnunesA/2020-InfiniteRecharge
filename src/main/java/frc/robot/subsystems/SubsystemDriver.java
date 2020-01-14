/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class SubsystemDriver extends SubsystemBase {

 private double axis_LY;
 private double axis_RX;
 private int LF_ID;
 private int LR_ID;
 private int RF_ID;
 private int RR_ID;
 private int CHANNEL_A_ID;
 private int CHANNEL_B_ID;
 private double MAX_PERIOD;
 private double MIN_RATE;
 private double DISTANCE_PER_PULSE;

 private VictorSP motorLeftFront;
 private VictorSP motorLeftRear;
 private VictorSP motorRightFront;
 private VictorSP motorRightRear;
 
 private SpeedControllerGroup motorLeft;
 private SpeedControllerGroup motorRight;
 
 private DifferentialDrive drivetrain;
 
 private Encoder encoder; 

public SubsystemDriver(int LEFTF_ID, int LEFTR_ID, int RIGHTF_ID, int RIGHTR_ID, int CHAN_A_ID, int CHAN_B_ID, double ENCODER_MAX_PERIOD, double ENCODER_MIN_RATE, double ENCODER_DISTANCE_PER_PULSE) {
  
  this.LF_ID = LEFTF_ID;
  this.LR_ID = LEFTR_ID;
  this.RF_ID = RIGHTF_ID;
  this.RR_ID = RIGHTR_ID;
  this.CHANNEL_A_ID = CHAN_A_ID;
  this.CHANNEL_B_ID = CHAN_B_ID;
  this.MAX_PERIOD = ENCODER_MAX_PERIOD;
  this.MIN_RATE = ENCODER_MIN_RATE;
  this.DISTANCE_PER_PULSE = ENCODER_DISTANCE_PER_PULSE;
  
  this.motorLeftFront = new VictorSP(LF_ID);
  this.motorLeftRear = new VictorSP(LR_ID);
  this.motorRightFront = new VictorSP(RF_ID);
  this.motorRightRear = new VictorSP(RR_ID);
  
  this.motorLeft = new SpeedControllerGroup(motorLeftFront, motorLeftRear);
  this.motorRight = new SpeedControllerGroup(motorRightFront, motorRightRear);
  
  this.drivetrain = new DifferentialDrive(motorLeft, motorRight);
  this.drivetrain.setDeadband(0.04);
  
  this.encoder = new Encoder(CHANNEL_A_ID, CHANNEL_B_ID, false, Encoder.EncodingType.k2X);
  this.encoder.setMaxPeriod(MAX_PERIOD);
  this.encoder.setMinRate(MIN_RATE);                                                
  this.encoder.setDistancePerPulse(DISTANCE_PER_PULSE);
 }

public void arcadeDrive(double linearSpeed, double rotationSpeed) {
  this.drivetrain.arcadeDrive(linearSpeed, rotationSpeed);
  this.axis_LY = linearSpeed;
  this.axis_RX = rotationSpeed;
 }

public int getPulsesEncoder(){
  return this.encoder.get();
 }
 
public double getDistance() {
  return this.encoder.getDistance();
 }
 
public int getFPGAIndex() {
  return this.encoder.getFPGAIndex();
 }

public void reset() {
  this.encoder.reset();
 }
 
 @Override
 public void periodic() {
   SmartDashboard.putNumber("LY_Axis", this.axis_LY);
   SmartDashboard.putNumber("LY_Axis", this.axis_RX);
   SmartDashboard.putNumber("Pulses_Encoder", getPulsesEncoder());
   SmartDashboard.putNumber("Distance Walked", getDistance());
   SmartDashboard.putNumber("Index Value", getFPGAIndex());
 }

}