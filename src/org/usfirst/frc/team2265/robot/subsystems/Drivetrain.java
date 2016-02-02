package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class Drivetrain extends Subsystem {
     
	private static double Kp = 0.05;
	private static double Ki = 0.01;
	private static double Kd=0.0; 
	private static double Kpwm; 
	//needs the actual pwm constant 
	 
	public static CANTalon frontLeft= new CANTalon(RobotMap.frontLeftPort); 
    public static CANTalon frontRight= new CANTalon(RobotMap.frontRightPort); 
    public static CANTalon rearLeft= new CANTalon(RobotMap.rearLeftPort); 
    public static CANTalon rearRight= new CANTalon(RobotMap.rearRightPort); 
    
    public static Joystick rightJoy= new Joystick(RobotMap.rightJoyPort); 
    public static Joystick leftJoy= new Joystick(RobotMap.leftJoyPort); 
    
    public static DoubleSolenoid gearShifter= new DoubleSolenoid(RobotMap.transPort1, RobotMap.transPort2); 
	public static Compressor compressy = new Compressor(); 
    public static RobotDrive TankDrive= new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
   
    public static Encoder encFL = new Encoder(RobotMap.encLeftPort1,RobotMap.encLeftPort2);
    public static Encoder encFR = new Encoder(RobotMap.encRightPort1, RobotMap.encRightPort2); 
    public static Encoder encRL = new Encoder(RobotMap.encLeftPort1, RobotMap.encLeftPort2);
    public static Encoder encRR = new Encoder(RobotMap.encRightPort1, RobotMap.encRightPort2);
   
    public static PIDController pidFL = new PIDController(Kp, Ki, Kd, encFL, frontLeft);
    public static PIDController pidFR = new PIDController(Kp, Ki, Kd, encFR, frontRight);
    public static PIDController pidRL = new PIDController(Kp, Ki, Kd, encRL, rearLeft);
    public static PIDController pidRR = new PIDController(Kp, Ki, Kd, encRR, rearRight);
    private double flError, flErrorChange, flErrorSum, flOutput;
    private double frError, frErrorChange, frErrorSum, frOutput;
    private double rlError, rlErrorChange, rlErrorSum, rlOutput;
    private double rrError, rrErrorChange, rrErrorSum, rrOutput;
    private double velocity; //need actual velocity of the talons
       
   public void  Drive(){
	   
	   encFL.setDistancePerPulse(.07);
	   encFR.setDistancePerPulse(.07);
	   encRL.setDistancePerPulse(.07);
	   encRR.setDistancePerPulse(.07);
	   
	   pidFL.setSetpoint(velocity);
	   pidFR.setSetpoint(velocity);
	   pidRL.setSetpoint(velocity);
	   pidRR.setSetpoint(velocity);	   
	  
	   flError = (velocity - encFL.getRate());
	   flErrorChange = (flError - (velocity - encFL.getRate())); 
	   flErrorSum += flError; 
			   
	   frError = (velocity - encFR.getRate());
	   frErrorChange = frError - (velocity - encFR.getRate());
	   frErrorSum += frError;
	   
	   rlError = (velocity - encRL.getRate());
	   rlErrorChange = rlError - (velocity - encRL.getRate());
	   rlErrorSum += rlError;
	   
	   rrError = (velocity - encRR.getRate());
	   rrErrorChange = rrError - (velocity - encRR.getRate());
	   rrErrorSum += rrError;
	   
	   flOutput += Kpwm*(Kp*flError + Ki*flErrorSum + Kd*flErrorChange);
	   frOutput += Kpwm*(Kp*frError + Ki*frErrorSum + Kd*frErrorChange);
	   rlOutput += Kpwm*(Kp*rlError + Ki*rlErrorSum + Kd*rlErrorChange);
	   rrOutput += Kpwm*(Kp*rrError + Ki*rrErrorSum + Kd*rrErrorChange);
	   
	   frontLeft.set(flOutput);
	   frontRight.set(frOutput);
	   rearLeft.set(rlOutput);
	   rearRight.set(rrOutput);
   }
	
  
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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
}

