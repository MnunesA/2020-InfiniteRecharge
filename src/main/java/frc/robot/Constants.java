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
    // PWM
    public static final int
    MOTOR_LEFT_FRONT_ID = 0,
    MOTOR_LEFT_REAR_ID = 1,
    MOTOR_RIGHT_FRONT_ID = 2,
    MOTOR_RIGHT_REAR_ID = 3;

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
    DIAMETER_WHEEL = (2 * 3.1415 * (0.0254 * 6) / 2); //meters

    // ENCODER
    public static final int
    ENCODER_DRIVER_CHANNEL_A_ID = 3,
    ENCODER_DRIVER_CHANNEL_B_ID = 4;

    public static final double
    ENCODER_DRIVER_MAX_PERIOD = 0.5,
    ENCODER_DRIVER_MIN_RATE = 5,
    ENCODER_DRIVER_RESOLUTION = 2048,
    ENCODER_DRIVER_DISTANCE_PER_PULSE = ((DIAMETER_WHEEL/ENCODER_DRIVER_RESOLUTION)/1);

    // CONTROLLER
    public static final int
    XBOX_ID = 0;
}
