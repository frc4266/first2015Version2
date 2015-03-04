package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.RobotMap;
import org.usfirst.frc.team4266.robot.commands.CanLifterDoNothing;
import org.usfirst.frc.team4266.robot.commands.CanLifterToTop;


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
public class CanLifter extends Subsystem {//PIDSubsystem {
	
    
	// Subsystem devices
	
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	//Encoder canEncoder = new Encoder(RobotMap.rightEncoder1,RobotMap.rightEncoder2,true,CounterBase.EncodingType.k4X);
	Talon canTalon;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		
	public CanLifter(){
		//super("CanLifter", 0, 0, 0);
		//setAbsoluteTolerance(0.005);
		//getPIDController().setContinuous(false);
		
		//enable/disable PID
		//this.disable();;
		
		canTalon = new Talon(RobotMap.canLifter);
		canTalon.setSafetyEnabled(false);
		
		// Sensors for measuring the position of the pivot.
		if(Robot.isSensorsReady){
			upperLimitSwitch = new DigitalInput(RobotMap.canLifterUpperSwitch);
			lowerLimitSwitch = new DigitalInput(RobotMap.canLifterLowerSwitch);
		
		// Put everything to the LiveWindow for testing.
			LiveWindow.addActuator("CanLifter", "Motor", (Talon) canTalon);
			LiveWindow.addSensor("CanLifter", "Upper Limit Switch", upperLimitSwitch);			
			LiveWindow.addSensor("CanLifter", "Lower Limit Switch", lowerLimitSwitch);
			//LiveWindow.addSensor("CanLifter", "Encoder", canEncoder);
			//LiveWindow.addActuator("CanLifter", "PIDSubsystem Controller", getPIDController());
		}
		//canEncoder.setDistancePerPulse(6*Math.PI/360);
	}
	
    public void lifterControl(Joystick joy){
        double power = joy.getY();

        /*
        if(power>0){
           lifterMotor.set(power*.9);
        }else if(power<0){
           lifterMotor.set(power*.4);   
        }else{
            lifterMotor.set(power*.6);  
        }*/
        
    }
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CanLifterDoNothing());
    }
    
    public void raise(double power){
    	canTalon.set(power);
	 }
	 public void lower(double power){
		 canTalon.set(power);
	 }
	 public void stop(){
		 canTalon.set(0);
	 }
    
    public boolean isAtUpperLimit() {
    	if(Robot.isSensorsReady){
    		return upperLimitSwitch.get(); // TODO: inverted from real robot (prefix with !)
    	}
    	return true;
	}

	/**
	 * @return If the pivot is at its lower limit.
	 */
	public boolean isAtLowerLimit() {
		if(Robot.isSensorsReady){
			return lowerLimitSwitch.get(); // TODO: inverted from real robot (prefix with !)
		}
		return true;
	}
	
	public void updateStatus(){
		if(Robot.isSensorsReady){
			SmartDashboard.putBoolean("Can Upper Switch", isAtUpperLimit());
			SmartDashboard.putBoolean("Can Lower Switch", isAtLowerLimit());
		}
	}
/*
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return canEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		canTalon.pidWrite(output);
	}*/
}

