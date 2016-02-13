package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.Robot;
import org.usfirst.frc.team967.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    private Encoder driveEncoderL, driveEncoderR;
    private DoubleSolenoid shifter, PTO;
    
//    private RobotDrive drive;
    
    private boolean shift;
    public boolean reverse;
    //**************************************
    public DriveTrain() {
    	left_drive1 = new CANTalon(1);
    	left_drive2 = new CANTalon(2);
    	right_drive1 = new CANTalon(3);
    	right_drive2 = new CANTalon(4);
    	shifter = new DoubleSolenoid(0, 1, 6);
    	PTO = new DoubleSolenoid(0, 0, 7);
    	driveEncoderL = new Encoder(0, 1);//encoder on Talon???
    	driveEncoderR = new Encoder(2, 3);//encoder on Talon???  see .setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	shift = true;
    	reverse = false;
    	right_drive2.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//    	right_drive1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	driveEncoderL.setDistancePerPulse(0.042);
		driveEncoderR.setDistancePerPulse(0.042);
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
    //For during teleop
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
    //Arcade drive without deadband
    public void arcadeDriveAuto(double yAxis, double xAxis) {
    	double L = yAxis + xAxis;
    	double R = yAxis - xAxis;
    	double max = Math.abs(L);
    	if(Math.abs(R) > max) max = Math.abs(R);
    	if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)){
    		move(L,R);
    	}else
    		move(L/max, R/max);
    	SmartDashboard.putNumber("R Auto", R);
    	SmartDashboard.putNumber("L Auto", L);
    	SmartDashboard.putNumber("R/max Auto", R/max);
    	SmartDashboard.putNumber("L/max Auto", L/max);
    }
    //Drive Shifting
    public boolean getDriveShift(){
    	if(shifter.get()==DoubleSolenoid.Value.kForward){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
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
    //PTO Shifting
    public void ptoOn() {
        PTO.set(DoubleSolenoid.Value.kForward);
    }
    public void ptoOff() {
    	PTO.set(DoubleSolenoid.Value.kReverse);
    }
    //Change Drive Direction
    public void switchDirection() {
    	reverse = !reverse;
    }
 
    // Put methods for controlling this subsystem here. Call these from Commands.
    
    public void log() {
    	SmartDashboard.putNumber("Can Encoder", right_drive2.getEncPosition());
		SmartDashboard.putNumber("Can Encoder Velocity", right_drive2.getEncVelocity());
    	
    	
    	SmartDashboard.putNumber("Left Distance", driveEncoderL.getDistance());
		SmartDashboard.putNumber("Right Distance", driveEncoderR.getDistance());
    	
    	SmartDashboard.putBoolean("Drive Shifter", getDriveShift());
    	SmartDashboard.putNumber("Left Speed", left_drive1.get());
    	SmartDashboard.putNumber("Right Speed", right_drive1.get());
    	SmartDashboard.putBoolean("Reverse", reverse);
    	
    	SmartDashboard.putNumber("EncoderR get", driveEncoderR.get());
    	SmartDashboard.putNumber("EncoderR raw", driveEncoderR.getRaw());
    	SmartDashboard.putNumber("EncoderR rate", driveEncoderR.getRate());
    
    	SmartDashboard.putNumber("EncoderL get", driveEncoderL.get());
    	SmartDashboard.putNumber("EncoderL raw", driveEncoderL.getRaw());
    	SmartDashboard.putNumber("EncoderL rate", driveEncoderL.getRate());
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

