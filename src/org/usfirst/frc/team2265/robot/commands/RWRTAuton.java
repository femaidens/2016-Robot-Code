//This command group controls going over the rock wall/rough terrain in autonomous.
package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RWRTAuton extends CommandGroup {
    
    public  RWRTAuton() {
    	addSequential(new Jerk()); //works
    	addSequential(new AutonDrive (0.7, 0.7, 7.0));
    }
}
