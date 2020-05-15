/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Constants.CIRCUMFERENCE_WHEEL;

/**
 * The ConstantsDriver class provides a convenient place for teams to hold robot-wide numerical or
 * boolean constants. This class should not be used for any other purpose. All constants should be
 * declared globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ConstantsDriver {

  // Number of Controllers
  public static final int NUMBER_OF_RIGHT_CONTROLLERS = 2;
  public static final int NUMBER_OF_LEFT_CONTROLLERS = 2;

  // PWM CONTROLLERS SET: 0-1 (right side) 2-3 (left side)
  public static final int FIRST_CONTROLLER_OF_THE_LEFT_ID = 0, FIRST_CONTROLLER_OF_THE_RIGHT_ID = 2;

  // DIO
  public static final boolean THERE_IS_ENCODER = true;

  public static final int ENCODER_LEFT_CHANNEL_A_ID = 3,
      ENCODER_LEFT_CHANNEL_B_ID = 4,
      ENCODER_RIGHT_CHANNEL_A_ID = 5,
      ENCODER_RIGHT_CHANNEL_B_ID = 6;

  // ENCODERS SPECIFICATIONS
  public static final double ENCODERS_MAX_PERIOD = 0.5, // second
      ENCODERS_MIN_RATE = 0.05, // meters per second
      ENCODERS_RESOLUTION = 2048, // Pulses Per Rotation
      ENCODERS_DISTANCE_PER_PULSE = ((CIRCUMFERENCE_WHEEL / ENCODERS_RESOLUTION) / 2) / 1; // meters
  public static final boolean
      // Inverter sentido de contagem do Encoder da tração
      ENCODER_LEFT_INVERTED = false,
      ENCODER_RIGHT_INVERTED = false;

  // SPEED LIMITER
  public static final double LIMITER_LINEAR = -0.7, LIMITER_ROTATION = 0.6;
}
