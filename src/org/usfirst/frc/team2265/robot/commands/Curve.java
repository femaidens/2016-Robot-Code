package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Curve extends Command {

	double leftVelocity;
	double rightVelocity;
	
    public Curve(boolean direction) {
    	//true for right, false for left
    	if (direction == true) {
    		if (Robot.cannon.isHigh) {
	    		leftVelocity = 0.7;
	    		rightVelocity = 0.5;
    		}
    		else if (Robot.cannon.isLow){
    			leftVelocity = 0.5;
    			rightVelocity = 0.3;
    		}
    }
    	else if (direction == false) {
    		if (Robot.cannon.isHigh) {
	    		leftVelocity = 0.5;
	    		rightVelocity = 0.7;
    		}
    		else if (Robot.cannon.isLow){
    			leftVelocity = 0.3;
    			rightVelocity = 0.5;
    		}
    	}
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cannon);
    }
   
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cannon.spinWheels(leftVelocity, rightVelocity);
    	Timer.delay(RobotMap.wheelDelay);
    	Robot.cannon.turnCam();
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
