package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CanClaw extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon clawTalon;
	
	public CanClaw(){
		clawTalon = new Talon(RobotMap.canClaw);
		clawTalon.setSafetyEnabled(false);
		LiveWindow.addActuator("CanClaw", "Motor", (Talon) clawTalon);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void open(double power){
    	clawTalon.set(power);
    }
    public void close(double power){
    	clawTalon.set(power);
    }
    public void stop(){
    	clawTalon.set(0);
    }
    
    public void updateStatus(){
		//SmartDashboard.putBoolean("Can Upper Switch", isAtUpperLimit());
		
	}
}

