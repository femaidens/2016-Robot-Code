package org.usfirst.frc.team2265.robot.subsystems;

import com.ctre.CANTalon;
//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;

import org.usfirst.frc.team2265.robot.Robot;

/**
 *
 */
public class Camera extends Subsystem {
	NetworkTable table;
	double defaultVals = 0.0; 
	double[] defVal = {0.0};
	double goalArea = 22.65; 
	RobotDrive testDrive; 
	Joystick testLeft, testRight;
	public static CANTalon fl, fr, rl, rr;  

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Camera() {
    	table = NetworkTable.getTable("");
    	fl = new CANTalon(1);
    	fr = new CANTalon (13);
    	rl = new CANTalon(2);
    	rr = new CANTalon(12);
    	testDrive = new RobotDrive(fl,rl,fr,rr);
    	testLeft = new Joystick(0);
    	testRight = new Joystick(1);
    	
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//key is a String--I think it's the name of the table
    }
    public void printOffCenter(){
    	double imgWidth= (table.getNumber("IMAGE_WIDTH", defaultVals) / 2); 
    	double cogX = table.getNumber("COG_X", defaultVals); 
    	double difference = cogX - imgWidth;
    	SmartDashboard.putNumber("Off Center By: ", difference );
    }
    public boolean centering() {
    //	double imgHeight = table.getNumber("IMAGE_HEIGHT", defaultVals) / 2;
    	double imgWidth= (table.getNumber("IMAGE_WIDTH", defaultVals) / 2); 
    	double cogX = table.getNumber("COG_X", defaultVals); 
    	double difference = cogX - imgWidth + 20;
    	/*double largest= 0.0;
    	for (int i = 0 ; i < areas.length; i++){
    		if (areas[i] > areas[i-1] && areas.length >1)
    			largest = areas[i];
    		else if (areas.length == 1)
    			largest = areas[i]; 
    	}
    	SmartDashboard.putNumber("Area: ", largest);*/
    	SmartDashboard.putNumber("Off Center By: ", difference );
    	
    	/*if(difference >= -5.0 && difference <= 5.0) { 
    		testDrive(0.0, 0.0);  
    		return true;
    	}*/
    	/*Instead of using an if and running the method multiple times, the method loops until it 
    	 centers the robot. If statement method is above. */
    	while (!(difference >= -5.0 && difference <= 5.0)){
    	if(difference <-5.0){
    		testDrive(0.2,0.05);
    	}
    	if(difference > 5.0)
    		testDrive(0.05, 0.2);
    	}
    	return false;
    }
	public int shake(){
    	double[] area = table.getNumberArray("FirstReport/area", defVal); 
    	double originalArea = area[0];
    	if (originalArea >= goalArea*.95 && originalArea <= goalArea*1.05){
    		return 0;
    	}
    	if(originalArea <= goalArea*0.95 && originalArea >= goalArea* 1.05) {
    		return 1; 
    	}
    	return -1; 
    }
    
    public void teleopCamera(){
    }
    
    public void testDrive() {
    	double left = -testLeft.getY();
    	double right = -testRight.getY();
    	left = Math.pow(left,3.0);
    	right = Math.pow(right, 3.0);
    	testDrive.tankDrive(left, right);
    }
    
    public void testDrive(double x, double y){
    	testDrive.tankDrive(Math.pow(x, 3.0) , Math.pow(y, 3.0));
 
    }
}

    
  //in another method(s):
	//table.getValue("some parameter--to be determined", values);
	
