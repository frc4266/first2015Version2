package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.RobotMap;
import org.usfirst.frc.team4266.robot.commands.CanLifterToTop;
import org.usfirst.frc.team4266.robot.commands.ToteLifterToTop;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CanLifter extends Subsystem {
	
    
	// Subsystem devices
	
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	Talon canTalon;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		
	public CanLifter(){
		
		canTalon = new Talon(RobotMap.scissorLifter);
		canTalon.setSafetyEnabled(false);
		
		// Sensors for measuring the position of the pivot.
		if(Robot.isSensorsReady){
			upperLimitSwitch = new DigitalInput(RobotMap.canLifterUpperSwitch);
			lowerLimitSwitch = new DigitalInput(RobotMap.canLifterLowerSwitch);
		
		// Put everything to the LiveWindow for testing.
			LiveWindow.addActuator("ScissorLifter", "Motor", (Talon) canTalon);
			LiveWindow.addSensor("CanLifter", "Upper Limit Switch", upperLimitSwitch);			
			LiveWindow.addSensor("CanLifter", "Lower Limit Switch", lowerLimitSwitch);
		}
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
    	//setDefaultCommand(new CanLifterToTop());
    }
    
    public void raise(){
    	canTalon.set(1);
	 }
	 public void lower(){
		 canTalon.set(-1);
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
}

