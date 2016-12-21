//This command controls the driving of the robot (in teleop).
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

    double l, r; 
    
	public Drive(double left, double right) {
        l = left; 
        r = right;
    }

    protected void initialize() {}

    protected void execute() {
		Robot.driveTrain.drive(l,r); 
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
