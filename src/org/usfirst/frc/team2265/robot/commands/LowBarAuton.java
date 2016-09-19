//This commandgroup is for going under the lowbar in autonomous.
package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAuton extends CommandGroup {
    
    public  LowBarAuton() {
    	addSequential(new Jerk());
    	addSequential(new ToggleCannon());
    	addSequential(new AutonDrive(-0.45, -0.45, 5.0));
    }
}
