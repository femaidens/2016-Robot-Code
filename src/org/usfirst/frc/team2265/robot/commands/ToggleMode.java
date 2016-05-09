package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleMode extends Command {
	boolean shifted;
    public ToggleMode() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.driveTrain.get().equals(Value.kForward)|| Robot.driveTrain.get().equals(Value.kOff)){
    		Robot.driveTrain.shiftToSpeed();
    		SmartDashboard.putString("DB/String 0", "Mode: Power Mode");
    		//SmartDashboard.putString("Mode: ", "Speed Mode");
    		shifted = true;
    		return;
    		
    	}
    	
    	if(Robot.driveTrain.get().equals(Value.kReverse)|| Robot.driveTrain.get().equals(Value.kOff)){
    		Robot.driveTrain.shiftToPower(); 
    		SmartDashboard.putString("DB/String 0", "Mode: Speed Mode");
    		//SmartDashboard.putString("Mode: ", "Power Mode");
    		shifted = true; 
    		return;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shifted;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
