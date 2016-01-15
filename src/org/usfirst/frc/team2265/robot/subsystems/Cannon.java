package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cannon extends Subsystem {
	
	public Talon cannonFL, cannonFR;
	public CANTalon camTalon;
	private int camTicks = 1800;
	
	
	public Cannon() {
		cannonFL = new Talon (RobotMap.cannonFLPort);
		cannonFR = new Talon (RobotMap.cannonFRPort);
		camTalon = new CANTalon (RobotMap.camTalonPort);
		camTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
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
    public void spinWheels(double leftVelocity, double rightVelocity){
    	//positive velocity is to shoot
    	//negative velocity is to acquire
    	cannonFL.set(leftVelocity);
    	cannonFR.set(-rightVelocity);
    	
    }
    public void stop() {
    	cannonFL.set(0);
    	cannonFR.set(0);
    }
    
    public void turnCam() {
    	while (camTalon.getEncPosition() < camTicks) {
    		camTalon.set(0.25);
    	}
    }
}

