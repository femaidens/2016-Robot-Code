package org.usfirst.frc.team2265.robot.subsystems;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;

/**
 *
 */
public class Camera extends Subsystem {
	NetworkTable table;
	double[] defaultVals; 
	double goalArea = 22.65; 

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Camera() {
    	table = NetworkTable.getTable("GRIP");
    	defaultVals= new double[1]; 
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//key is a String--I think it's the name of the table
    }
    
    public int shake(){
    	double[] area = table.getNumberArray("FirstReport/area", defaultVals); 
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
}

    
  //in another method(s):
	//table.getValue("some parameter--to be determined", values);
	
