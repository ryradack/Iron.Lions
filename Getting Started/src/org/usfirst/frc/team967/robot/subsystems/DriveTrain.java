package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team967.robot.Robot;
import org.usfirst.frc.team967.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveTrain extends Subsystem {
    private CANTalon left_drive1, left_drive2, right_drive1, right_drive2;
    private Encoder driveEncoder;
    private Solenoid shifter;
    private boolean shift;
    
    public DriveTrain() {
    	left_drive1 = new CANTalon(1);
    	left_drive2 = new CANTalon(2);
    	right_drive1 = new CANTalon(3);
    	right_drive2 = new CANTalon(4);
    	shifter = new Solenoid(1,6);
    	driveEncoder = new Encoder(0, 1);
    }
    
    public void move(double left, double right){
    	left_drive1.set(left);
    	left_drive2.set(left);
    	right_drive1.set(right);
    	right_drive2.set(right);
    }
    
    public void arcadeDrive(Joystick joy){
    	arcadeDrive(-joy.getRawAxis(1), joy.getRawAxis(4));
    }
    
    public void arcadeDrive(double yAxis, double xAxis) {
    	double deadband = .15;
    	
    	if(yAxis < -deadband || yAxis > deadband){
    		if(xAxis < -deadband || xAxis > deadband){
    			move((yAxis + xAxis)/2, (yAxis - xAxis)/2);
    		}
    		else{
    			move(yAxis, yAxis);
    		}
    	}
    }
    public void oldArcade(double yAxis, double xAxis){	
    	
    	double deadband_y=yAxis;	//Left value after considering deadband
		double deadband_x=xAxis;  //Right value after considering deadband
		if(yAxis > -.20 && yAxis < .20){
			deadband_y=0;
		}
		if(xAxis > -.20 && xAxis < .20){
			deadband_x=0;
		}
		if(deadband_y != 0){
			left_drive1.set(-deadband_y);
			left_drive2.set(-deadband_y);
			right_drive1.set(deadband_y);
			right_drive2.set(deadband_y);
		}
		if(deadband_x != 0){
			left_drive1.set(deadband_x);
			left_drive2.set(deadband_x);
			right_drive1.set(deadband_x);
			right_drive2.set(deadband_x);
		}
    }
    
    public void driveShift() {
    	shifter.set(!shifter.get());
    }
//    public void shiftLow() {
//    	shifter.set(shift = true);
//    }
    
    
    
//	private 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void log() {
    	
    	SmartDashboard.putNumber("Left Speed", left_drive1.get());
    	SmartDashboard.putNumber("Right Speed", right_drive1.get());
    	
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

