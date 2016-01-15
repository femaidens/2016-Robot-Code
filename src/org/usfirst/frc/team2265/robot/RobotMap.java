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
	
		//Joystick Ports
		public static int leftJoyPort = 0;
		public static int rightJoyPort = 1;
		public static int atkJoyPort = 2;
			
		//Talon Ports
		public static int cannonFLPort = 0;
		public static int cannonFRPort = 14;
		public static int camTalonPort = 1;
		public static int rearLeftPort = 1;
		public static int rearRightPort = 1;
		public static int frontLeftPort = 1;
		public static int frontRightPort = 1;
		
		//Sensor Ports
		public static int gyroPort = 0; //analog
		public static int sol1Port = 0;
		public static int sol2Port = 1;
		
		
		
}
