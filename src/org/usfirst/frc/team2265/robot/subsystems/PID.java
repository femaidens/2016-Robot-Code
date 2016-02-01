package org.usfirst.frc.team2265.robot.subsystems;
import org.usfirst.frc.team2265.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.CANTalon;

public class PID extends PIDSubsystem {
	
	double wheelVelocity = 0.475;
	public static Encoder encLeft = new Encoder(0,1);
	public static Encoder encRight = new Encoder(2,3);
	
	public static CANTalon cannonFL = new CANTalon(0,0);
	public static CANTalon cannonFR = new CANTalon(0,1);
	public static CANTalon roller = new CANTalon(0,2);
	
	public static final int kMaxNumberOfMotors =2;
	private static final double Kd = 0.5;
	private static final double Kp = 0.0;
	private static final double Ki = 0.0;
		private static PIDController PIDCannonFL = new PIDController(Kp, Ki, Kd, encLeft, cannonFL); 
		private static PIDController PIDCannonFR = new PIDController(Kp, Ki, Kd, encRight, cannonFR);
		//initializes PIDControllers
		
	public PID() {
		super("PID", 0.3, 0.0, 0.0); 
	}
		protected void setSetVelocity(){
		encLeft.setDistancePerPulse(0.475);
		encRight.setDistancePerPulse(0.475);
		//set the distance the encoder moves every time
	} 
	//set the velocity
	
	public boolean onTarget(){
		if(wheelVelocity + 0.1 > 0.485 || wheelVelocity - 0.1<0.465){
			PIDCannonFL.enable();
			PIDCannonFR.enable();
			//enables the PIDControllers
		}// going to compare the actual wheel velocity get from the shooter with the desired velocity
		return true;
	} 
	//Return true if the error is within the percentage of the total input range.
	
	protected static void normalize(double wheelVelocity[]) {
        double maxMagnitude = Math.abs(wheelVelocity[0]);
        int i;
        for (i=1; i<kMaxNumberOfMotors; i++) {
            double temp = Math.abs(wheelVelocity[i]);
            if (maxMagnitude < temp) maxMagnitude = temp;
        }
        if (maxMagnitude > 1.0) {
            for (i=0; i<kMaxNumberOfMotors; i++) {
                wheelVelocity[i] = wheelVelocity[i] / maxMagnitude; //equalizes the wheels speeds
            }
        }
    }
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
		 
		
		
}
