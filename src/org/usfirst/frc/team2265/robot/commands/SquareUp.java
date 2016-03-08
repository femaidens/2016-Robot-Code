package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Camera;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SquareUp extends Command {
	public boolean done; 
    
	public SquareUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	done = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	done = Robot.cammy.centering();
    	
    	if(Robot.cammy.centering() >= -5.0 && Robot.cammy.centering() <= 5.0) { 
    		Robot.driveTrain.drive(0.0, 0.0); 
    		
    		done = true; 
    	}
    	if (Robot.cammy.centering() < -5.0){
    		Robot.driveTrain.drive(0.1,-0.1);
    		Timer.delay(0.5);
    		Robot.driveTrain.drive(0.0, 0.0); 
    	}
    	
    	if (Robot.cammy.centering() > 5.0)
    		Robot.driveTrain.drive(-0.1, 0.1);
	    	Timer.delay(0.5);
			Robot.driveTrain.drive(0.0, 0.0);
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
