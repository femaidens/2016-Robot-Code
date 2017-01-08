package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2265.robot.commands.LowBarAuton;
import org.usfirst.frc.team2265.robot.commands.RWRTAuton;
import org.usfirst.frc.team2265.robot.subsystems.Camera;
import org.usfirst.frc.team2265.robot.subsystems.Cannon;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//declares robot objects
	public static OI oi;
	public static Drivetrain driveTrain;  
	public static Cannon cannon;
    public static CommandGroup autonomousCommand;
    public static Compressor compressy; 
    public static CameraServer cammy; 
	
    //initializes robot objects
    public void robotInit() {
		oi = new OI();
		cannon = new Cannon(); 
        compressy= new Compressor(); 
        driveTrain= new Drivetrain();
        compressy.start(); 
        oi.bindButtons();
        
        /*cammy = CameraServer.getInstance();
        cammy.setQuality(50); 
        cammy.startAutomaticCapture("cam0"); */
        
        //Switches between autonomous commands (uncomment and recomment)
        autonomousCommand = (CommandGroup) new LowBarAuton(); //low bar
        //autonomousCommand = (CommandGroup) new RWRTAuton(); //rock wall/rough terrain
        driveTrain.shiftToSpeed();
    }
	
    public void disabledInit(){}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	//initializes objects for autonomous
    public void autonomousInit() {
    	if (Robot.driveTrain.get().equals(Value.kForward)|| Robot.driveTrain.get().equals(Value.kOff))
    		SmartDashboard.putString("DB/String 0", "Mode: Power Mode");
    	
    	if(Robot.driveTrain.get().equals(Value.kReverse))
    		SmartDashboard.putString("DB/String 0", "Mode: Speed Mode");
    	
    	if(autonomousCommand != null) 
    		autonomousCommand.start();
    }
 
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) 
        	autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        compressy.start(); 
        driveTrain.drive();  
        driveTrain.toString(); 
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
