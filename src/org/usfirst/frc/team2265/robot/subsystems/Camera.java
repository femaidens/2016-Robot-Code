package org.usfirst.frc.team2265.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.ArrayList;

/**
 *
 */
public class Camera extends Subsystem {
	NetworkTable table;
	ArrayList<Double> values = new ArrayList<Double>();
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Camera() {
    	table = NetworkTable.getTable("SmartDashboard");
    }
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//key is a String--I think it's the name of the table
    }
    
    public void autonCamera(){
    	try{
    		table.getValue("some parameter--to be determined", values);
    		
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void teleopCamera(){
    	//try{ 	
    		values.add((Double) table.getValue("BLOB_COUNT", 2));
    		System.out.println(values.get(0)); 
    		//values.add(); 
    		//System.out.println(values.get(0));
    		SmartDashboard.putNumber("BLECH", values.get(0));  
    		
    	}
    	/*catch (IllegalArgumentException e){
    		System.out.println("getValue has issues");
    		SmartDashboard.putNumber("getvalue has issues",  0.0);
    		
    	}*/
    	/*catch (Exception e){
    		e.printStackTrace();
    	} */
    }

    
  //in another method(s):
	//table.getValue("some parameter--to be determined", values);
	
