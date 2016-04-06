package org.usfirst.frc.team966.robot.subsystems;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Navigation extends Subsystem {
	
//	public AHRS ahrs;
	CameraServer serverFront, serverRear;
	public AnalogInput ultrasonic1;
	public AnalogInput ultrasonic2;
    public boolean cam1;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Navigation() {
		cam1 = true;
		ultrasonic1 = new AnalogInput(0);
		ultrasonic2 = new AnalogInput(1);
//		ahrs = new AHRS(I2C.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */	
		
		//stream off camera to smartDashboard
		serverFront = CameraServer.getInstance();
    	serverFront.setQuality(30);
    	serverFront.startAutomaticCapture("cam0");
    	
//    	serverRear = CameraServer.getInstance();
//    	serverRear.setQuality(50);
//    	serverRear.startAutomaticCapture("cam2");
	}
	
	public void switchCamView(){
		if(cam1 = true){
			serverFront.startAutomaticCapture("cam0");
		}
		else{
			serverFront.startAutomaticCapture("cam1");
		}
	}
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void log() {	
    	SmartDashboard.putNumber("Ultrasonic2", ultrasonic2.getValue());
    	SmartDashboard.putNumber("Ultrasonic1", ultrasonic1.getValue());
/*    	SmartDashboard.putNumber("NavX x-axis", ahrs.getRawGyroX());
    	SmartDashboard.putNumber("NavX y-axis", ahrs.getRawGyroY());
    	SmartDashboard.putNumber("NavX z-axis", ahrs.getRawGyroZ());
    	SmartDashboard.putNumber("Barometric Pressure", ahrs.getBarometricPressure());
    	SmartDashboard.putNumber("Mag x", ahrs.getRawMagX());
    	SmartDashboard.putNumber("Mag y", ahrs.getRawMagY());
    	SmartDashboard.putNumber("Mag z", ahrs.getRawMagZ());
    	SmartDashboard.putNumber("Accel x", ahrs.getRawAccelX());
    	SmartDashboard.putNumber("Accel y", ahrs.getRawAccelY());
    	SmartDashboard.putNumber("Accel z", ahrs.getRawAccelZ());
    	SmartDashboard.putNumber("Yaw", ahrs.getYaw());
    	SmartDashboard.putNumber("Pitch", ahrs.getPitch());
    	SmartDashboard.putNumber("Roll", ahrs.getRoll());
    	SmartDashboard.putNumber("PID get", ahrs.pidGet());
    	SmartDashboard.putBoolean("Magnometer Calibrated", ahrs.isMagnetometerCalibrated());
    	SmartDashboard.putNumber("Fused Heading", ahrs.getFusedHeading());
    	SmartDashboard.putNumber("Compass heading", ahrs.getCompassHeading());
  */  	

    }
}

