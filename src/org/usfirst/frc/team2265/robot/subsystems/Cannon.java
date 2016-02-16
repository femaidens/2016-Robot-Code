package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2265.robot.subsystems.Piston;

/**
 *
 */
public class Cannon extends Subsystem {

    public Talon cannonFL, cannonFR, roller;
    public CANTalon camTalon, rollerPos;
    public Piston cannonPiston;
    public boolean isShooting = false;
    //test to find number of ticks needed to fully turn the cam
    private int camTicks = 1800;
    private int shootTicks = 1800;
    private int acquireTicks = 1800;
    private int gateTicks = 1800;
    public boolean isHigh, isLow;
    

    public Cannon() {
        cannonFL = new Talon(RobotMap.cannonFLPort);
        cannonFR = new Talon(RobotMap.cannonFRPort);
        roller = new Talon(RobotMap.rollerPort);
        rollerPos = new CANTalon(RobotMap.rollerPosPort);
        isLow = true;
        cannonPiston = new Piston(RobotMap.cannonSolPort1, RobotMap.cannonSolPort2, RobotMap.cannonSolPort3, RobotMap.cannonSolPort4);
        camTalon = new CANTalon(RobotMap.camTalonPort);
        camTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        rollerPos.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
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
        while (camTalon.getEncPosition() < camTicks) 
            camTalon.set(0.25);
        	isShooting = true;
    }
    
    public void liftCannon() {
    	cannonPiston.extend();
    	isHigh = true; 
    	isLow = false; 
    }
    
    public void lowerCannon() {
    	cannonPiston.retract();
    	isLow = true;
    	isHigh = false; 
    }
    

    public void rollerShootPos() {
    	while (rollerPos.getEncPosition() < shootTicks) 
            rollerPos.set(0.25);

    }
    
    public void rollerAcquirePos() {
    	while (rollerPos.getEncPosition() < acquireTicks) 
            rollerPos.set(0.25);

    }
    
    public void rollerGatePos() {
    	while (rollerPos.getEncPosition() < gateTicks) 
            rollerPos.set(0.25);
    }
}