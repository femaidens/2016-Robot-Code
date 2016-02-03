package org.usfirst.frc.team2265.robot.subsystems;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	private Talon winchLeft, winchRight, liftPin; 
	private Timer timer;
	public Climber(){
		winchLeft = new Talon(RobotMap.winchLeftPort); 
		winchRight = new Talon(RobotMap.winchRightPort);
		liftPin = new Talon(RobotMap.liftPort);
		timer = new Timer();
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void extend() {
		timer.reset();
		while(timer.get() <= 0.1)	{
			liftPin.set(0.5);
		}
			
	}
	
	public void contract() {
		timer.reset();
		while(timer.get() <= 5.0){
			winchLeft.set(0.5);
			winchRight.set(0.5);
	
		}
	}
	public void lower(){
		timer.reset();
		while(timer.get() <= 5.0){
			winchLeft.set(-0.5);
			winchRight.set(-0.5);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

