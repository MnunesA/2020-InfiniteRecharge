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

public class SubsystemStorage extends SubsystemBase {

  private double StorageSpeed;
  
  private int STORAGE_ID;

  private VictorSP motorStorage;

  public SubsystemStorage(int STORAGEID) {

    this.STORAGE_ID = STORAGEID;

    this.motorStorage = new VictorSP(STORAGE_ID);

  }

  public void setSpeedStorage(double storageSpeed){
    this.motorStorage.set(storageSpeed);
    this.StorageSpeed = storageSpeed;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Speed (Storage)", this.StorageSpeed);
    SmartDashboard.putNumber("Port (Storage_ID)", this.STORAGE_ID);
  }
}
