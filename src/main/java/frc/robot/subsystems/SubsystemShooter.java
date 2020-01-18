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
import frc.robot.RobotContainer;

public class SubsystemShooter extends SubsystemBase {

  //Botões no manche/Joystick
  private boolean J_Fire;
  private boolean J_Thumb;
  private boolean Test;

  //velocidade dos motores
  private double ShooterSpeed;
  private double AngleSpeed;

  private int SHOOTER_ID;
  private int ANGLE_ID;

  private VictorSP motorShooter;

  private TalonSRX motorAngle;

  public SubsystemShooter(int SHOOTERID, int ANGLEID ) {

    this.SHOOTER_ID = SHOOTERID;
    this.ANGLE_ID = ANGLEID;

    this.motorShooter = new VictorSP(SHOOTER_ID);

    this.motorAngle = new TalonSRX(ANGLE_ID);
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
    this.J_Fire = RobotContainer.J_Fire().get();
    this.J_Thumb = RobotContainer.J_Thumb().get();

    this.Test = RobotContainer.Test().get();

    SmartDashboard.putBoolean("Pressed (J_Fire)", this.J_Fire);
    SmartDashboard.putBoolean("Pressed (J_Thumb)", this.J_Thumb);

    SmartDashboard.putBoolean("Pressed (Test)", this.Test);

    SmartDashboard.putNumber("Speed (Shooter)", this.ShooterSpeed);
    SmartDashboard.putNumber("Speed (Angle)", this.AngleSpeed);

    SmartDashboard.putNumber("Port (Shooter_ID)", this.SHOOTER_ID);
    SmartDashboard.putNumber("Port (Angle_ID)", this.ANGLE_ID);
  }
}