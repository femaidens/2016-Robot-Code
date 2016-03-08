package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Acquire extends Command {

	double velocity = 0.75;
	
    public Acquire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.cannon);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.cannon.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cannon.spinRoller(-velocity);
    	Robot.cannon.spinWheels(-velocity);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.cannon.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
