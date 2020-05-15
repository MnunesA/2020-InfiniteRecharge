/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Constants.CIRCUMFERENCE_WHEEL;
import java.util.List;
import java.util.ArrayList;

/**
 * The Constant class provides a convenient place for teams to hold robot-wide numerical or
 * boolean constants. This class should not be used for any other purpose. All constants should be
 * declared globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
 
public final class ConstantsDriver {

  // ID's from controllers
  List<Integer> leftID = new ArrayList<Integer>(){
    {
     add(0);
     add(1);
    }
  };
   
  List<Integer> rightID = new ArrayList<Integer>(){
    {
     add(2);
     add(3);
    }
  };

  // DIO
  public static final boolean THERE_IS_ENCODER = true;

  public static final int CHAN_LEFT_A_ID = 3,
      CHAN_LEFT_B_ID = 4,
      CHAN_RIGHT_A_ID = 5,
      CHAN_RIGHT_B_ID = 6;

  // ENCODERS SPECIFICATIONS
  public static final double MAX_PERIOD = 0.5, // second
      MIN_RATE = 0.05, // meters per second
      RESOLUTION = 2048, // Pulses Per Rotation
      DISTANCE_PER_PULSE = ((CIRCUMFERENCE_WHEEL / RESOLUTION) / 2) / 1; // meters
  public static final boolean
      // Inverter sentido de contagem do Encoder da tração
      ENCODER_LEFT_INVERTED = false,
      ENCODER_RIGHT_INVERTED = false;

  // SPEED LIMITER
  public static final double LIMITER_LINEAR = -0.7, LIMITER_ROTATION = 0.6;
}
