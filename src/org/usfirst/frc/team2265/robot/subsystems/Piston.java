package org.usfirst.frc.team2265.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Piston extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid actuator, actuator2;
	Timer timer = new Timer(); 
	
	public Piston (int port1, int port2, int port3, int port4) {
	//public Piston (int port1, int port2) {
		actuator = new DoubleSolenoid(port1, port2);
		actuator2 = new DoubleSolenoid(port3, port4);
		System.out.println("Piston created." );
		
	}
	
	//method to extend the piston
	public void extend() {
		actuator.set(DoubleSolenoid.Value.kForward);
		actuator2.set(DoubleSolenoid.Value.kForward);
		System.out.println("Piston extended");
		
	}
	
	//method to retract the piston
	public void retract() {
		actuator.set(DoubleSolenoid.Value.kReverse);
		actuator2.set(DoubleSolenoid.Value.kReverse);
		System.out.println("Piston retracted");
		
	}
	
	//method to return the value of the piston
	public Value get() {
		return actuator.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	actuator.set(DoubleSolenoid.Value.kOff);
    	actuator2.set(DoubleSolenoid.Value.kOff);
    	System.out.println("Piston default command run");
    }
}