package org.usfirst.frc.team2265.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//REAL PORTS TBD 
	
		//Joystick Ports
	public static int leftJoyPort = 0;
	public static int rightJoyPort = 1;
	public static int atkJoyPort = 2;
		
	//Talon Ports
	public static int cannonFLPort = 5;
	public static int cannonFRPort = 6;
	public static int rollerPort = 4; 
	public static int acquirer = 1;
	public static int camTalonPort = 11;
	
	public static int rearLeftPort = 7;
	public static int frontLeftPort = 8;
	
	public static int rearRightPort = 9;
	public static int frontRightPort = 10;
	
	//Solenoid Ports
	public static int cannonSolPort1 = 2;
	public static int cannonSolPort2 = 3;
	public static int cannonSolPort3 = 6;
	public static int cannonSolPort4 = 7; 
		
		//Other
		//Time it takes for the wheels to reach full speed
		public static double wheelDelay = 1.25; 
		
		public static double up = -0.25;
		public static double down = 0.25;	
}
