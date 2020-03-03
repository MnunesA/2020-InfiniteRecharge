/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubsystemShooter extends SubsystemBase {

  //velocidade dos motores
  private double ShooterSpeed;

  private int SHOOTER_ID;

  private VictorSP motorShooter;

  public SubsystemShooter(int SHOOTERID ) {

    this.SHOOTER_ID = SHOOTERID;

    this.motorShooter = new VictorSP(SHOOTER_ID);

  }

  public void setSpeedShooter(double shooterSpeed){
    this.motorShooter.set(shooterSpeed);
    this.ShooterSpeed = shooterSpeed;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Speed (Shooter)", this.ShooterSpeed);
    SmartDashboard.putNumber("Port (Shooter_ID)", this.SHOOTER_ID);
  }
}