/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.constants;

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
 
public final class Constants {

/*****************************************************************************/

  // GENERALS
  public static final double
      // Circunferência da roda = 2 * π * Diâmetro / 2
      CIRCUMFERENCE_WHEEL = (2 * 3.1415 * (0.0254 * 6) / 2), // meters
      DEADBAND_VALUE = 0.04;

/**************************************************************************//***/

  // CONTROLLERS JOYSTICK
  public static final int XBOX_ID = 0,
  public static final int JOYSTICK_ID = 1;
  
/*****************************************************************************/

  //DIO's Channels
  public static final int
      CHANNEL_DIO_0 = 0,
      CHANNEL_DIO_1 = 1,
      CHANNEL_DIO_2 = 2,
      CHANNEL_DIO_3 = 3,
      CHANNEL_DIO_4 = 4,
      CHANNEL_DIO_5 = 5,
      CHANNEL_DIO_6 = 6,
      CHANNEL_DIO_7 = 7,
      CHANNEL_DIO_8 = 8,
      CHANNEL_DIO_9 = 9;
      
  //PWM's Channels
  public static final int
      CHANNEL_PWM_0 = 0,
      CHANNEL_PWM_1 = 1,
      CHANNEL_PWM_2 = 2,
      CHANNEL_PWM_3 = 3,
      CHANNEL_PWM_4 = 4,
      CHANNEL_PWM_5 = 5,
      CHANNEL_PWM_6 = 6,
      CHANNEL_PWM_7 = 7,
      CHANNEL_PWM_8 = 8,
      CHANNEL_PWM_9 = 9;
  
  
  //CAN's Channels
  public static final int
      CHANNEL_CAN_0 = 0,
      CHANNEL_CAN_1 = 1,
      CHANNEL_CAN_2 = 2,
      CHANNEL_CAN_3 = 3,
      CHANNEL_CAN_4 = 4,
      CHANNEL_CAN_5 = 5;
  
  //PCM Channels
  public static final int
      CHANNEL_PCM_0 = 0,
      CHANNEL_PCM_1 = 1,
      CHANNEL_PCM_2 = 2,
      CHANNEL_PCM_3 = 3,
      CHANNEL_PCM_4 = 4,
      CHANNEL_PCM_5 = 5,
      CHANNEL_PCM_6 = 6,
      CHANNEL_PCM_7 = 7;
      
  //ANALOGGYRO's Channels
  public static final int
      CHANNEL_AGY_0 = 0,
      CHANNEL_AGY_1 = 1;
      
/*****************************************************************************/
}