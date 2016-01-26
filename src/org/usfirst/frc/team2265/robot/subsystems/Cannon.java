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
    public CANTalon camTalon;
    public Piston rollerPiston, cannonPiston;
    public boolean isShooting = false;
    //test to find number of ticks needed to fully turn the cam
    private int camTicks = 1800;

    public Cannon() {
        cannonFL = new Talon(RobotMap.cannonFLPort);
        cannonFR = new Talon(RobotMap.cannonFRPort);
        roller = new Talon(RobotMap.rollerPort);
        rollerPiston = new Piston(RobotMap.rollerSolPort1, RobotMap.rollerSolPort2);
        cannonPiston = new Piston(RobotMap.cannonSolPort1, RobotMap.cannonSolPort2);
        camTalon = new CANTalon(RobotMap.camTalonPort);
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