//This command aims the cannon/changes its position.
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ToggleCannon extends Command {

    public ToggleCannon() {}
    
    boolean done;
    protected void initialize() {}

    protected void execute() {
    	if (Robot.cannon.isHigh){
    			Robot.cannon.lowerCannon();
    			System.out.println("cannon at low");
    			done = true;
    			return;
    	}
    	if(Robot.cannon.isLow) {
    			Robot.cannon.liftCannon();
    			System.out.println("Cannon is high");
    			done = true; 
    			return;
    	}
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
