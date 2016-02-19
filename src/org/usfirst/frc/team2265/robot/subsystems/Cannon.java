package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2265.robot.subsystems.Piston;

/**
 *
 */
public class Cannon extends Subsystem {

    public CANTalon cannonFL, cannonFR, roller, camTalon, rollerPos;
    public Piston cannonPiston;
    public boolean isShooting = false;

    private double shootTicks, acquireTicks, gateTicks, camSecs;
    /*
     * shootTicks: ticks to go from acquire to shoot
     * gateTicks; ticks to go from acquire to gate
     * acqTicks: ticks it takes to go from shoot to acquire (=shootSecs)
     * camSecs: time it takes to turn the cam once
     * */
    
    private Timer timer; 
    public boolean isHigh, isLow, isShoot, isAcq, isGate;

    public Cannon() {
        cannonFL = new CANTalon(RobotMap.cannonFLPort);
        cannonFR = new CANTalon(RobotMap.cannonFRPort);
        roller = new CANTalon(RobotMap.rollerPort);
        rollerPos = new CANTalon(RobotMap.rollerPosPort);
        camTalon = new CANTalon(RobotMap.camTalonPort);
        
        camSecs = 0.75;
        shootTicks = 1800;
        acquireTicks = 1800;
        gateTicks = 1800; 
        
        isAcq=true;
        isLow = true;
        isHigh = false; 
        
        cannonPiston = new Piston(RobotMap.cannonSolPort1, RobotMap.cannonSolPort2, RobotMap.cannonSolPort3, RobotMap.cannonSolPort4);
        
        camTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        rollerPos.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        
        System.out.println("Cannon created.");
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
        cannonFL.set(-velocity);
        cannonFR.set(velocity);
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
    	timer.reset();
    	timer.start(); 
        while (timer.get() < camSecs) 
            camTalon.set(1.0);
        isShooting = true;
    }
    
    public void liftCannon() {
    	cannonPiston.extend();
    	isHigh = true; 
    	isLow = false; 
    	System.out.println("Cannon lifted");
    }
    
    public void lowerCannon() {
    	cannonPiston.retract();
    	isLow = true;
    	isHigh = false; 
    	System.out.println("Cannon lowered");
    }

    public void rollerShootPos() {
    	if (isAcq)
    		while (roller.getEncPosition() < shootTicks) { rollerPos.set(RobotMap.up); }
    	if(isGate)
    		while (roller.getEncPosition() < gateTicks- shootTicks) { rollerPos.set(RobotMap.down); }
    	isShoot = true;
    	isAcq= false;
    	isGate = false;
    }
    
    public void rollerAcquirePos() {
    	timer.reset();
    	timer.start();
    	if (isShoot)
    		while (roller.getEncPosition() < acquireTicks) { rollerPos.set(RobotMap.down); }
    	if(isGate)
    		while (roller.getEncPosition() < gateTicks) { rollerPos.set(RobotMap.down); }
    	isShoot = false;
    	isAcq = true;
    	isGate = false;
    }
    
    public void rollerGatePos() {
    	timer.reset();
    	timer.start();
    	if(isShoot)
    		while (roller.getEncPosition() < gateTicks-shootTicks) { rollerPos.set(RobotMap.up); }
    	if(isAcq)
    		while (roller.getEncPosition() < gateTicks) { rollerPos.set(RobotMap.up); }
    }
}