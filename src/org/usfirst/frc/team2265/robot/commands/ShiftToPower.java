
package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
public class ShiftToPower extends Command {

    public ShiftToPower() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
	    if (Robot.driveTrain.get().equals(Value.kReverse) || Robot.driveTrain.get().equals(Value.kOff)){
	    		Robot.driveTrain.shiftToPower();
	    		}
	    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
