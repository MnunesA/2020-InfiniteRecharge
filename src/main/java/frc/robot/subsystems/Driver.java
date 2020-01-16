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
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class Driver extends PIDSubsystem {

  private VictorSP frontLeft = new VictorSP(0);
  private VictorSP frontRight = new VictorSP(1);
  private VictorSP rearLeft = new VictorSP(2);
  private VictorSP rearRight = new VictorSP(3);

  private SpeedControllerGroup leftBox = new SpeedControllerGroup(rearLeft, frontLeft);
  private SpeedControllerGroup rightBox = new SpeedControllerGroup(rearRight, frontRight);

  private Encoder encoderLeft = new Encoder(4, 5);
  private Encoder encoderRight = new Encoder(6, 7);

  /**
   * Creates a new Driver.
   */
  public Driver() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0, 0, 0));
        setSetpoint(500);
        getController().setTolerance(10);
        enable();
  }

  @Override
  public void useOutput(double output, double setpoint) {
    tankDrive( setpoint - output, setpoint - output);
  }

  public void resetEncoder(){
    encoderRight.reset();
  }
  
  public void setPoint(){
    getController().setSetpoint(500);
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return encoderLeft.getDistance();
  }

  public int getPulses(char encoder) {
   int pulses;
   if(encoder == 'L'){
     pulses = encoderLeft.get();
   } else {
     pulses = encoderRight.get();
   } 
   return pulses;
  }

  public void tankDrive (double spLeft, double spRight){
    leftBox.set(spLeft);
    rightBox.set(spRight);
  }
   
  public boolean atSetPoint(){
     return getController().atSetpoint();
  }
  



}
