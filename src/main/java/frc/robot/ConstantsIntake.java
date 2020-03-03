/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The ConstantsIntake class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ConstantsIntake {

    // PWM
    public static final int
    MOTOR_ANGULATION_ID = 1,
    MOTOR_TO_TAKE_ID = 0;

    // DIO
    public static final int
    LIMITSWITCH_UP_ID = 7,
    LIMITSWITCH_DOWN_ID = 8;
 
    // SPEED
    public static final double 
    SPEED_ANGULATION_UP = -0.5,
    SPEED_ANGULATION_DOWN = 0.5;
}