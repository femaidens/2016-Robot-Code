package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

    double x, y; 
    
	public Drive(double xDir, double yDir) {
        //requires(Robot.driveTrain); 
        x= xDir; 
        y= yDir; 
    }

    protected void initialize() {}

    protected void execute() {
		Robot.driveTrain.drive(x,y); 
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
