package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollerUp extends Command {

	boolean done = false; 

    protected void initialize() {}

    
    protected void execute() {
    	Robot.cannon.rollerShootPos();
    	done = true; 
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
