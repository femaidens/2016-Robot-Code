

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
			
			//Solenoid Ports
			public static int cannonSolPort1 = 2;
			public static int cannonSolPort2 = 3;
			public static int cannonSolPort3 = 6;
			public static int cannonSolPort4 = 7; 
			
			//add other sol ports
			public static int transPort1= 0; 
			public static int transPort2= 1; 
			public static int transPort3 = 4; 
			public static int transPort4 = 5; 
			
			//Talon Ports
			public static int cannonFLPort = 5;
			public static int cannonFRPort = 6;
			public static int rollerPort = 4; 
			public static int acquirer = 1;
			public static int camTalonPort = 11;
			
			// ACTUAL ROBOT PORTS. 
			public static int rearLeftPort = 7;
			public static int frontLeftPort = 8;
			
			public static int rearRightPort = 9;
			public static int frontRightPort = 10;
			
			//public static int limitSwitch = 0; 
			
			//test ports
			/*public static int rearLeftPort = 12;
			public static int frontLeftPort = 2;
			
			public static int rearRightPort = 13;
			public static int frontRightPort = 1; */
			
			//Other
			//Time it takes for the wheels to reach full speed
			public static double wheelDelay = 1.25; 
			
			public static double up = -0.45;
			public static double down = 0.45;	
			
			public static boolean turningCam = false;
			
			public static int leftEncPort = 0;
			public static int leftEncPort2 = 1;
			
			public static int rightEncPort = 2;
			public static int rightEncPort2 = 3;
			
				
}
