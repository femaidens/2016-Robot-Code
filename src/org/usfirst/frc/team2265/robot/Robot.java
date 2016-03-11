package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2265.robot.commands.AutoZone;
import org.usfirst.frc.team2265.robot.commands.DriveOnlyAuton;
import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
import org.usfirst.frc.team2265.robot.subsystems.Camera;
import org.usfirst.frc.team2265.robot.subsystems.Cannon;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2265.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static Drivetrain driveTrain;  
	public static Cannon cannon;
    CommandGroup autonomousCommand;
    SendableChooser autonChooser, speedChooser;
    public static Compressor compressy; 
    public static Camera cammy;  
	

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        autonChooser = new SendableChooser();
        double s = SmartDashboard.getNumber("Speed", 0.4);
        
        autonChooser.addDefault("Low bar Auto", new AutoZone(1, s));
        autonChooser.addObject("Zone 2 Auton", new AutoZone(2, s)); 
        autonChooser.addObject("Zone 3 Auton", new AutoZone(3, s)); 
        autonChooser.addObject("Zone 4 Auton", new AutoZone(4, s));
        autonChooser.addObject("Zone 5 Auton", new AutoZone(5, s)); 
        
        SmartDashboard.putData("Autonomous Choices: ", autonChooser);
        
        cannon = new Cannon(); 
        compressy= new Compressor(); 
        driveTrain= new Drivetrain();
        compressy.start(); 
        oi.bindButtons();
    
        //cammy = new Camera(); 

        autonomousCommand = (CommandGroup) autonChooser.getSelected();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        
  
    	if(autonomousCommand != null) autonomousCommand.start();
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        	
        	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        driveTrain.drive();  
        driveTrain.toString(); 
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
