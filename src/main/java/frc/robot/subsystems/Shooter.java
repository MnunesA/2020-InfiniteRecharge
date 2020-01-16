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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.pid.constants;


public class Shooter extends SubsystemBase {
  
  private final TalonSRX shooterAngle = new TalonSRX(0);

  public Shooter() {
	  shooterInit();
	  shooterAngle.setNeutralMode(NeutralMode.Brake);
	  resetEncoder();
  }

  public void moveToPosition(double distance){
	  shooterAngle.set(ControlMode.Position, distance);
  }

  public void shooterButton(double sp){
	  shooterAngle.set(ControlMode.PercentOutput, sp);
  }
  
  public void resetEncoder(){
	  shooterAngle.setSelectedSensorPosition(0, 0, 30);
  }

  public void shooterInit(){
	shooterAngle.configFactoryDefault();
		
    shooterAngle.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, frc.robot.pid.constants.kPIDLoopIdx,constants.kTimeoutMs);

	shooterAngle.setSensorPhase(constants.kSensorPhase);
    shooterAngle.setInverted(constants.kMotorInvert);

		shooterAngle.configNominalOutputForward(0, constants.kTimeoutMs);
		shooterAngle.configNominalOutputReverse(0, constants.kTimeoutMs);
		shooterAngle.configPeakOutputForward(1, constants.kTimeoutMs);
		shooterAngle.configPeakOutputReverse(-1, constants.kTimeoutMs);

		shooterAngle.configAllowableClosedloopError(0, constants.kPIDLoopIdx, constants.kTimeoutMs);

		shooterAngle.config_kF(constants.kPIDLoopIdx, constants.kGains.kF, constants.kTimeoutMs);
		shooterAngle.config_kP(constants.kPIDLoopIdx, constants.kGains.kP, constants.kTimeoutMs);
		shooterAngle.config_kI(constants.kPIDLoopIdx, constants.kGains.kI, constants.kTimeoutMs);
		shooterAngle.config_kD(constants.kPIDLoopIdx, constants.kGains.kD, constants.kTimeoutMs);

		int absolutePosition = shooterAngle.getSensorCollection().getPulseWidthPosition();

		absolutePosition &= 0xFFF;
		if (constants.kSensorPhase) { absolutePosition *= -1; }
		if (constants.kMotorInvert) { absolutePosition *= -1; }
		
		shooterAngle.setSelectedSensorPosition(absolutePosition, constants.kPIDLoopIdx, constants.kTimeoutMs);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
