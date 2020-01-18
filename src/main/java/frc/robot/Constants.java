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
    SHOOTER_ID = 4;
    
    //CAN
    public static final int
    ANGLE_ID = 2;
        
    //Speed (OBS: Não será uma velocidade constante, porem coloquei aqui para ser mais fácil utilizar a variável)
    public static final double
    SHOOTERSPEED = 0.5,
    ANGLE_SPEED_POSITIVE = 0.4,
    ANGLE_SPEED_NEGATIVE = -0.4;
    
    //Joystick/Bottons
    public static final int
    JOYSTICK = 1,

    J_FIRE = 1,
    J_THUMB = 2,

    //Botao para teste, pois no documento consta apenas um (J_Thumb) para subir e descer (?)
    TEST = 3;
}