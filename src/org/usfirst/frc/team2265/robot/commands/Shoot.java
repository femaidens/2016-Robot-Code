//This command shoots the ball.
package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team2265.robot.OI;
import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	double v;
	
    public Shoot(double velocity) {
    	v = velocity;
    }

    protected void initialize() {
    	RobotMap.turningCam = false; 
    }

    protected void execute() {
    	if (Robot.cannon.isHigh) {
    		Robot.cannon.spinWheels(v, v);
    		System.out.println(v + "");
    		if (RobotMap.turningCam == true) {
        		Robot.cannon.turnCam();
        		RobotMap.turningCam = false;
        	}
    	}
    	if (Robot.cannon.isLow) {
    		Robot.cannon.spinWheels(v*0.75, v*0.75);
    		if (RobotMap.turningCam == true) {
        		Robot.cannon.turnCam();
        		RobotMap.turningCam = false;
        	}
    	}
    	RobotMap.turningCam = false;
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	//Robot.compressy.start();
    	RobotMap.turningCam = false; 
    }

    protected void interrupted() {
    }
}
