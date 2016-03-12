package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleRoller extends Command {

	boolean done;
	private static int position; 
	
    public ToggleRoller() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cannon.rollerAcquirePos();
    	position = 0;  
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(position == 0)
    	{
    		Robot.cannon.rollerShootPos(); 
    		position++; 
    		done = true;
    		return;
    	}
    	else if (position == 1){
    		Robot.cannon.rollerAcquirePos();
    		position--; 
    		done = true;
    		return;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cannon.rollerPos.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
