package org.usfirst.frc.team2265.robot;

public class RobotMap {
   
	//Joystick Ports
	public static int leftJoyPort = 0;
	public static int rightJoyPort = 1;
	public static int atkJoyPort = 2;
	
	//Solenoid Ports
	public static int cannonSolPort1 = 0;
	public static int cannonSolPort2 = 1;
	public static int cannonSolPort3 = 4; 
	public static int cannonSolPort4 = 5; 
	public static int transPort1= 2;
	public static int transPort2= 3;
	
	//Talon Ports
	public static int cannonFLPort = 9; // 100%
	public static int cannonFRPort = 3; // 100%
	public static int rollerPort = 8; // doesn't matter
	public static int acquirer = 7; // doesn't matter
	public static int camTalonPort = 1; // 100%
	public static int rearLeftPort = 5; // ?
	public static int frontLeftPort = 6; // ?
	public static int rearRightPort = 4; // 100%
	public static int frontRightPort = 2; // 100%
	
	//also need to figure out why only one piston on the cannon is extending
	
	//Other
	public static double up = -0.35;
	public static double down = 0.35;	
	
	public static boolean turningCam = false;
	
	public static int leftEncPort = 0;
	public static int leftEncPort2 = 1;
	
	public static int rightEncPort = 2;
	public static int rightEncPort2 = 3;			
}
