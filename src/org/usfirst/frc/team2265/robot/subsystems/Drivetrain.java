package org.usfirst.frc.team2265.robot.subsystems;

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
     
	public static CANTalon frontLeft= new CANTalon(RobotMap.frontLeftPort); 
    public static CANTalon frontRight= new CANTalon(RobotMap.frontRightPort); 
    public static CANTalon rearLeft= new CANTalon(RobotMap.rearLeftPort); 
    public static CANTalon rearRight= new CANTalon(RobotMap.rearRightPort); 
    public static Joystick rightJoy= new Joystick(RobotMap.rightJoyPort); 
    public static Joystick leftJoy= new Joystick(RobotMap.leftJoyPort); 
    public static DoubleSolenoid gearShifter= new DoubleSolenoid(RobotMap.transPort1, RobotMap.transPort2); 
	public static Compressor compressy = new Compressor(); 
    public static RobotDrive TankDrive= new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    
	public void drive(){
		double leftVal= -leftJoy.getY();
		double rightVal= -rightJoy.getY(); 
		TankDrive.tankDrive(leftVal, rightVal); 
	}
    public void drive (double x, double y){
    	TankDrive.tankDrive(x, y); 
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

