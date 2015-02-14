package org.usfirst.frc.team4266.robot.subsystems;



import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Conveyor extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 DigitalInput toteSensor;
	 Jaguar conveyorMotor;
	 
	 public Conveyor(){
		 conveyorMotor = new Jaguar(RobotMap.conveyor);
		 
		
		 if(Robot.isSensorsReady){
			 toteSensor = new DigitalInput(RobotMap.conveyorSwitch);				
			// Put everything to the LiveWindow for testing.
			LiveWindow.addSensor("Conveyor", "Tote Limit Switch", toteSensor);
		 }

	 }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    
    public boolean hasTote(){
    	if(Robot.isSensorsReady){
    		return toteSensor.get();
    	}
    	return true;
    }
    
    
    public void onToUnloadTote(){
    	
    }
    
    public void onToLoadTote(){
    	
    }
    
    public void drive(double power){
    	conveyorMotor.set(power);
    }
    
    public void stop(){
    	conveyorMotor.set(0);
    	
    }
    
    public void updateStatus(){
    	SmartDashboard.putBoolean("Conveyor Sensor", hasTote());
    	
    }
    
   
    
   
}

