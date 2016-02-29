package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	public static CANTalon frontLeft;
	public static CANTalon frontRight;
	public static CANTalon rearLeft;
	public static CANTalon rearRight;
	public static Joystick leftJoy, rightJoy;
	public static DoubleSolenoid gearShifter;
	public static Compressor compressy;
	public static RobotDrive tankDrive;
	public Drivetrain(){ 
		frontLeft= new CANTalon(RobotMap.frontLeftPort); 
		frontRight= new CANTalon(RobotMap.frontRightPort); 
		rearLeft= new CANTalon(RobotMap.rearLeftPort); 
		rearRight= new CANTalon(RobotMap.rearRightPort); 
		rightJoy= new Joystick(RobotMap.rightJoyPort); 
		leftJoy= new Joystick(RobotMap.leftJoyPort); 
		gearShifter= new DoubleSolenoid(RobotMap.transPort1, RobotMap.transPort2); 
		compressy = new Compressor(); 
		tankDrive= new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    }
	public void drive(){
		double leftVal= -leftJoy.getY();
		double rightVal= -rightJoy.getY(); 
		tankDrive.tankDrive(leftVal, rightVal); 
	}
    public void drive (double x, double y){
    	//tankDrive.tankDrive(x, y); 
    	System.out.println("Driving");
    	
    	frontRight.set(-x);
    	rearRight.set(-x);
    	
    	frontLeft.set(y);
    	rearLeft.set(y);
    }
    public void shiftToSpeed(){
    	gearShifter.set(DoubleSolenoid.Value.kForward); 
    }
    public void shiftToPower(){
    	gearShifter.set(DoubleSolenoid.Value.kReverse);
    }
    public boolean isDriving(){
    	if(frontRight.get() > 0 ||frontRight.get()< 0) {
    		return true; 
    	}
    	return false; 
    }
    
    public Value get() {
    	return gearShifter.get(); 
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.    
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
    
}

