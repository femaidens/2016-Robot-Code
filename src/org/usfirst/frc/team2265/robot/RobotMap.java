package org.usfirst.frc.team2265.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int leftJoyPort = 0;
	public static int rightJoyPort = 1;
	public static int atkJoyPort = 2;
		
	//Talon Ports
	public static int cannonFLPort = 0;
	public static int cannonFRPort = 99;
	public static int rollerPort = 99; 
	public static int camTalonPort = 99;
	public static int rearLeftPort = 1;
	public static int rearRightPort = 13;
	public static int frontLeftPort = 2;
	public static int frontRightPort = 12;
	
	//Sensor Ports
	public static int gyroPort = 0; //analog

	//Solenoid Ports
	public static int rollerSolPort1 = 0;
	public static int rollerSolPort2 = 1; 
	public static int cannonSolPort1 = 2;
	public static int cannonSolPort2 = 3;
	public static int transPort1= 0; 
	public static int transPort2= 1; 

    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
	
	//talon ports
	public static final int winchLeftPort = 99; 
	public static final int winchRightPort = 99;
	public static final int liftPort = 99;
    // public static int rangefinderModule = 1;
}
