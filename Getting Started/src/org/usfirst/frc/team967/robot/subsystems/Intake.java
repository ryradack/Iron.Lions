package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Intake extends Subsystem {
    private Talon armMotor, beltMotor;
    private Encoder armEncoder;
    
    public Intake() {
    	armMotor = new Talon(1);
    	beltMotor = new Talon(2);
    	armEncoder = new Encoder(2, 3);
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
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void log(){
   // 	SmartDashboard.putNumber("Arm Speed", armMotor.get());
   // 	SmartDashboard.putNumber("Right Speed", beltMotor.get());

    }
}

