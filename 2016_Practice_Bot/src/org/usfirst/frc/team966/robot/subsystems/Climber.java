package org.usfirst.frc.team966.robot.subsystems;

//import org.usfirst.frc.team966.robot.commands.ClimberRotate;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Climber extends Subsystem {
//	private CANTalon leftExtention, leftRotate;
	private Talon rightExtention, rightRotate;
//    private Encoder climberEncoderExtention, climberEncoderPivot;
//    private DoubleSolenoid climberShifter;
    
    public Climber() {
//    	leftExtention = new CANTalon(5);
//    	leftRotate = new CANTalon(6);
    	rightExtention = new Talon(2);
    	rightRotate = new Talon(3);
//    	climberEncoderExtention = new Encoder(6, 7);
//    	climberEncoderPivot = new Encoder(4, 5);
//    	leftExtention.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//    	leftRotate.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	//leftRotate.getEncPosition(); gives encoder count.
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void climberUp(){
    	climberMove(1);
    }
    public void climberDown(){
    	climberMove(-1);
    }
    public void climberMove(double speed){
//    	leftExtention.set(speed);
    	rightExtention.set(speed);
    }
/*    public boolean climberToExtended(){
    	if(leftExtention.getEncPosition() < 1000){//1000 should be the upright encoder value
    		climberMove(1);
    		return false;
    	}
    	else{
    		climberMove(0);
    		return true;
    	}
    }
    public boolean climberToRetracted(){
    	if(leftExtention.getEncPosition() > 0){//0 should be the upright encoder value
    		climberMove(-1);
    		return false;
    	}
    	else{
    		climberMove(0);
    		return true;
    	}
    }*/
/*    public boolean climberToExtentionPosition(int position){
    	if(leftExtention.getEncPosition() > (position+5)){
    		climberMove(-1);
    		return false;
    	}
    	else if(leftExtention.getEncPosition() < (position-5)){//5 is a deadband
    		climberMove(1);
    		return false;
    	}
    	else{
    		climberMove(0);
    		return true;
    	}
    }*/
  //Rotation***********************************************************************************
    public void climberRotate(double power){
//    	leftRotate.set(power);
    	rightRotate.set(power);
    }
    public void climberRotateUp(){
    	climberRotate(1);
    }
    public void climberRotateDown(){
    	climberRotate(-1);
    }
/*    public boolean climberToUpPosition(){
    	if(leftRotate.getEncPosition() < 1000){//1000 should be the upright encoder value
    		climberRotate(1);
    		return false;
    	}
    	else{
    		climberRotate(0);
    		return true;
    	}
    }*/
/*    public boolean climberToRotatePosition(int position){
    	if(leftRotate.getEncPosition() > (position+5)){
    		climberMove(-1);
    		return false;
    	}
    	else if(leftRotate.getEncPosition() < (position-5)){//5 is a deadband
    		climberRotate(1);
    		return false;
    	}
    	else{
    		climberRotate(0);
    		return true;
    	}
    }
   */ 
    
    public void initDefaultCommand() {
 //       setDefaultCommand(new ClimberRotate());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void log(){
//    	SmartDashboard.putNumber("Climber Speed", motor1.get());
//    	SmartDashboard.putString("Climber Shifter", climberShifter.get());

    }
}

