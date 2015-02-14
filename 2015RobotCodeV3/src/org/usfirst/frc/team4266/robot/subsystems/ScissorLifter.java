package org.usfirst.frc.team4266.robot.subsystems;



import org.usfirst.frc.team4266.robot.Robot;
import org.usfirst.frc.team4266.robot.RobotMap;
import org.usfirst.frc.team4266.robot.commands.ScissorLifterDoNothing;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ScissorLifter extends PIDSubsystem{
	
	
	public static boolean isOn = false;
	
	public static  enum ScissorPosition {SCORING,STEP,LOADING};
	ScissorPosition lifterPosition = ScissorPosition.LOADING;


	
	public static final double LOAD_SETPOINT = 1; //0.013
	public static final double SCORING_SETPOINT = 2; //1.47
	public static final double STEP_SETPOINT = 3;
	
	//DigitalInput scoringSensor;
	//DigitalInput stepSensor;
	//DigitalInput loadSensor;
	private Potentiometer pot;
	Talon scissorTalon;
	double power = 0;
	
	public ScissorLifter() {
		super("Pivot", 0, 0, 0);
		setAbsoluteTolerance(0.005);
		getPIDController().setContinuous(false);
		scissorTalon = new Talon(RobotMap.scissorLifter);
		scissorTalon.setSafetyEnabled(false);
		this.disable(); 
		// Sensors for measuring the position of the pivot.
		//if(Robot.isSensorsReady){
			pot = new AnalogPotentiometer(RobotMap.pot);
			//scoringSensor = new DigitalInput(RobotMap.scissorLifterScoringSwitch);
			//stepSensor = new DigitalInput(RobotMap.scissorLifterStepSwitch);
			//loadSensor = new DigitalInput(RobotMap.scissorLifterLoadingSwitch);
			
			// Put everything to the LiveWindow for testing.
			//LiveWindow.addActuator("ScissorLift", "Jaguar", (Jaguar) leftJag);
			LiveWindow.addSensor("ScissorLifter", "Pot",(AnalogPotentiometer) pot);			
			LiveWindow.addActuator("ScissorLifter", "Motor", (Talon) scissorTalon);
			LiveWindow.addActuator("ScissorLifter", "PIDSubsystem Controller", getPIDController());
			///LiveWindow.addSensor("ScissorLifter", "Scoring Limit Switch", scoringSensor);
			//LiveWindow.addSensor("ScissorLifter", "Step Limit Switch", stepSensor);
			//LiveWindow.addSensor("ScissorLifter", "Load Limit Switch", loadSensor);
		//}
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ScissorLifterDoNothing());
    	
    }
    
    public void drive(double power){
    	this.power = power;
    	scissorTalon.set(power);
    }
    
    public ScissorPosition getScissorPosition(){
    	return this.lifterPosition;
    }
    
    public void setPosition(ScissorPosition p){
    	this.lifterPosition = p;
    }
    
    public void stop(){
    	scissorTalon.set(0);
    	
    }
    
    public void lowerLifter(){
    	
    }
    
    public void raiseLifter(){
    	
    }
    public ScissorPosition getPostion(){
    	return lifterPosition;
    }
    /*
    public boolean getScoringSensorValue(){
    	if(Robot.isSensorsReady){
    		return scoringSensor.get();
    	}
    	return true;
    }
    public boolean getStepSensorValue(){
    	if(Robot.isSensorsReady){
    		return stepSensor.get();
    	}
        return true;
    }
    public boolean getLoadSensorValue(){
    	if(Robot.isSensorsReady){
    		return loadSensor.get();
    	}
        return true;
    }
    */

    public void updateStatus(){
    	SmartDashboard.putNumber("Pot", pot.get());
    	SmartDashboard.putNumber("Scissor Power", power);
    	if(Robot.isSensorsReady){
	    	//SmartDashboard.putBoolean("Scissor Lifter Loading", getLoadSensorValue());
	    	//SmartDashboard.putBoolean("Scissor Lifter Step", getStepSensorValue());
	    	//SmartDashboard.putBoolean("Scissor Lifter Scoring", getScoringSensorValue());
    	}
    	
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return pot.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		scissorTalon.pidWrite(output);
		
	}
	
	
}

