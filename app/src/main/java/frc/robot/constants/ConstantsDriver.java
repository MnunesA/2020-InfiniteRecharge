/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogGyro;
import java.util.List;
import java.util.ArrayList;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

/*
Todas as variáveis no código cujo os nomes estão escritos com todas as letras maiúsculas e com as
palavras separadas por underline têm sua base de valor nas classes "constants".
*/

public final class ConstantsDriver {

  /** ************************************************************************* */

  // ID's from controllers
  List<Integer> leftID =
      new ArrayList<Integer>() {
        {
          add(CHANNEL_PWM_0);
          add(CHANNEL_PWM_1);
        }
      };

  List<Integer> rightID =
      new ArrayList<Integer>() {
        {
          add(CHANNEL_PWM_2);
          add(CHANNEL_PWM_3);
        }
      };

/*****************************************************************************/

  // Sensors
  public static final boolean ENCODER_LEFT_INVERTED = false, ENCODER_RIGHT_INVERTED = false;

  Encoder encoderLeft =
      new Encoder(CHANNEL_DIO_3, CHANNEL_DIO_4, ENCODER_LEFT_INVERTED, Encoder.EncodingType.k2X);

  Encoder encoderRight =
      new Encoder(CHANNEL_DIO_5, CHANNEL_DIO_6, ENCODER_RIGHT_INVERTED, Encoder.EncodingType.k2X);

  DigitalInput limitSwitch = null;

  AnalogGyro gyro = null;

/*****************************************************************************/

  // Encoders specifications
  public static final double MAX_PERIOD = 0.5, // second
      MIN_RATE = 0.05, // meters per second
      RESOLUTION = 2048, // Pulses Per Rotation
      DISTANCE_PER_PULSE = ((CIRCUMFERENCE_WHEEL / RESOLUTION) / 2) / 1; // meters

/*****************************************************************************/

  // Speed limiter and final speed for driver
  public static final double 
      LIMITER_LINEAR = -0.7,
      LIMITER_ROTATION = 0.6,
      
      LINEAR_SPEED = LIMITER_LINEAR * RobotContainer.xboxController().getRawAxis(1),
      ROTATION_SPEED = LIMITER_ROTATION * RobotContainer.xboxController().getRawAxis(4);

/*****************************************************************************/
}
