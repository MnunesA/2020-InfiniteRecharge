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

    //PWM
    public static final int
    SHOOTER_ID = 2;

    //CAN
    public static final int
    ANGLE_ID = 1;
    
    //Speed (OBS: Não será uma velocidade constante, coloquei aqui para ser mais fácil utilizar a variável)
    public static final double
    SHOOTERSPEED = 0.5,
    ANGLESPEED = 0.4;

    //Joystick
    public static final int
    JOYSTICK = 1,
    J_FIRE = 1,
    J_THUMB = 2;
}
