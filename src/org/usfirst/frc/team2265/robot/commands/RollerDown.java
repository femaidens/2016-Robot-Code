//this command puts the roller down to acquire
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RollerDown extends Command {

	private static boolean done; 
	
    public RollerDown() {
    	done = false; 
    }
    
    protected void initialize() {}

    protected void execute() {
    	Robot.cannon.rollerAcquirePos();
    	done = true; 
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {}

    protected void interrupted() {}
}
