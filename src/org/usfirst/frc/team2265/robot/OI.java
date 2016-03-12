package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2265.robot.commands.Collision;
import org.usfirst.frc.team2265.robot.commands.Drive;
import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
import org.usfirst.frc.team2265.robot.commands.ReverseCam;
import org.usfirst.frc.team2265.robot.commands.RollerDown;
import org.usfirst.frc.team2265.robot.commands.RollerUp;
import org.usfirst.frc.team2265.robot.commands.ToggleMode;
import org.usfirst.frc.team2265.robot.commands.TurnCam;
import org.usfirst.frc.team2265.robot.commands.Acquire;
import org.usfirst.frc.team2265.robot.commands.Curve;
//import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
import org.usfirst.frc.team2265.robot.commands.ToggleRoller;
import org.usfirst.frc.team2265.robot.commands.Shoot;
import org.usfirst.frc.team2265.robot.commands.StopCannon;
import org.usfirst.frc.team2265.robot.commands.ToggleCannon;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
import org.usfirst.frc.team2265.robot.subsystems.*;
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public static Joystick atkJoy = new Joystick(RobotMap.atkJoyPort);
	public static Joystick rightJoy= new Joystick(RobotMap.rightJoyPort); 
	public static Joystick leftJoy = new Joystick(RobotMap.leftJoyPort);
	
	public static Button toggleMode = new JoystickButton(rightJoy, 3);
	public static Button collision = new JoystickButton(atkJoy,8);
	Button shoot = new JoystickButton(atkJoy, 1); //button a
	Button toggleCannonPos = new JoystickButton(atkJoy, 4); //button y
	Button acquire = new JoystickButton(atkJoy, 2); //button b
	//Button toggleRoller = new JoystickButton(atkJoy, 3);// button x
	public Button turnCam = new JoystickButton(atkJoy, 7); // back button. 
	Button reverseCam = new JoystickButton(atkJoy, 8); // Start Button
	Button rollerUp = new JoystickButton (atkJoy, 5); //Right
	Button rollerDown = new JoystickButton (atkJoy, 6); //Right
	
	
	
	//Button curveLeft = new JoystickButton(atkJoy, 5);
	//Button curveRight = new JoystickButton(atkJoy,6);
	
	public void bindButtons() {
		toggleMode.whenPressed(new ToggleMode());
		collision.whenPressed(new Collision());
		shoot.whileHeld(new Shoot(1.0));
		shoot.whenReleased(new StopCannon());
		toggleCannonPos.whenPressed(new ToggleCannon());
		acquire.whileHeld(new Acquire());
		acquire.whenReleased(new StopCannon());
		//toggleRoller.whenPressed(new ToggleRoller());
		turnCam.whenPressed(new TurnCam()); 
		turnCam.whenReleased(new StopCannon());
		reverseCam.whenPressed(new ReverseCam()); 
		reverseCam.whenReleased(new StopCannon());
		rollerUp.whenPressed(new RollerUp());
		rollerDown.whenPressed(new RollerDown());
		
		//curveLeft.whenPressed(new Curve(false));
		//curveRight.whenPressed(new Curve(true));
		System.out.println("Buttons bound");
		
	}
}

