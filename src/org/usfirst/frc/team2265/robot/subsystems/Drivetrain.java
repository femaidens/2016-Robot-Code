package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import com.ctre.CANTalon;
//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	//Initalizes talons for drivetrain 
	public static CANTalon frontLeft= new CANTalon(RobotMap.frontLeftPort); 
    public static CANTalon frontRight= new CANTalon(RobotMap.frontRightPort); 
    public static CANTalon rearLeft= new CANTalon(RobotMap.rearLeftPort); 
    public static CANTalon rearRight= new CANTalon(RobotMap.rearRightPort); 
    //Initializes driving joysticks
    //public static Joystick rightJoy= new Joystick(RobotMap.rightJoyPort); 
    //public static Joystick leftJoy= new Joystick(RobotMap.leftJoyPort);
    public static Joystick atkJoy = new Joystick(RobotMap.atkJoyPort); 
    
    //Initializes transmission solenoid
    public static DoubleSolenoid gearShifter= new DoubleSolenoid(RobotMap.transPort1, RobotMap.transPort2); 
    //public static DoubleSolenoid gearShifter2= new DoubleSolenoid(RobotMap.transPort3, RobotMap.transPort4);
	
    
    //Initializes compressor and robot drive system
    public static Compressor compressy = new Compressor();
    public static RobotDrive TankDrive= new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
    //Initializes encoders for the left and right sides of the drivetrain  
    public Drivetrain(){
    	frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder); 
    	frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	//frontRight.configEncoderCodesPerRev(255);
    }
    //Gets Joystick values, uses values to control robot, displays velocity 
	public void drive(){
		double leftVal= atkJoy.getRawAxis(1);
		double rightVal=atkJoy.getRawAxis(5);
		TankDrive.tankDrive(leftVal, rightVal); 
		SmartDashboard.putNumber("Right Encoder Values", frontRight.getEncVelocity());
		SmartDashboard.putNumber("Left Encoder Vals" , frontLeft.getEncVelocity());
	}	
	//drives with set parameters 
    public void drive (double x, double y){
    	//TankDrive.tankDrive(x, y); 
    	
    	frontRight.set(-x);
    	rearRight.set(-x);
    	
    	frontLeft.set(y);
    	rearLeft.set(y);
    }
    
    //Shifts transmission to speed/power mode 
    public void shiftToSpeed(){
    	gearShifter.set(DoubleSolenoid.Value.kReverse); 
    }
    
    public void shiftToPower(){
    	gearShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    //Returns transmission setting
    public Value get() {
    	return gearShifter.get(); 
    }
    
    //Returns a string depending on transmission
    public String toString(){
    	if (get() == DoubleSolenoid.Value.kForward)
			return "Power Mode";
    	else
    		return "Speed Mode";
    }
  
    // Put methods for controlling this subsystem
    // here. Call these from Commands.    
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
    
}

