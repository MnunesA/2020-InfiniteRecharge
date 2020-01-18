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
public final class Constants {

/* 
Todos as variáveis no código cujo o nome está escrito com todas as letras maiúsculas e        com as palavras separadas por underline têm sua base de valor nesta classe.
*/
  
    // PWM
    public static final int
    MOTOR_SHOOTER_ID = 4,
    MOTOR_SHOOTERANGLE_ID = 5,
    MOTOR_STORAGE_ID = 6;

    // CAN
    public static final int
    CAN_ID = 0;

    // DIO
    public static final int
    LIMIT_SWITCH_ID = 0;

    // ANALOG INPUTS
    public static final int
    AI_ID = 0;

    // RELAYS
    public static final int
    RELAY_ID = 0;

    // GENERALS
    public static final double
    // Circunferência da roda = 2 * π * Diâmetro / 2
    CIRCUMFERENCE_WHEEL = (2 * 3.1415 * (0.0254 * 6) / 2), //meters
    DEADBAND_VALUE = 0.04;
    
    // ENCODER
    public static final int
    ENCODER_DRIVER_CHANNEL_A_ID = 3,
    ENCODER_DRIVER_CHANNEL_B_ID = 4;
    
    // CONTROLLER XBOX
    public static final int
    XBOX_ID = 0;

    // CONTROLLER JOYSTICK
    public static final int
    JOYSTICK_ID = 1,
    J_FIRE_NUMBER = 1;
 
    // SPEEDS
    public static final double
    MOTOR_SHOOTER_SPEED_COMMANDSHOOTERANDSTORAGE = 0.5,
    MOTOR_STORAGE_SPEED_COMMANDSHOOTERANDSTORAGE = 0.5;
    
    // TIMERS
    public static final double
    TIMER_COMMANDSHOOTERANDSTORAGE = 3.0;
}