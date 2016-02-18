package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutonCurveHigh extends CommandGroup {
    
    public  LowBarAutonCurveHigh() {
    	Timer timer = new Timer();
    	timer.reset();
    	timer.start(); 
    //	while (timer.get() < 0.5) {
    		new AutonDrive (-1.0,-1.0, 0.5);
    //	}
    	//while(timer.get() < 5.5){
    		addSequential(new AutonDrive(0.5,0.5, 5.5));
    //	}
    	addSequential(new ShiftToPower());
    	//addSequential(new CurveHigh());
    	Timer.delay(3.0);
    	//addSequential(new StopCannon());

    	timer.stop();
    	
    	
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
