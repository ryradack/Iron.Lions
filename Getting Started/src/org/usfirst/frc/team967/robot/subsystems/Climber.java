package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team967.robot.commands.ClimberMove;

/**
 *
 */
public class Climber extends Subsystem {
	private Talon motor1, motor2;
    private Encoder climberEncoder;
    private DoubleSolenoid climberShifter;
    
    public Climber() {
    	motor1 = new Talon(3);
    	motor2 = new Talon(4);
    	climberShifter = new DoubleSolenoid(0, 2,5);
    	climberEncoder = new Encoder(4, 5);
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void climberUp(){
    	motor1.set(1);
    	motor2.set(1);
    }
    public void climberDown(){
    	motor1.set(-1);
    	motor2.set(-1);
    }
    public void climberMove(double speed){
    	motor1.set(speed);
    	motor2.set(speed);
    }
    
    public void climberExtend(){
    	climberShifter.set(DoubleSolenoid.Value.kForward);
    }
    public void climberRetract(){
    	climberShifter.set(DoubleSolenoid.Value.kReverse);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ClimberMove());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void log(){
//    	SmartDashboard.putNumber("Climber Speed", motor1.get());
//    	SmartDashboard.putString("Climber Shifter", climberShifter.get());

    }
}

