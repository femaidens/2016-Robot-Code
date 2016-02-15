package org.usfirst.frc.team2265.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
   
	//Joystick Ports
			public static int leftJoyPort = 0;
			public static int rightJoyPort = 1;
			public static int atkJoyPort = 2;
				
			//Talon Ports
			public static int cannonFLPort = 0;
			public static int cannonFRPort = 99;
			public static int rollerPort = 99; 
			public static int camTalonPort = 99;
			public static int rearLeftPort = 2;
			public static int rearRightPort = 13;
			public static int frontLeftPort = 1;
			public static int frontRightPort = 13;
			
			//Sensor Ports
			public static int gyroPort = 0; //analog

			//Solenoid Ports
			public static int rollerSolPort1 = 0;
			public static int rollerSolPort2 = 1; 
			public static int cannonSolPort1 = 2;
			public static int cannonSolPort2 = 3;
			public static int transPort1= 0; 
			public static int transPort2= 1; 
}
