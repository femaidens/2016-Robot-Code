//This command toggle the transmissions on the drivetrain.
package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ToggleMode extends Command {
	boolean shifted;
	
    public ToggleMode() {}

    protected void initialize() {}
    
    protected void execute() {
    	
    	if (Robot.driveTrain.get().equals(Value.kForward)|| Robot.driveTrain.get().equals(Value.kOff)){
    		Robot.driveTrain.shiftToSpeed();
    		SmartDashboard.putString("DB/String 0", "Mode: Power Mode");
    		shifted = true;
    		return;
    	}
    	
    	if(Robot.driveTrain.get().equals(Value.kReverse)|| Robot.driveTrain.get().equals(Value.kOff)){
    		Robot.driveTrain.shiftToPower(); 
    		SmartDashboard.putString("DB/String 0", "Mode: Speed Mode");
    		shifted = true; 
    		return;
    	}
    }
    protected boolean isFinished() {
        return shifted;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
