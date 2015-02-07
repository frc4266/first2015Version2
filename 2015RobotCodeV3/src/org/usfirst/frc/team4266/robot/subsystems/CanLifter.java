package org.usfirst.frc.team4266.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class CanLifter extends Subsystem {
	
    
	// Subsystem devices
	private DigitalInput upperLimitSwitch;
	private DigitalInput lowerLimitSwitch;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		
	public CanLifter(){
		// Sensors for measuring the position of the pivot.
		upperLimitSwitch = new DigitalInput(13);
		lowerLimitSwitch = new DigitalInput(12);
		
		// Put everything to the LiveWindow for testing.
		LiveWindow.addSensor("Pivot", "Upper Limit Switch", upperLimitSwitch);
		LiveWindow.addSensor("Pivot", "Lower Limit Switch", lowerLimitSwitch);
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

