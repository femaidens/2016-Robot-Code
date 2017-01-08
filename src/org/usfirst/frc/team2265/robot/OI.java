package org.usfirst.frc.team2265.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2265.robot.commands.RollerDown;
import org.usfirst.frc.team2265.robot.commands.RollerUp;
import org.usfirst.frc.team2265.robot.commands.ToggleMode;
import org.usfirst.frc.team2265.robot.commands.TurnCam;
import org.usfirst.frc.team2265.robot.commands.Acquire;
import org.usfirst.frc.team2265.robot.commands.Shoot;
import org.usfirst.frc.team2265.robot.commands.StopCannon;
import org.usfirst.frc.team2265.robot.commands.ToggleCannon;

public class OI {
    
	//Initializes joysticks
	public static Joystick atkJoy = new Joystick(RobotMap.atkJoyPort);
	public static Joystick rightJoy= new Joystick(RobotMap.rightJoyPort); 
	public static Joystick leftJoy = new Joystick(RobotMap.leftJoyPort);

	//Initializes buttons
	public static Button toggleMode = new JoystickButton(atkJoy, 3); 
	public static Button shoot = new JoystickButton(atkJoy, 1); //atk joystick a
	public static Button toggleCannonPos = new JoystickButton(atkJoy, 4); //button y
	public static Button acquire = new JoystickButton(atkJoy, 2); //atk joystick b
	public static Button turnCam = new JoystickButton(atkJoy, 7); // back button 
	public static Button rollerUp = new JoystickButton (atkJoy, 6); //Right
	public static Button rollerDown = new JoystickButton (atkJoy, 5); //Left

	//Links button to command
	public void bindButtons() {
		toggleMode.whenPressed(new ToggleMode());
		shoot.whileHeld(new Shoot(0.65));
		shoot.whenReleased(new StopCannon());
		toggleCannonPos.whenPressed(new ToggleCannon());
		acquire.whileHeld(new Acquire());
		acquire.whenReleased(new StopCannon());
		turnCam.whenPressed(new TurnCam()); 
		turnCam.whenReleased(new StopCannon());
		rollerUp.whenPressed(new RollerUp());
		rollerDown.whenPressed(new RollerDown());
		
		System.out.println("Buttons bound.");
	}
}

