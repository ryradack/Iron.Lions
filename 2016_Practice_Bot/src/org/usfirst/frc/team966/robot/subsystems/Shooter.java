package org.usfirst.frc.team966.robot.subsystems;

import org.usfirst.frc.team966.robot.commands.Shoot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class Shooter extends Subsystem {
    public CANTalon flyWheel;
    public StringBuilder message;
    public double Target;
    public double setSpeed;
    public double Speed;
    
    public double temporary;
    public boolean hold;
    
    
    
    public Shooter(){
    	flyWheel = new CANTalon(10);
    	message = new StringBuilder();
    	
    	flyWheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	flyWheel.configEncoderCodesPerRev(1024);//(1024);
    	flyWheel.reverseSensor(false);
    	flyWheel.configMaxOutputVoltage(12);
    	flyWheel.configNominalOutputVoltage(+0.0f, -0.0f);
    	flyWheel.configPeakOutputVoltage(+12.0f, 0.0f);//-12.0f
    	
    	flyWheel.setProfile(0);
    	flyWheel.setF(0.0396);//0 //0.1097 in example
    	
    	//for wheel speed = 1
    	flyWheel.setP(0.05);//.01 worked pretty well
    	flyWheel.setI(0.001);//.0001
    	flyWheel.setD(0.1);//.01
    	
//    	flyWheel.setP(0.);//.01 worked pretty well
//    	flyWheel.setI(0.);//.0001
//    	flyWheel.setD(0.);//.01
    }
    public void moveflyWheel(double speed){
    	flyWheel.changeControlMode(TalonControlMode.PercentVbus);
    	flyWheel.set(speed);
    }
    
    public void setFlyWheel(double target){
    	Target = target;
    	flyWheel.changeControlMode(TalonControlMode.Speed);
    	flyWheel.set(target*1500);
    		
       	/* get gamepad axis *
       	double leftYstick = Robot.oi.getXbox1().getRawAxis(5);
       	double motorOutput = flyWheel.getOutputVoltage() / flyWheel.getBusVoltage();
//       	/* prepare line to print *
   		message.append("\tout:");
   		message.append(motorOutput);
   		message.append("\tspd:");
   		message.append(flyWheel.getSpeed() );
            
        if(Robot.oi.getXbox1().getRawButton(1)){
           	/* Speed mode *
           	double targetSpeed = leftYstick *1000 ; /* 1500 RPM in either direction *
           	flyWheel.changeControlMode(TalonControlMode.Speed);
           	flyWheel.set(targetSpeed); 
//           	 append more signals to print when in speed mode.
           		message.append("\terr:");
           		message.append(flyWheel.getClosedLoopError());
           		message.append("\ttrg:");
           		message.append(targetSpeed);
        } 
        else {
           	/* Percent voltage mode *
        	   flyWheel.changeControlMode(TalonControlMode.PercentVbus);
        	   flyWheel.set(leftYstick);
        }
        if(++ loops >= 10) {
        	loops = 0;
        	System.out.println(message.toString());
        }
        message.setLength(0);
        */
    }   
    /*
    public void changeSpeed(double change){
    	if(change >.5){
    		Speed = Speed + .01;
    	}
    	if(change < -.5){
    		Speed = Speed - .01;
    	}
    	if(Speed > 1){
    		Speed = 1;
    	}
    	if(Speed < -1){
    		Speed = -1;
    	}
    }
    
/*    public void CurrentShoot(){
    	flyWheel.changeControlMode(TalonControlMode.Current);
		flyWheel.set(.75);
    }*/
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void log(){
    	SmartDashboard.putNumber("Shooter Speed", flyWheel.getSpeed());
    	SmartDashboard.putNumber("Shooter RPM", flyWheel.getSpeed());
    	
    	SmartDashboard.putNumber("Shooter Current", flyWheel.getOutputCurrent());
    	SmartDashboard.putNumber("Shooter Voltage", flyWheel.getOutputVoltage());
    	SmartDashboard.putNumber("Shooter Encoder Velocity", flyWheel.getEncVelocity());
    	SmartDashboard.putNumber("Shooter Encoder Velocity abs", Math.abs(flyWheel.getEncVelocity()));
    	
    	SmartDashboard.putNumber("Talon error", flyWheel.getClosedLoopError());
    	SmartDashboard.putNumber("Talon Bus voltage", flyWheel.getBusVoltage());
    	SmartDashboard.putNumber("Talon Target", Target);
    	SmartDashboard.putNumber("Talon PIDGet", flyWheel.pidGet());
    	SmartDashboard.putNumber("Talon P", flyWheel.getP());
    	SmartDashboard.putNumber("Talon I", flyWheel.getI());
    	SmartDashboard.putNumber("Talon D", flyWheel.getD());
    	SmartDashboard.putNumber("Shooter counts", flyWheel.getEncPosition());
    	SmartDashboard.putNumber("SetSpeed", setSpeed);
    	SmartDashboard.putNumber("Speed", Speed);
    	
    	SmartDashboard.putBoolean("hold", hold);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new Shoot());
    	//        setDefaultCommand(new Shoot(1);
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


