package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonDrive extends Command {

    double x, y, time; 
    Timer timer; 
	public AutonDrive(double xDir, double yDir, double seconds) {
        requires(Robot.driveTrain); 
        x= xDir; 
        y= yDir; 
        time = seconds; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer(); 
    	timer.reset();
    	timer.start(); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Timer.getFPGATimestamp();
    		System.out.println(timer.get() + "");
    		Robot.driveTrain.drive(x, y); 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.drive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
