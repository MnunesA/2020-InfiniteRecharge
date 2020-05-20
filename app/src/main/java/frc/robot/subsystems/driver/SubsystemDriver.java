/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.driver;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.driver.SpeedControllerType;
import static frc.robot.ConstantsDriver.*;

public class SubsystemDriver extends SubsystemBase {

  private DifferentialDrive drivetrain;
  private Encoder encoderLeft, encoderRight;
  private SpeedControllerGroup motorsLeft, motorsRight;

  public SubsystemDriver(SpeedControllerType sc, double DEADB_VALUE) {
  
    motorsLeft = new SpeedControllerGroup(sc::getLeftControllers);
    motorsRight = new SpeedControllerGroup(sc::getRightControllers);

    drivetrain = new DifferentialDrive(motorsLeft, motorsRight);
    drivetrain.setDeadband(DEADB_VALUE);
  }

  public SubsystemDriver(SpeedControllerType sc, double DEADB_VALUE, boolean thereIsEncoder) {
  
    motorsLeft = new SpeedControllerGroup(sc::getLeftControllers);
    motorsRight = new SpeedControllerGroup(sc::getRightControllers);

    drivetrain = new DifferentialDrive(motorsLeft, motorsRight);
    drivetrain.setDeadband(DEADB_VALUE);

      this.encoderLeft =
          new Encoder(
              CHAN_LEFT_A_ID, CHAN_LEFT_B_ID, ENCODER_LEFT_INVERTED, Encoder.EncodingType.k2X);

      this.encoderLeft.setMaxPeriod(MAX_PERIOD);
      this.encoderLeft.setMinRate(MIN_RATE);
      this.encoderLeft.setDistancePerPulse(DISTANCE_PER_PULSE);

      this.encoderRight =
          new Encoder(
              CHAN_RIGHT_A_ID, CHAN_RIGHT_B_ID, ENCODER_RIGHT_INVERTED, Encoder.EncodingType.k2X);

      this.encoderRight.setMaxPeriod(MAX_PERIOD);
      this.encoderRight.setMinRate(MIN_RATE);
      this.encoderRight.setDistancePerPulse(DISTANCE_PER_PULSE);
  }

  public void arcadeDrive(double linearSpeed, double rotationSpeed) {
    this.drivetrain.arcadeDrive(linearSpeed, rotationSpeed);
  }

  public void setLinearSpeedDrivetrain(double linearSpeed) {
    this.drivetrain.arcadeDrive(linearSpeed, 0);
  }

  public void setRotationSpeedDrivetrain(double rotationSpeed) {
    this.drivetrain.arcadeDrive(0, rotationSpeed);
  }

  public int getPulsesEncoderLeft() {
    return this.encoderLeft.get();
  }

  public double getDistanceEncoderLeft() {
    return this.encoderLeft.getDistance();
  }

  public int getPulsesEncoderRight() {
    return this.encoderRight.get();
  }

  public double getDistanceEncoderRight() {
    return this.encoderRight.getDistance();
  }

  public void resetEncoders() {
    this.encoderRight.reset();
    this.encoderLeft.reset();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Pulses Encoder Left", getPulsesEncoderLeft());
    SmartDashboard.putNumber("Distance Walked Left", getDistanceEncoderLeft());
    SmartDashboard.putNumber("Pulses Encoder Right", getPulsesEncoderRight());
    SmartDashboard.putNumber("Distance Walked Right", getDistanceEncoderRight());
  }
}
