/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.pid.ConstantsDriver;

public class Driver extends SubsystemBase {

  private TalonSRX masterLeft = new TalonSRX(0);
  private TalonSRX slaveLeft = new TalonSRX(2);
  private TalonSRX masterRight = new TalonSRX(3);
  private TalonSRX slaveRight = new TalonSRX(1);

  //private ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  public void tankDriver(double spLeft, double spRight){
    masterLeft.set(ControlMode.PercentOutput, spLeft);
    masterRight.set(ControlMode.PercentOutput, spRight);
    slaveLeft.follow(masterLeft);
    slaveRight.follow(masterRight);
  }


  /**
   * Creates a new Driver.
   */
  public Driver() {
    
    masterLeft.setNeutralMode(NeutralMode.Brake);
    masterRight.setNeutralMode(NeutralMode.Brake);
    slaveRight.setNeutralMode(NeutralMode.Brake);
    slaveLeft.setNeutralMode(NeutralMode.Brake);
    reset();
    Driver();
  }

 /* public double getAngle(){
    return gyro.getAngle();
  }*/

 /* public void initGyro(){
    gyro.calibrate();
    gyro.reset();
  }*/

  public void reset(){
    masterRight.setSelectedSensorPosition(0, 0, 30);
    masterLeft.setSelectedSensorPosition(0, 0, 30);
  }

  public void setPosition(double position){
    masterLeft.set(ControlMode.Position, position);
    masterRight.set(ControlMode.Position, position);
    slaveLeft.follow(masterLeft);
    slaveRight.follow(masterRight);

  }

  public void Driver(){
    masterRight.configFactoryDefault();
      
    masterRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,ConstantsDriver.kPIDLoopIdx,ConstantsDriver.kTimeoutMs);
  
    masterRight.setSensorPhase(ConstantsDriver.kSensorPhase);
      masterRight.setInverted(ConstantsDriver.kMotorInvert);
  
      masterRight.configNominalOutputForward(0, ConstantsDriver.kTimeoutMs);
      masterRight.configNominalOutputReverse(0, ConstantsDriver.kTimeoutMs);
      masterRight.configPeakOutputForward(1, ConstantsDriver.kTimeoutMs);
      masterRight.configPeakOutputReverse(-1, ConstantsDriver.kTimeoutMs);
  
      masterRight.configAllowableClosedloopError(0, ConstantsDriver.kPIDLoopIdx, ConstantsDriver.kTimeoutMs);
  
      masterRight.config_kF(ConstantsDriver.kPIDLoopIdx, ConstantsDriver.kGains.kF, ConstantsDriver.kTimeoutMs);
      masterRight.config_kP(ConstantsDriver.kPIDLoopIdx, ConstantsDriver.kGains.kP, ConstantsDriver.kTimeoutMs);
      masterRight.config_kI(ConstantsDriver.kPIDLoopIdx, ConstantsDriver.kGains.kI, ConstantsDriver.kTimeoutMs);
      masterRight.config_kD(ConstantsDriver.kPIDLoopIdx, ConstantsDriver.kGains.kD, ConstantsDriver.kTimeoutMs);
  
      int absolutePosition = masterRight.getSensorCollection().getPulseWidthPosition();
  
      absolutePosition &= 0xFFF;
      if (ConstantsDriver.kSensorPhase) { absolutePosition *= -1; }
      if (ConstantsDriver.kMotorInvert) { absolutePosition *= -1; }
      
      masterRight.setSelectedSensorPosition(absolutePosition, ConstantsDriver.kPIDLoopIdx, ConstantsDriver.kTimeoutMs);
      }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
