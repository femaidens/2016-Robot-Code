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

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	table = NetworkTable.getTable("SmartDashboard"); //key is a String--I think it's the name of the table
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
    		table.getValue("BLOB_COUNT", values); // Gets value from Roborealm to NetworkTable. 
    		table.putValue("BLOB_COUNT", values); 
    		//table.getNumber("BLOB_COUNT", values.get(0)); 
    		table.putNumber("Blob Count: ", values.get(0)); // Puts value from Roborealm on NetworkTable to view in Outline Viewer. 
    		SmartDashboard.putNumber("Blob Count: ", values.get(0)); // Displays Blob count value on SmartDashboard. 
    		
    	/*}
    	catch(Exception e){
    		e.printStackTrace();
    	} */
    }
    
  //in another method(s):
	//table.getValue("some parameter--to be determined", values);
	
}