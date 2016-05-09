package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOnlyAuton extends CommandGroup {
    
    public DriveOnlyAuton() {
    	addSequential(new AutonDrive (1.0,1.0, 3.0));
    }
}
