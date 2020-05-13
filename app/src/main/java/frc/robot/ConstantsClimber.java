/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ConstantsClimber {

/* 
Todas as variáveis no código cujo os nomes estão escritos com todas as letras maiúsculas e com as 
palavras separadas por underline têm sua base de valor nas classes "constants".
*/

  // PWM
  public static final int
    MOTOR_ELEVATOR_1_ID = 6,
    MOTOR_ELEVATOR_2_ID = 7,
    MOTOR_CLIMBER_1_ID = 4,
    MOTOR_CLIMBER_2_ID = 5;

  // SPEEDS
  public static final double
    SPEED_COMMANDELEVATOR = 0.5;

  //Digital Input
  public static final int
    ENCODER_ELEVATOR_A = 5,
    ENCODER_ELEVATOR_B = 6;

    //Digital Input Inverse
  public static final boolean
    ENCODER_ELEVATOR_INVERTED = false;

  //Encoder Elevator MAX
  public static final int
    ENCODER_ELEVATOR_MAX = 1167;
}