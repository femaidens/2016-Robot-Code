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
	ArrayList<Object> values = new ArrayList<Object>();
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Camera() {
    	table = NetworkTable.getTable("");
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//key is a String--I think it's the name of the table
    }
    
    public void autonCamera(){
    	try{
    		table.getValue("BLOB_COUNT", values);
    		
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void teleopCamera(){
    	try{ 	
    		/* 2 is the default value--blob count will be set to 2 if it is null
    		 * NOTE: whether or not blob count = 2 is a good indicator of whether we're having 
    		 * communication issues */
    		table.getValue("BLOB_COUNT", 2);
    		//table.putValue("BLOB_COUNT",  values); 
    		System.out.println(values.get(0)); 
    		//values.add(); 
    		//System.out.println(values.get(0));
    		SmartDashboard.putData("BLECH", (Sendable) values.get(0));  
    		
    	}
    	catch (IllegalArgumentException e){
    		System.out.println("getValue has issues");
    		SmartDashboard.putNumber("getvalue has issues",  0.0);
    		
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	} 
    }
}

    
  //in another method(s):
	//table.getValue("some parameter--to be determined", values);
	
