package org.usfirst.frc.team4266.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ToteLifter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	
	public ToteLifter(){
		// Sensors for measuring the position of the pivot.
		upperLimitSwitch = new DigitalInput(13);
		lowerLimitSwitch = new DigitalInput(12);
		
		// Put everything to the LiveWindow for testing.
		LiveWindow.addSensor("ToteLifter", "Upper Limit Switch", upperLimitSwitch);
		LiveWindow.addSensor("ToteLifter", "Lower Limit Switch", lowerLimitSwitch);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public boolean isAtUpperLimit() {
		return upperLimitSwitch.get(); // TODO: inverted from real robot (prefix with !)
	}

	/**
	 * @return If the pivot is at its lower limit.
	 */
	public boolean isAtLowerLimit() {
		return lowerLimitSwitch.get(); // TODO: inverted from real robot (prefix with !)
	}
}

