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
 private int CHAN_LEFT_A_ID;
 private int CHAN_LEFT_B_ID;
 private int CHAN_RIGHT_A_ID;
 private int CHAN_RIGHT_B_ID;
 private double MAX_PERIOD;
 private double MIN_RATE;
 private double DISTANCE_PER_PULSE;
 private double DEADB_VALUE;
 private boolean ENCODER_LEFT_INV;
 private boolean ENCODER_RIGHT_INV;

 private VictorSP motorLeftFront;
 private VictorSP motorLeftRear;
 private VictorSP motorRightFront;
 private VictorSP motorRightRear;
 
 private SpeedControllerGroup motorLeft;
 private SpeedControllerGroup motorRight;
 
 private DifferentialDrive drivetrain;
 
 private Encoder encoderLeft;
 private Encoder encoderRight;

public SubsystemDriver(int LEFTF_ID, int LEFTR_ID, int RIGHTF_ID, int RIGHTR_ID, int CHANNEL_LEFT_A_ID,
int CHANNEL_LEFT_B_ID, int CHANNEL_RIGHT_A_ID, int CHANNEL_RIGHT_B_ID, double ENCODER_MAX_PERIOD, double ENCODER_MIN_RATE, double ENCODER_DISTANCE_PER_PULSE, 
double DEADBAND_VALUE, boolean ENCODER_LEFT_INVERTED, boolean ENCODER_RIGHT_INVERTED) {
  
  this.LF_ID = LEFTF_ID;
  this.LR_ID = LEFTR_ID;
  this.RF_ID = RIGHTF_ID;
  this.RR_ID = RIGHTR_ID;
  this.CHAN_LEFT_A_ID = CHANNEL_LEFT_A_ID;
  this.CHAN_LEFT_B_ID = CHANNEL_LEFT_B_ID;
  this.CHAN_RIGHT_A_ID = CHANNEL_RIGHT_A_ID;
  this.CHAN_RIGHT_B_ID = CHANNEL_RIGHT_B_ID;
  this.MAX_PERIOD = ENCODER_MAX_PERIOD;
  this.MIN_RATE = ENCODER_MIN_RATE;
  this.DISTANCE_PER_PULSE = ENCODER_DISTANCE_PER_PULSE;
  this.DEADB_VALUE = DEADBAND_VALUE;
  this.ENCODER_LEFT_INV = ENCODER_LEFT_INVERTED;
  this.ENCODER_RIGHT_INV = ENCODER_RIGHT_INVERTED;
  
  this.motorLeftFront = new VictorSP(LF_ID);
  this.motorLeftRear = new VictorSP(LR_ID);
  this.motorRightFront = new VictorSP(RF_ID);
  this.motorRightRear = new VictorSP(RR_ID);
  
  this.motorLeft = new SpeedControllerGroup(motorLeftFront, motorLeftRear);
  this.motorRight = new SpeedControllerGroup(motorRightFront, motorRightRear);
  
  this.drivetrain = new DifferentialDrive(motorLeft, motorRight);
  this.drivetrain.setDeadband(DEADB_VALUE);
  
  this.encoderLeft = new Encoder(CHAN_LEFT_A_ID, CHAN_LEFT_B_ID, ENCODER_LEFT_INV, Encoder.EncodingType.k2X);
  this.encoderLeft.setMaxPeriod(MAX_PERIOD);
  this.encoderLeft.setMinRate(MIN_RATE);                                                
  this.encoderLeft.setDistancePerPulse(DISTANCE_PER_PULSE);

  this.encoderRight = new Encoder(CHAN_RIGHT_A_ID, CHAN_RIGHT_B_ID, ENCODER_RIGHT_INV, Encoder.EncodingType.k2X);
  this.encoderRight.setMaxPeriod(MAX_PERIOD);
  this.encoderRight.setMinRate(MIN_RATE);                                                
  this.encoderRight.setDistancePerPulse(DISTANCE_PER_PULSE);
 }

public void arcadeDrive(double linearSpeed, double rotationSpeed) {
  this.drivetrain.arcadeDrive(linearSpeed, rotationSpeed);
  this.axis_LY = linearSpeed;
  this.axis_RX = rotationSpeed;
 }

public int getPulsesEncoderLeft(){
  return this.encoderLeft.get();
 }
 
public double getDistanceEncoderLeft() {
  return this.encoderLeft.getDistance();
 }
 
public int getIndexEncoderLeft() {
  return this.encoderLeft.getFPGAIndex();
 }

public void resetEncoderLeft() {
  this.encoderLeft.reset();
 }
 
 public int getPulsesEncoderRight(){
  return this.encoderRight.get();
 }
 
public double getDistanceEncoderRight() {
  return this.encoderRight.getDistance();
 }
 
public int getIndexEncoderRight() {
  return this.encoderRight.getFPGAIndex();
 }

public void resetEncoderRight() {
  this.encoderRight.reset();
 }
 
 @Override
 public void periodic() {
   SmartDashboard.putNumber("LY Axis", this.axis_LY);
   SmartDashboard.putNumber("RX Axis", this.axis_RX);
   SmartDashboard.putNumber("Pulses Encoder Left", getPulsesEncoderLeft());
   SmartDashboard.putNumber("Distance Walked Left", getDistanceEncoderLeft());
   SmartDashboard.putNumber("Index Value Left", getIndexEncoderLeft());
   SmartDashboard.putNumber("Pulses Encoder Right", getPulsesEncoderRight());
   SmartDashboard.putNumber("Distance Walked Right", getDistanceEncoderRight());
   SmartDashboard.putNumber("Index Value Right", getIndexEncoderRight());
 }

}