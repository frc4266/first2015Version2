package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.RobotMap;
import org.usfirst.frc.team4266.robot.commands.ToteLifterDoNothing;
import org.usfirst.frc.team4266.robot.commands.ToteLifterMoveWithJoystick;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToteLifter extends PIDSubsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static final double TOP_SETPOINT = 5000;
	public static final double BOTTOM_SETPOINT = 1.47;

	
	Talon toteTalon;
	Encoder toteEncoder = new Encoder(RobotMap.toteEncoder1,RobotMap.toteEncoder2,true,CounterBase.EncodingType.k4X);
	public ToteLifter(){
		super("ToteLifter",300, 0, 0);
		//setAbsoluteTolerance(300);
		getPIDController().setContinuous(false);
		this.setPercentTolerance(10);
		//toteEncoder.setDistancePerPulse(6*Math.PI/360);
		toteEncoder.reset();
		
		
		toteTalon = new Talon(RobotMap.toteLifter);
		toteTalon.setSafetyEnabled(false);
		LiveWindow.addActuator("ToteLifter", "Motor", (Talon) toteTalon);
		//if(Robot.isSensorsReady){
			// Sensors 
			
			
			// Put everything to the LiveWindow for testing.
			
			LiveWindow.addSensor("ToteLifter", "Encoder", toteEncoder);
			LiveWindow.addActuator("ToteLifter", "PIDSubsystem Controller", getPIDController());
		//}
			
			//if Sensor Breaks, enable the next line
			this.disable();
	}
	
    public void initDefaultCommand() {

    	
    	//if Sensor Breaks, enable the next line
    	setDefaultCommand(new ToteLifterMoveWithJoystick());
    }
    
    public void stickDrive(Joystick joy){
        // distance = getEncoderDistance();
        
        double forwardPower = 1 * joy.getY();
         //double turnPower= Math.abs(1*powerLevel)*right.getY(); //Turn power is 80% of powerLevel
         
         //this.right = rightEncoder.getDistance();
         //this.left = leftEncoder.getDistance();
  
         toteTalon.set(forwardPower);
     }
    
    public void raise(){
    	toteTalon.set(1);
    }
    public void lower(){
    	toteTalon.set(-1);
    }
	public void stop(){
		toteTalon.set(0);
	}
	
	public void drive(double power){
		toteTalon.set(power);
		System.out.printf("Encoder " + toteEncoder.get() + " " + toteEncoder.getDistance() );
	}
    
	public void updateStatus(){
		
			
			//SmartDashboard.putNumber("Tote Encoder", toteEncoder.get());
	
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		System.out.println(toteEncoder.get());
		return toteEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		toteTalon.pidWrite(output);
		
	}
}

