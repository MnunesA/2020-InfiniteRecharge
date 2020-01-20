/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubsystemShooter extends SubsystemBase {

  private double shooterSpeed;
  private double angleSpeed;
  private int SHOOTER_ID;
  private int ANGLE_ID;

  private VictorSP motorShooter;

  private TalonSRX motorAngle;

  public SubsystemShooter(int MOTOR_SHOOTER_ID, int MOTOR_ANGLE_ID) {

    this.SHOOTER_ID = MOTOR_SHOOTER_ID;
    this.ANGLE_ID = MOTOR_ANGLE_ID;

    this.motorShooter = new VictorSP(SHOOTER_ID);

    this.motorAngle = new TalonSRX(ANGLE_ID);
  }

  public void setSpeedShooter(double shooterSpeed){
    this.motorShooter.set(shooterSpeed);
    this.shooterSpeed = shooterSpeed;
  }

  public void setSpeedAngle(double angleSpeed){
    this.motorAngle.set(ControlMode.PercentOutput, angleSpeed);
    this.angleSpeed = angleSpeed;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter Speed", this.shooterSpeed);
    SmartDashboard.putNumber("Angle Speed", this.angleSpeed);
  }
}