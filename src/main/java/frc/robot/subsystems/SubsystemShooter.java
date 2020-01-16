/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.shooter.CommandAngle;

public class SubsystemShooter extends SubsystemBase {

  //Os botões no manche
  private boolean J_Fire;
  private boolean J_Thumb;

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

    RobotContainer.J_Thumb().whenPressed(RobotContainer.commAngle());
    RobotContainer.J_Fire().whenPressed(RobotContainer.commShooter());

    this.J_Fire = RobotContainer.J_Fire().get();
    this.J_Thumb = RobotContainer.J_Thumb().get();

    SmartDashboard.putBoolean("Pressed (J_fire)", this.J_Fire);
    SmartDashboard.putBoolean("Pressed (J_Thumb)", this.J_Thumb);

    SmartDashboard.putNumber("Speed (Shooter)", this.ShooterSpeed);
    SmartDashboard.putNumber("Speed (Angle)", this.AngleSpeed);

    SmartDashboard.putNumber("Port (Shooter_ID)", this.Shooter_ID);
    SmartDashboard.putNumber("Port (Angle_ID)", this.Angle_ID);
  }
}