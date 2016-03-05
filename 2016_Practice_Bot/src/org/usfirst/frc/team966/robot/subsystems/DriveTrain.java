package org.usfirst.frc.team966.robot.subsystems;

import org.usfirst.frc.team966.robot.commands.ArcadeDrive;

//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



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
//	public CANTalon left_drive1, left_drive2, right_drive1, right_drive2;
	public Victor leftBack, rightBack, leftFront, rightFront, rightFront1, rightFront2, rightFront3;
//    private Encoder driveEncoderL, driveEncoderR;
//    private DoubleSolenoid shifter, PTO;
    
//    private RobotDrive drive;
    
    public boolean InHighGear;
    public boolean reverse;
    public boolean PTOEngaged;
    //**************************************
    public DriveTrain() {
    	leftBack = new Victor(8);
    	leftFront = new Victor(9);
       	rightFront = new Victor(6);
    	rightBack = new Victor(7);
    	//8 front left victor, 9 back left, 7 right back, 6 right front
//    	left_drive1 = new CANTalon(1);
//    	left_drive2 = new CANTalon(2);
//    	right_drive1 = new CANTalon(3);
//    	right_drive2 = new CANTalon(4);
//    	shifter = new DoubleSolenoid(0, 6, 5);  //5 LOW 6 HIGHT
//    	PTO = new DoubleSolenoid(0, 4, 7);
//    	driveEncoderL = new Encoder(0, 1);//encoder on Talon???
//    	driveEncoderR = new Encoder(2, 3);//encoder on Talon???  see .setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	reverse = false;
//    	right_drive2.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//    	right_drive1.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    }
    
    public void move(double left, double right){
//    	left_drive1.set(left);
//    	left_drive2.set(left);
//    	right_drive1.set(-right);
//    	right_drive2.set(-right);
    	leftBack.set(left);
    	leftFront.set(left);
    	rightBack.set(-right);
    	rightFront.set(-right);
    }
    
    //For during teleop
    public void arcadeDrive(double yAxis, double xAxis) {
    	double deadband = .2;
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
    
    /*
    //Drive Shifting
    public void driveShift() {
    	if(InHighGear == false){//shifter.get() == DoubleSolenoid.Value.kReverse){
    		shifter.set(DoubleSolenoid.Value.kForward);
    	}
    	else{
    		shifter.set(DoubleSolenoid.Value.kReverse);
    	}    	
    }
    public void shiftLow() {
    	InHighGear = false;
        shifter.set(DoubleSolenoid.Value.kReverse);
    }
    public void shiftHigh() {
    	InHighGear = true;
    	shifter.set(DoubleSolenoid.Value.kForward);
    }
    
    
    //PTO Shifting
    public void ptoOn() {
        PTO.set(DoubleSolenoid.Value.kForward);
        PTOEngaged = true;
    }
    public void ptoOff() {
    	PTO.set(DoubleSolenoid.Value.kReverse);
    	PTOEngaged = false;
    }
    */
    
    //Change Drive Direction
    public void switchDirection() {
    	reverse = !reverse;
    }
 
    
    
    public void log() {
//    	SmartDashboard.putNumber("Can Encoder", right_drive2.getEncPosition());
//		SmartDashboard.putNumber("Can Encoder Velocity", right_drive2.getEncVelocity());
    	
    	SmartDashboard.putBoolean("Drive Shifter High", InHighGear);
    	SmartDashboard.putNumber("Left Back Victor Speed", leftBack.get());
    	SmartDashboard.putNumber("Right Back Victor Speed", rightBack.get());
    	SmartDashboard.putNumber("Left Front Victor Speed", leftFront.get());
    	SmartDashboard.putNumber("Right Front Victor Speed", rightFront.get());
    	SmartDashboard.putBoolean("Reverse", reverse);
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

