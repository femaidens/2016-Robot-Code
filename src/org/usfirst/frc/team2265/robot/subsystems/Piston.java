package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Piston extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid actuator;
	
	public Piston (int port1, int port2 ) {
		actuator = new DoubleSolenoid(port1, port2);
	}
	
 
	//method to extend the piston
	public void extend() {
		actuator.set(DoubleSolenoid.Value.kForward);
	}
	
	//method to retract the piston
	public void retract() {
		actuator.set(DoubleSolenoid.Value.kReverse);
	}
	
	//method to return the value of the piston
	public Value get() {
		return actuator.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	actuator.set(DoubleSolenoid.Value.kOff);
    }
}

