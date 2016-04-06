package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.commands.ClimberRotate;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
	private CANTalon leftExtention, rightExtention;
	private Talon leftRotate, rightRotate;
//	private CANTalon leftExtention, leftRotate;
	private boolean leftExtentionGood, rightExtentionGood;
	//    private Encoder climberEncoderExtention, climberEncoderPivot;
//    private DoubleSolenoid climberShifter;
    
    public Climber() {
    	leftExtentionGood = false;
    	rightExtentionGood = false;
    	leftExtention  = new CANTalon(5);
    	rightExtention = new CANTalon(6);
//    	rightExtention = new Talon(2);

//    	leftRotate = new CANTalon(6);
    	leftRotate  = new Talon(2);
    	rightRotate = new Talon(3);
    	leftExtention.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	rightExtention.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
 //   	leftRotate.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
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
    	leftExtention.set(-speed);
    	rightExtention.set(speed);
    }
    public void climberMoveSeperate(double left, double right){
    	leftExtention.set(-left);
    	rightExtention.set(right);
    }
    public void climberMoveLeft(double left){
    	leftExtention.set(-left);
    }
    public void climberMoveRight(double right){
    	rightExtention.set(right);
    }
    
    public boolean climberToExtended(){
    	
    	int done = 0;
    	if(leftExtention.getEncPosition() > 1000){//1000 should be the upright encoder value
    		climberMoveSeperate(0, .5);
    		done = done+1;
    	}
    	if(rightExtention.getEncPosition() > 1000){
    		climberMoveSeperate(.5, 0);
    		
    	}
    	else{
    		climberMove(0);
    		return true;
    	}
    	if(done > 2){
    		return true;
    	}
    	else{
    		return false;
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
    }
    public boolean climberToExtentionPosition(int position){
    	if(leftExtention.getEncPosition() > (position+50)){
    		climberMoveLeft(-1);
    	}
    	else if(leftExtention.getEncPosition() < (position-50)){//50 is a deadband
    		climberMoveLeft(1);
    	}
    	else{
    		climberMoveLeft(0);
    		leftExtentionGood = true;
    	}
    	if(rightExtention.getEncPosition() > (position+50)){
    		climberMoveRight(-1);
    	}
    	else if(rightExtention.getEncPosition() < (position-50)){//50 is a deadband
    		climberMoveRight(1);
    	}
    	else{
    		climberMoveRight(0);
    		rightExtentionGood = true;
    	}
    	if(leftExtentionGood && rightExtentionGood){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
  //Rotation***********************************************************************************
    public void climberRotate(double power){
    	leftRotate.set(power);
    	rightRotate.set(power);
    }
    public void climberRotateSeperate(double left, double right){
    	leftRotate.set(left*.75);
    	rightRotate.set(right*.75);
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
    public boolean climberToRotatePosition(int position){
//    	if(leftRotate.getEncPosition() > (position+5)){
//    		climberMove(-1);
//    		return false;
//    	}
//    	else if(leftRotate.getEncPosition() < (position-5)){//5 is a deadband
//    		climberRotate(1);
//    		return false;
//    	}
//    	else{
//    		climberRotate(0);
    		return true;
//    	}
    }
    
    
    public void initDefaultCommand() {
        setDefaultCommand(new ClimberRotate());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void log(){
    	SmartDashboard.putNumber("LeftExtentionCount", leftExtention.getEncPosition());
    	SmartDashboard.putNumber("RightExtentionCount", rightExtention.getEncPosition());
    	
//    	SmartDashboard.putNumber("Climber Speed", motor1.get());
//    	SmartDashboard.putString("Climber Shifter", climberShifter.get());
    }
}