/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubsystemShooter extends SubsystemBase {

  //velocidade dos motores
  private double ShooterSpeed;
  private double AngleSpeed;

  private int Shooter_ID;
  private int Angle_ID;

  private VictorSP motorShooter;

  private TalonSRX motorAngle;

  public SubsystemShooter(int ShooterID, int AngleID) {

    this.Shooter_ID = ShooterID;
    this.Angle_ID = AngleID;

    this.motorShooter = new VictorSP(Shooter_ID);

    this.motorAngle = new TalonSRX(Angle_ID);

  }

  public void setSpeedShooter(double shooterSpeed){
    this.motorShooter.set(shooterSpeed);
    this.ShooterSpeed = shooterSpeed;
  }

  public void setSpeedAngle(double angleSpeed){
    this.motorAngle.set(ControlMode.PercentOutput, angleSpeed);
    this.AngleSpeed = angleSpeed;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Speed (Shooter)", this.ShooterSpeed);
    SmartDashboard.putNumber("Speed (Angle)", this.AngleSpeed);
  }
}