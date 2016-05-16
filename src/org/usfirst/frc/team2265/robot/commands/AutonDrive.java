//this command controls driving in autonomous.
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonDrive extends Command {

    double l, r, time, timePassed; 
    Timer timer; 
    
	public AutonDrive(double left, double right, double seconds) {
        l = -left;
        r = -right;
        time = seconds;  
    }

    protected void initialize() {
    	timer = new Timer(); 
    	timer.start(); 
    }

    protected void execute() {
    	    timePassed= timer.get();
    		System.out.println(timer.get() + "");
    		Robot.driveTrain.drive(l, r); 
    }

    protected boolean isFinished() {
        return timePassed > time;
    }

    protected void end() {
	    if (isFinished())
	    	Robot.driveTrain.drive(0.0, 0.0);
    }

    protected void interrupted() {}
}
