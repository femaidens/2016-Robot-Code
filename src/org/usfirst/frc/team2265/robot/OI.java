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
    
	public static Joystick atkJoy = new Joystick(RobotMap.atkJoyPort);
	public static Joystick rightJoy= new Joystick(RobotMap.rightJoyPort); 
	public static Joystick leftJoy = new Joystick(RobotMap.leftJoyPort);

	public static Button toggleMode = new JoystickButton(rightJoy, 3); 
	public static Button shoot = new JoystickButton(rightJoy, 4); //Right joystick 4
	public static Button toggleCannonPos = new JoystickButton(atkJoy, 4); //button y
	public static Button acquire = new JoystickButton(leftJoy, 3); //Left joystick 3
	public static Button turnCam = new JoystickButton(rightJoy, 1); // Right trigger. 
	public static Button rollerUp = new JoystickButton (atkJoy, 6); //Right
	public static Button rollerDown = new JoystickButton (atkJoy, 5); //Left

	public void bindButtons() {
		toggleMode.whenPressed(new ToggleMode());
		shoot.whileHeld(new Shoot(.75));
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

