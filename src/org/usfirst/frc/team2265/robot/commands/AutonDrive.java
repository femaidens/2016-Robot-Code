package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonDrive extends Command {

    double x, y, time, timePassed; 
    Timer timer; 
    
	public AutonDrive(double xDir, double yDir, double seconds) {
        x= -xDir; 
        y= -yDir;
        time= seconds;  
    }

    protected void initialize() {
    	timer = new Timer(); 
    	timer.start(); 
    }

    protected void execute() {
    	    timePassed= timer.get();
    		System.out.println(timer.get() + "");
    		Robot.driveTrain.drive(x, y); 
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
