package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Jerk extends Command {

    Timer timer; 
    double time, timePassed;
    
	public Jerk() {
		timer = new Timer();
		time = .5; 
    }
	
    protected void initialize() {
    	timer.start();
    }

    protected void execute() {
    	timePassed = timer.get(); 
    	if(timePassed < time / 1.5 )
    		Robot.driveTrain.drive(1.0, 1.0);
    	else
    		Robot.driveTrain.drive( -1.0, -1.0); 
    }

    protected boolean isFinished() {
        return timePassed > time;
    }

    protected void end() {
    	if(isFinished())
    		Robot.driveTrain.drive(0.0, 0.0); 
    }

    protected void interrupted() {}
}
