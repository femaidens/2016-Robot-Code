//This command changes the turnCam boolean to turn the cam.
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TurnCam extends Command {

    public TurnCam() {}

    protected void initialize() {}

    protected void execute() {
    	RobotMap.turningCam = true;
    }

    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {}

    protected void interrupted() {}
}
