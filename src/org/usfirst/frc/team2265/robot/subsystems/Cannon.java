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

    public Talon cannonFL, cannonFR, roller;
    public CANTalon camTalon;
    public PIDController PIDCannonFL, PIDCannonFR;
    public Encoder encLeft, encRight;
    public Piston rollerPiston, cannonPiston;
    public boolean isShooting = false; 
    //test to find number of ticks needed to fully turn the cam
    private int camTicks = 1800;
    private double Kp = 0.05, Ki = 0.01, Kd=0.0; 
    private double leftVError, leftVErrorSum, leftVErrorChange, rightVError, rightVErrorSum, rightVErrorChange, leftOutput, rightOutput; 
    public Cannon() {
    	encLeft = new Encoder(RobotMap.encLeftPort1, RobotMap.encLeftPort2);
    	encRight = new Encoder (RobotMap.encRightPort1, RobotMap.encRightPort2);
    	
        cannonFL = new Talon(RobotMap.cannonFLPort);
        cannonFR = new Talon(RobotMap.cannonFRPort);
        
        PIDCannonFL = new PIDController(0.05, 0.0, 0.0, encLeft, cannonFL);
        PIDCannonFR = new PIDController(0.05, 0.0, 0.0, encRight, cannonFR);
        
        roller = new Talon(RobotMap.rollerPort);
        rollerPiston = new Piston(RobotMap.rollerSolPort1, RobotMap.rollerSolPort2);
        cannonPiston = new Piston(RobotMap.cannonSolPort1, RobotMap.cannonSolPort2);
        camTalon = new CANTalon(RobotMap.camTalonPort);
        camTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        
        encLeft.setDistancePerPulse(0.002);
        encRight.setDistancePerPulse(0.002);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void spinWheels(double velocity) {
        //positive velocity is to shoot
        //negative velocity is to acquire
    	
    	PIDCannonFL.setSetpoint(-velocity);
    	PIDCannonFR.setSetpoint(velocity);
    	//TO-DO:
    	
    		leftVErrorChange = leftVError - (velocity - encLeft.getRate()); 
    		leftVError = velocity - encLeft.getRate();
    		leftVErrorSum += leftVError;
    		rightVErrorChange = rightVError - (velocity - encRight.getRate()); 
    		rightVError = velocity - encRight.getRate();
    		rightVErrorSum += rightVError;
    		
    		leftOutput += -(Kp*leftVError + Ki*leftVErrorSum + Kd*leftVErrorChange); 
    		rightOutput += Kp*rightVError + Ki*rightVErrorSum + Kd*rightVErrorChange; 
    	
    		cannonFL.set(leftOutput);
    		cannonFR.set(rightOutput);
        //cannonFL.set(-velocity);
        //cannonFR.set(velocity);
        //PIDCannonFL.get();
        //PIDCannonFR.get();
        
    }

    public void spinWheels(double leftVelocity, double rightVelocity) {
        //positive velocity is to shoot
        //negative velocity is to acquire
        cannonFL.set(leftVelocity);
        cannonFR.set(-rightVelocity);
    }

    public void spinRoller(double velocity) {
        roller.set(velocity);
    }

    public void stop() {
        cannonFL.set(0.0);
        cannonFR.set(0.0);
        roller.set(0.0);
        isShooting = false;
    }
    
    public void turnCam() {
        while (camTalon.getEncPosition() < camTicks) 
            camTalon.set(0.25);
        	isShooting = true;
    }
    
    public void liftRoller() {
    	rollerPiston.extend();
    }
    
    public void lowerRoller() {
    	rollerPiston.retract();
    }
    
    public void liftCannon() {
    	cannonPiston.extend();
    }
    
    public void lowerCannon() {
    	cannonPiston.retract();
    }
}