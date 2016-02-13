package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.commands.IntakeArmMove;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Intake extends Subsystem {
    private Talon armMotor, beltMotor;
//    private Encoder armEncoder;
    private AnalogPotentiometer armPot;
    
    public Intake() {
    	armMotor = new Talon(1);
    	beltMotor = new Talon(2);
//    	armEncoder = new Encoder(2, 3);
    	armPot = new AnalogPotentiometer(4);
    }
    public void beltIn(){
    	beltMotor.set(1);
    }
    public void beltOut(){
    	beltMotor.set(-1);
    }
    public void armUp(){
    	armMotor.set(1);
    }
    public void armDown(){
    	armMotor.set(-1);
    }
    public void armMove(double speed){
    	armMotor.set(speed);
    }
    public boolean armToDown(){
    	if(armPot.get() < 10){//10 would be the bottom limit
    		armMotor.set(0);
    		return true;
    	}
    	else{
    		armMotor.set(-1);
    		return false;
    	}
    }
    public boolean armToUp(){
    	if(armPot.get() > 250){//10 would be the bottom limit
    		armMotor.set(0);
    		return true;
    	}
    	else{
    		armMotor.set(1);
    		return false;
    	}
    }
    public boolean armToPosition(int position){
    	if(armPot.get() > (position+5)){//10 would be the bottom limit
    		armMotor.set(-1);
    		return false;
    	}
    	else if(armPot.get() < (position-5)){
    		armMotor.set(1);
    		return false;
    	}
    	else{
    		armMotor.set(0);
    		return true;
    	}
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeArmMove());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void log(){
   // 	SmartDashboard.putNumber("Arm Speed", armMotor.get());
   // 	SmartDashboard.putNumber("Right Speed", beltMotor.get());

    }
}

