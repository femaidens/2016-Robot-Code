package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.commands.ExtendClimber;
import org.usfirst.frc.team2265.robot.commands.LiftRobot;

import edu.wpi.first.wpilibj.Joystick;

/*import org.usfirst.frc.team2265.robot.commands.Acquire;
=======

import org.usfirst.frc.team2265.robot.commands.Collision;
>>>>>>> refs/remotes/origin/Drivetrain
import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
<<<<<<< HEAD
import org.usfirst.frc.team2265.robot.commands.RollerToAcq;
import org.usfirst.frc.team2265.robot.commands.RollerToGate;
import org.usfirst.frc.team2265.robot.commands.RollerToShoot;
import org.usfirst.frc.team2265.robot.commands.Shoot;
import org.usfirst.frc.team2265.robot.commands.StopCannon;
import org.usfirst.frc.team2265.robot.commands.ToggleCannon;*/

import org.usfirst.frc.team2265.robot.commands.ToggleMode;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	Joystick leftJoy = new Joystick(1);
	Joystick rightJoy = new Joystick(2);
	Joystick atkJoy = new Joystick(3);

	//shooting
	Button shoot = new JoystickButton(atkJoy, 1); //button a
	Button toggleCannonPos = new JoystickButton(atkJoy, 4); //button y
	Button acquire = new JoystickButton(atkJoy, 2); //button b
	Button rollerToShoot = new JoystickButton(rightJoy, 1);//right trigger
	Button rollerToAcq = new JoystickButton(rightJoy, 2);//thumb button
	Button rollerToGate = new JoystickButton(leftJoy, 1); //left trigger
	Button aim = new JoystickButton(atkJoy, 3); //button x
	Button curveLeft = new JoystickButton(atkJoy, 5); //left button above trigger
	Button curveRight = new JoystickButton(atkJoy,6); //right button above trigger
	//climbing
	Button extendArm = new JoystickButton(rightJoy, 5); //right button 5
	Button lift = new JoystickButton(rightJoy, 6); //right button 6
	//driving
	Button toPower = new JoystickButton(leftJoy, 3); //left button 3
	Button toSpeed = new JoystickButton(leftJoy, 4); //left button 4
	
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
	public void bindButtons(){
		extendArm.whenPressed(new ExtendClimber());
		lift.whenPressed(new LiftRobot());
		//ADD AT SOME POINT : LOWER, IF NEEDED
			//shooting
			/*shoot.whenPressed(new Shoot(0.4));
			shoot.whenPressed(new StopCannon());
			toggleCannonPos.whenPressed(new ToggleCannon());
			acquire.whileHeld(new Acquire());
			rollerToShoot.whenPressed(new RollerToShoot());
			rollerToAcq.whenPressed(new RollerToAcq());
			rollerToGate.whenPressed(new RollerToGate());
			aim.whenPressed(new Aim());
			curveLeft.whenPressed(new Curve(false));
			curveRight.whenPressed(new Curve(true)); 
			//driving
			toPower.whenPressed(new ShiftToPower());
			toSpeed.whenPressed(new ShiftToSpeed());
			*/
		
			//need to add lift commands/buttons
	}
    
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
	public static Button toggleMode = new JoystickButton(atkJoy, 2);
	public static Button collision = new JoystickButton(atkJoy,11);
	
	public void bindButtons() {
		toggleMode.whenPressed(new ToggleMode());
		collision.whenPressed(new Collision());
		
	}
}

