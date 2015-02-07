package org.usfirst.frc.team4266.robot.subsystems;

import org.usfirst.frc.team4266.robot.RobotMap;
import org.usfirst.frc.team4266.robot.commands.DriveWithSticks;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

	RobotDrive drive;
	
	
    double powerLevel;
    double turnPower;
    double forwardPower;
    
    double distance;
    
    int count = 0;
    double right=0,left=0;

    Encoder rightEncoder = new Encoder(RobotMap.rightEncoder1,RobotMap.rightEncoder2,true,CounterBase.EncodingType.k4X);
    Encoder leftEncoder = new Encoder(RobotMap.leftEncoder1,RobotMap.leftEncoder2,false,CounterBase.EncodingType.k4X);
     
    public DriveTrain(){
        powerLevel=0.8;
        
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setSensitivity(0.5);
        drive.setMaxOutput(1.0);
        
        rightEncoder.setDistancePerPulse(6*Math.PI/360);
        rightEncoder.reset();
        
        leftEncoder.setDistancePerPulse(6*Math.PI/360);
        leftEncoder.reset();
        
      
    }
    
  
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithSticks());
    }
    public void changePower(double x){
        powerLevel+=x;
        setPower(powerLevel);
    }
    public void showEncoders(){
        System.out.println("ENCODERS " + leftEncoder.getDistance() + " " +rightEncoder.getDistance());
    }
    
    public void resetEncoders(){        
        rightEncoder.reset();
        leftEncoder.reset();       
    }
    
     public void setPower(double pl){
        if(powerLevel>1){
            powerLevel = 1;
        }
        else if(powerLevel < -1){
            powerLevel = -1;
        }
        else{
            powerLevel = pl;
        }       
    }
     public double getPower(){
        return powerLevel;
    }
     
     public double getEncoderDistance(){
         return (rightEncoder.getDistance()+leftEncoder.getDistance())/2.0;
     }
    public void arcadeDrive(Joystick right){
        distance = getEncoderDistance();
       
        forwardPower = powerLevel * right.getY();
        turnPower= Math.abs(0.8*powerLevel)*right.getX(); //Turn power is 80% of powerLevel
        
        this.right = rightEncoder.getDistance();
        this.left = leftEncoder.getDistance();
 
        drive.arcadeDrive(-forwardPower,-turnPower);
    }
    public void autoDrive(double power){
        
        distance = getEncoderDistance();
        
        right = rightEncoder.getDistance();
        left = leftEncoder.getDistance();

        count++;
        drive.drive(power,0);
        
       
    }
    public void updateStatus(){
    	SmartDashboard.putNumber("DrivePower", powerLevel);
    	
    	//Encoder distances
        SmartDashboard.putNumber("Distance: ", distance);
        SmartDashboard.putNumber("Right Distance: ", right);
        SmartDashboard.putNumber("Left Distance: ", left);
        
        
        
    }
    public double getDistance(){
        return distance;
    }
    public void stopDrive(){
    	drive.tankDrive(0, 0);
    }
    
    public Encoder getLeftEncoder(){
    	return leftEncoder;
    }
    public Encoder getRightEncoder(){
    	return rightEncoder;
    }
}

