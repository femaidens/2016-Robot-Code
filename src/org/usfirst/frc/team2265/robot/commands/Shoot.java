package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {
	double v;
	//boolean done;
    public Shoot(double velocity) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	v = velocity;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//turn off compressor
    	RobotMap.turningCam = false; 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.compressy.stop(); 
    	if (Robot.cannon.isHigh) {
    		Robot.cannon.spinWheelsShoot(v);
    		System.out.println(v + "");
    		if (RobotMap.turningCam == true) {
        		Robot.cannon.turnCam();
        		RobotMap.turningCam = false;
        	}
    	}
    	if (Robot.cannon.isLow) {
    		Robot.cannon.spinWheelsShoot(v*0.75);
    		if (RobotMap.turningCam == true) {
        		Robot.cannon.turnCam();
        		RobotMap.turningCam = false;
        	}
    	}
    	RobotMap.turningCam = false; 
    	//done = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.compressy.start();
    	RobotMap.turningCam = false; 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
