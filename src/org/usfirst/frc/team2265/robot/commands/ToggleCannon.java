package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleCannon extends Command {

    public ToggleCannon() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }
    boolean done;
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.cannon.isHigh){
    			Robot.cannon.lowerCannon();
    			done = true;
    			return;
    	}
    	if(Robot.cannon.isLow) {
    			Robot.cannon.liftCannon();
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
