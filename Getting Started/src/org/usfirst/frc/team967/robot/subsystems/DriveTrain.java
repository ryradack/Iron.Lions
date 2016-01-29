package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team967.robot.Robot;
import org.usfirst.frc.team967.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
	int pin = 5;
	int time_finish=0;
	int time_start =0;
	int wait=0;
	int count=0;
	int PWM_Motor;
	double Pout=0;
	double Iout=0;
	int Ierror=0;
	int error;
	int setpoint = 400;
	double kp=3;
	double ki=.3;
	int threshold = 400;
	
	//**************************************************************************
	private CANTalon left_drive1, left_drive2, right_drive1, right_drive2;
    private Encoder driveEncoder;
    private DoubleSolenoid shifter, PTO;
    
    private RobotDrive drive;
    
    private boolean shift;
    
    public DriveTrain() {
    	left_drive1 = new CANTalon(1);
    	left_drive2 = new CANTalon(2);
    	right_drive1 = new CANTalon(3);
    	right_drive2 = new CANTalon(4);
    	shifter = new DoubleSolenoid(0, 1, 6);
    	PTO = new DoubleSolenoid(0, 0, 7);
    	driveEncoder = new Encoder(0, 1);
    	shift = true;
    }
    
    public void move(double left, double right){
    	left_drive1.set(left);
    	left_drive2.set(left);
    	right_drive1.set(-right);
    	right_drive2.set(-right);
    }
    
    
//	public void drive(double left, double right) {
//		drive.tankDrive(left, right);
//	}

	/**
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
//	public void drive(Joystick joy) {
//		drive(-joy.getRawAxis(1), -joy.getRawAxis(5));
//	}

    
    
//    public void arcadeDrive(Joystick joy){
//    	arcadeDrive(-joy.getRawAxis(1), joy.getRawAxis(4));
//    }
    
    public void arcadeDrive(double yAxis, double xAxis) {
    	double deadband = .15;
    	if((yAxis< deadband) && (yAxis > -deadband)){ yAxis=0;}
    	if((xAxis< deadband) && (xAxis > -deadband)){ xAxis=0;}
    	
    	
    	double L = yAxis + xAxis;
    	double R = yAxis - xAxis;
    	double max = Math.abs(L);
    	if(Math.abs(R) > max) max = Math.abs(R);
    	if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)){
    		move(L,R);
    	}else
    		move(L/max, R/max);
    	SmartDashboard.putNumber("R", R);
    	SmartDashboard.putNumber("L", L);
    	SmartDashboard.putNumber("R/max", R/max);
    	SmartDashboard.putNumber("L/max", L/max);
    }
    
    public void arcadeDriveAuto(double yAxis, double xAxis) {
    	double L = yAxis + xAxis;
    	double R = yAxis - xAxis;
    	double max = Math.abs(L);
    	if(Math.abs(R) > max) max = Math.abs(R);
    	if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)){
    		move(L,R);
    	}else
    		move(L/max, R/max);
    	SmartDashboard.putNumber("R", R);
    	SmartDashboard.putNumber("L", L);
    	SmartDashboard.putNumber("R/max", R/max);
    	SmartDashboard.putNumber("L/max", L/max);
    }    
 /*   public void oldArcade(double yAxis, double xAxis){	
    	
    	double deadband_y=0;	//Left value after considering deadband
		double deadband_x=0;  //Right value after considering deadband
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
   */ 
    public void driveShift() {
    	if(shifter.get() == DoubleSolenoid.Value.kReverse){
    		shifter.set(DoubleSolenoid.Value.kForward);
    	}
    	else{
    		shifter.set(DoubleSolenoid.Value.kReverse);
    	}    	
    }
    public void shiftLow() {
        shifter.set(DoubleSolenoid.Value.kReverse);
    }
    public void shiftHigh() {
    	shifter.set(DoubleSolenoid.Value.kForward);
    }
    public void ptoOn() {
        PTO.set(DoubleSolenoid.Value.kForward);
    }
    public void ptoOff() {
    	PTO.set(DoubleSolenoid.Value.kReverse);
    }
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void log() {
    	
    	SmartDashboard.putNumber("Left Speed", left_drive1.get());
    	SmartDashboard.putNumber("Right Speed", right_drive1.get());
//    	SmartDashboard.putData("shifter", shifter.get());
//    	SmartDashboard.putNumber("shifter", shifter.get());
//    	SmartDashboard.putInt("shifter", shifter.get());
//    	SmartDashboard.putBoolean("shifter", shifter.get());
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

