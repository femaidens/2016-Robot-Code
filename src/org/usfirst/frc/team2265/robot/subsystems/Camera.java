package org.usfirst.frc.team2265.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
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
    	table = NetworkTable.getTable("key"); //key is a String--I think it's the name of the table
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
    	try{
    		table.getValue("some parameter--to be determined", values);
    		
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
  //in another method(s):
	//table.getValue("some parameter--to be determined", values);
	
}