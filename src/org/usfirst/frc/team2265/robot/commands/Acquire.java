//This command acquires the ball (the roller must be down)
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.*;

import edu.wpi.first.wpilibj.command.Command;

public class Acquire extends Command {

	double velocity = 1.0;

    protected void initialize() {
    	Robot.cannon.stop();
    }

    protected void execute() {
    	Robot.compressy.stop(); 
    	Robot.cannon.spinRoller(-velocity);
    	Robot.cannon.spinWheels(velocity, velocity);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.cannon.stop();
    	Robot.compressy.start(); 
    }
    
    protected void interrupted() {}
}
