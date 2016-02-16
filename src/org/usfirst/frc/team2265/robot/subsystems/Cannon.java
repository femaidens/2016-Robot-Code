package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2265.robot.subsystems.Piston;

/**
 *
 */
public class Cannon extends Subsystem {

    public CANTalon cannonL, cannonR, roller, camTalon, rollerServo;
    public Piston cannonPiston;
    public boolean isShooting = false; 
    
    //test to find number of ticks needed 
    private int camTicks = 1800;
    private int shootTicks = 1800;
    private int acquireTicks = 1800;
    
    public boolean isHigh, isLow;
    
    private double Kp = 0.05, Ki = 0.01, Kd=0.0; 
    private double Kpwm = 1/585;
    //needs the actual pwm constant
    
    private double leftVError, leftVErrorSum, leftVErrorChange, rightVError, rightVErrorSum, rightVErrorChange, leftOutput, rightOutput; 
    
    public Cannon() {
    	
        cannonL = new CANTalon(RobotMap.cannonLPort);
        cannonR = new CANTalon(RobotMap.cannonRPort);
        camTalon = new CANTalon(RobotMap.camTalonPort);
        roller = new CANTalon(RobotMap.rollerPort);
        rollerServo = new CANTalon(RobotMap.rollerServoPort);
        cannonL.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        cannonR.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        camTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        
        cannonPiston = new Piston(RobotMap.cannonSolPort1, RobotMap.cannonSolPort2, RobotMap.cannonSolPort3, RobotMap.cannonSolPort4);
        
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void spinWheels(double pwm) {
        //positive velocity is to shoot
        //negative velocity is to acquire
    	
    	double velocity = pwm * 585;
    	//TO-DO:
    	
    		leftVErrorChange = leftVError - (velocity - cannonL.getEncVelocity()); 
    		leftVError = velocity - cannonL.getEncVelocity();
    		leftVErrorSum += leftVError;
    		
    		rightVErrorChange = rightVError - (velocity - cannonR.getEncVelocity()); 
    		rightVError = velocity - cannonR.getEncVelocity();
    		rightVErrorSum += rightVError;
    		
    		leftOutput += -Kpwm*(Kp*leftVError + Ki*leftVErrorSum + Kd*leftVErrorChange); 
    		rightOutput += Kpwm*(Kp*rightVError + Ki*rightVErrorSum + Kd*rightVErrorChange);
    	
    		cannonL.set(leftOutput);
    		cannonR.set(rightOutput);
        //cannonFL.set(-velocity);
        //cannonFR.set(velocity);
        //PIDCannonFL.get();
        //PIDCannonFR.get();
        
    }

    public void spinWheels(double leftVelocity, double rightVelocity) {
        //positive velocity is to shoot
        //negative velocity is to acquire
        cannonL.set(leftVelocity);
        cannonR.set(-rightVelocity);
    }

    public void spinRoller(double velocity) {
        roller.set(velocity);
    }

    public void stop() {
        cannonL.set(0.0);
        cannonR.set(0.0);
        roller.set(0.0);
        isShooting = false;
    }
    
    public void turnCam() {
        while (camTalon.getEncPosition() < camTicks) 
            camTalon.set(0.25);
        	isShooting = true;
    }
    
    public void liftRoller() {
    	while (camTalon.getEncPosition() < shootTicks)
    		rollerServo.set(0.25);
    }
    
    public void lowerRoller() {
    	while (camTalon.getEncPosition() < acquireTicks)
    		rollerServo.set(-0.25);
    }
    
    public void liftCannon() {
    	cannonPiston.extend();
    }
    
    public void lowerCannon() {
    	cannonPiston.retract();
    }
}