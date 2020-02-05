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
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class Driver extends PIDSubsystem {

  private VictorSP frontLeft = new VictorSP(2);
  private VictorSP frontRight = new VictorSP(0);
  private VictorSP rearLeft = new VictorSP(3);
  private VictorSP rearRight = new VictorSP(1);

  private SpeedControllerGroup leftBox = new SpeedControllerGroup(rearLeft, frontLeft);
  private SpeedControllerGroup rightBox = new SpeedControllerGroup(rearRight, frontRight);
  private final SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0, 0, 0);



  private Encoder encoderLeft = new Encoder(4, 5);
  private Encoder encoderRight = new Encoder(7, 8);

  /**
   * Creates a new Driver.
   */
  public Driver() {
    super(
        // The PIDController used by the subsystem
        new PIDController(1, 0, 0));
        getController().setTolerance(10);
        enable();
        getController().setSetpoint(5000);
        encoderRight.reset();
        feedforward.calculate(10, 20);

  
  }

  @Override
  public void useOutput(double output, double setpoint) {
    tankDrive(output + getController().calculate(setpoint), output + getController().calculate(setpoint));
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return encoderRight.getDistance();
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
    frontLeft.set(spLeft);
    frontRight.set(spRight);
  }

  public void rightSet(double sp){
    rightBox.set(sp);
  }
   
  public boolean atSetPoint(){
     return getController().atSetpoint();
  }
  



}
