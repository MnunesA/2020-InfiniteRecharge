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

    // GENERALS
    public static final double
    // Circunferência da roda = 2 * π * Diâmetro / 2
    CIRCUMFERENCE_WHEEL = (2 * 3.1415 * (0.0254 * 6) / 2), //meters
    DEADBAND_VALUE = 0.04;
    
    // CONTROLLER
    public static final int
    XBOX_ID = 0;
}
