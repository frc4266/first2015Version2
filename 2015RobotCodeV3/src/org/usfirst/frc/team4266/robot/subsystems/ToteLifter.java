package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.RobotMap;
import org.usfirst.frc.team4266.robot.commands.ToteLifterToTop;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToteLifter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	
	public ToteLifter(){
		if(Robot.isSensorsReady){
			// Sensors 
			upperLimitSwitch = new DigitalInput(RobotMap.toteLifterUpperSwitch);
			lowerLimitSwitch = new DigitalInput(RobotMap.toteLifterLowerSwitch);
			
			// Put everything to the LiveWindow for testing.
			LiveWindow.addSensor("ToteLifter", "Upper Limit Switch", upperLimitSwitch);
			LiveWindow.addSensor("ToteLifter", "Lower Limit Switch", lowerLimitSwitch);
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ToteLifterToTop());
    }
    
    public void raise(){
    	
    }
    public void lower(){
    	
    }
	public void stop(){
	
	}
	
	public void drive(double power){
		//motor.set(power);
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
			SmartDashboard.putBoolean("Tote Upper Switch", isAtUpperLimit());
			SmartDashboard.putBoolean("Tote Lower Switch", isAtLowerLimit());
		}
	}
}

