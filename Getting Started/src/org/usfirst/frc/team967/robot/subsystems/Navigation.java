package org.usfirst.frc.team967.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Navigation extends Subsystem {
	
	private AHRS ahrs;
	CameraServer server;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Navigation() {

		ahrs = new AHRS(I2C.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */	
		//stream off camera to smartDashboard
		server = CameraServer.getInstance();
    	server.setQuality(50);
    	server.startAutomaticCapture("cam0");	
	}
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void log() {	
    	SmartDashboard.putNumber("NavX x-axis", ahrs.getRawGyroX());
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
    	

    }
}

