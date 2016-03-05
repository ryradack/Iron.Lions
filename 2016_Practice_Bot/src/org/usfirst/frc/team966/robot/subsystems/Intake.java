package org.usfirst.frc.team966.robot.subsystems;

import org.usfirst.frc.team966.robot.Robot;
//import org.usfirst.frc.team966.robot.commands.IntakeArmMove;

import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Intake extends Subsystem {
    private Talon armMotor, beltMotor;
//    private DoubleSolenoid puncher;
//    private Encoder armEncoder;
    private AnalogInput armPot;//AnalogPotentiometer armPot;
    public double armSpeed;
    public boolean nitro;
    public boolean PuncherRetracted;
    
    public Intake() {
    	armMotor = new Talon(0);
    	beltMotor = new Talon(1);
//    	puncher = new DoubleSolenoid(0, 0, 1);
//    	armEncoder = new Encoder(2, 3);
    	armPot = new AnalogInput(2);
//    	armPot = new AnalogPotentiometer(2);
    }
    public void beltIn(){
    	beltMotor.set(1);
    }
    public void beltOut(){
    	beltMotor.set(-1);
    }
    public void beltMove(double speed){
    	beltMotor.set(speed);
    }
    public void setArmSpeed(){
    	double deadband = .2;
    	armSpeed = Robot.oi.getXbox2().getRawAxis(1)/3;
    	if(armSpeed < -deadband && armSpeed > deadband){
    		armSpeed = 0;
    	}	
    }
    public void armUp(){
    	armMotor.set(.25);
    }
    public void armDown(){
    	armMotor.set(-.25);
    }
    public void armMove(double speed){
    	armMotor.set(speed);
    }
    public void switchNitro(){
    	nitro = !nitro;
    }
    
    public boolean armToDown(){
    	if(armPot.getVoltage() > .980){//
    		armMotor.set(0);
    		return true;
    	}
    	else{
    		armMotor.set(1);
    		return false;
    	}
    }
    public boolean armToUp(){
    	if(armPot.getVoltage() < .595){//
    		armMotor.set(0);
    		return true;
    	}
    	else{
    		armMotor.set(-1);
    		return false;
    	}
    }
    public boolean armToPosition(int position){
    	if(armPot.getVoltage() > (position+.01)){//
    		armMotor.set(-1);
    		return false;
    	}
    	else if(armPot.getVoltage() < (position-.01)){
    		armMotor.set(1);
    		return false;
    	}
    	else{
    		armMotor.set(0);
    		return true;
    	}
    }
/*    public void puncherOut(){
    	PuncherRetracted = false;
    	puncher.set(DoubleSolenoid.Value.kForward);
    }
    public void puncherIn(){
    	PuncherRetracted = true;
    	puncher.set(DoubleSolenoid.Value.kReverse);
    }
    public void puncherShift() {
    	if(PuncherRetracted == false){//shifter.get() == DoubleSolenoid.Value.kReverse){
    		puncher.set(DoubleSolenoid.Value.kForward);
    		PuncherRetracted = false;
    	}
    	else{
    		puncher.set(DoubleSolenoid.Value.kReverse);
    		PuncherRetracted = true;
    	}    	
    }*/
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
//        setDefaultCommand(new IntakeArmMove());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void log(){
    	SmartDashboard.putNumber("Arm Speed", armMotor.get());
    	SmartDashboard.putNumber("Arm pot", armPot.getVoltage());
    	SmartDashboard.putBoolean("Arm Nitro", nitro);
   // 	SmartDashboard.putNumber("Right Speed", beltMotor.get());

    }
}

