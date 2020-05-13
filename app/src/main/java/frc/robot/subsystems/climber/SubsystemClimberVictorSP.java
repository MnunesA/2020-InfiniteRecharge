
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.climber;

import edu.wpi.first.wpilibj.VictorSP;

public class SubsystemClimberVictorSP extends SubsystemClimber {

  private VictorSP motorClimber_1, motorClimber_2;

  public SubsystemDriverVictorSP(
      int MC1_ID,
      int MC2_ID) {

    motorClimber_1 = new VictorSP(MC1_ID);
    motorClimber_2 = new VictorSP(MC2_ID);
    
    motorClimber_1.enableDeadbandElimination(true);
    motorClimber_2.enableDeadbandElimination(true);

    this.motorsClimber = new SpeedControllerGroup(motorClimber_1, motorClimber_2);
  }
}