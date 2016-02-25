
package org.usfirst.frc.team2265.robot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2265.robot.commands.AutonDrive;
import org.usfirst.frc.team2265.robot.commands.DriveOnlyAuton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import java.io.IOException;
import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
import org.usfirst.frc.team2265.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2265.robot.subsystems.Camera;
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

    Command autonomousCommand;
    SendableChooser chooser;
    Compressor compressy; 

    public static Camera cammy; 
    private final NetworkTable table= NetworkTable.getTable("RoboRealm");
    public static Solenoid ledRing; 


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//      chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        compressy= new Compressor(); 
        driveTrain= new Drivetrain();
        compressy.start(); 
        oi.bindButtons(); 
        autonomousCommand = new DriveOnlyAuton();
        SmartDashboard.putData("Auto mode", chooser); 
        ledRing = new Solenoid(7);
        oi.bindButtons();
        cammy= new Camera(); 
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
        autonomousCommand = (Command) chooser.getSelected();
        ledRing.set(true);

        System.out.println("AUTON" + table.toString());
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
    	if (autonomousCommand != null) autonomousCommand.start();
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
        ledRing.set(true);
        System.out.println("TELEOP:" + table.toString());
        Timer.delay(2.0);
       // cammy.centering(); 
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();  
        //cammy.centering();
        cammy.testDrive();
      // cammy.testDrive();
       /*double defVal= 0.0; 
       double height = table.getNumber("IMAGE_HEIGHT", defVal);
       double blobs= table.getNumber("BLOB_COUNT", defVal); 
       table.containsKey("IMAGE_HEIGHT");
       SmartDashboard.putNumber("Height:", height);
       SmartDashboard.putNumber("Blob Count:", blobs);*/
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
