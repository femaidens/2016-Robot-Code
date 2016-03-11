package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoZone extends CommandGroup {
    
    public AutoZone(int zone, double speed) {
    	
    	addSequential(new Jerk()); //works
    	addSequential(new AutonDrive (speed, speed, 3.0));
		
		switch(zone){
			case 1: //lowbar
				addSequential(new AutonDrive (0.2, -0.2, 2.0)); //test for time and speed for turning
				break; 
			case 2: //turn right if goal not found
				addSequential(new AutonDrive (0.3, -0.3, 3.0)); //change time after practicing
				break;
			case 3: //probably turn right
				addSequential(new AutonDrive (0.2, -0.2, 1.0)); //test for time and speed for turning
				break;
			case 4: //probably turn left
				addSequential(new AutonDrive (-0.2, 0.2, 1.0)); //test for time and speed for turning
				break;
			case 5: //turn left
				addSequential(new AutonDrive (0.2, -0.2, 1.5)); //test for time and speed for turning
				break;
			default:
				addSequential(new AutonDrive (0.2, -0.2, 2.0)); //test for time and speed for turning
				break;
		}

		addSequential(new ToggleRoller()); //move roller up*/
		addSequential(new ToggleCannon()); //move cannon up
		addSequential(new SquareUp());
		//input distance fixing command
		addSequential(new Shoot(1.0)); //shoot into high goal
		Timer.delay(1.0);
		RobotMap.turningCam = true; //turns cam after one second
		addSequential(new StopCannon());
		
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

