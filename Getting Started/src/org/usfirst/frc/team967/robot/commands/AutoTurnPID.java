package org.usfirst.frc.team967.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team967.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.*;
/**
 *
 */
public class AutoTurnPID extends Command {
	double count=0;
	double PIDTurnCommand=0;
	double Pout=0;
	double Iout=0;
	double Ierror=0;
	double Dout=0;
	double Derror=0;
	double lastError=0;
	double startD = 0;
	double normerror=0;
	double error;
	double setpoint = 180;
	
	double kp=1.2;//1.515625;
	double ki=.16;
	double kd=.5;//.5
	
	double threshold = 400;
	

	
    public AutoTurnPID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Turn PID Error", error);
    	SmartDashboard.putNumber("Turn Show kp", kp);
    	SmartDashboard.putNumber("Turn Show ki", ki);
    	SmartDashboard.putNumber("Turn Show kd", kd);
    	SmartDashboard.putNumber("Turn P out", Pout);
    	SmartDashboard.putNumber("Turn I out", Iout);
    	SmartDashboard.putNumber("Turn D out", Dout);
    	SmartDashboard.putNumber("Turn mapValue", map(Pout+Iout, -threshold, threshold, -1, 1));
    	SmartDashboard.putNumber("Turn mapValue2", map(200, -threshold, threshold, -1, 1));
    	
    	count++;
    	if(count > 3){
    		Pcontroller();
    		Icontroller();
    	
    		PIDTurnCommand = map(Pout+Iout+Dout, -2*threshold, 2*threshold, -1 , 1);//Pout+Iout
//    		analogWrite(pin,PWM_Motor);
    		Robot.drivetrain.arcadeDriveAuto(0, PIDTurnCommand);

    		count = 0;
    	}
    	SmartDashboard.putNumber("PIDTurnCommand", PIDTurnCommand);
    	SmartDashboard.putNumber("count", count);
    	
    	ki = SmartDashboard.getNumber("ki", ki);
    	kp = SmartDashboard.getNumber("kp", kp);
    	kd = SmartDashboard.getNumber("kd", kd);
    	setpoint = SmartDashboard.getNumber("setpoint", setpoint);
    	
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    
    double map(double x, double x_min, double x_max, double a, double b){
//    	return ((x - in_max)* (out_max - out_min) / (in_max - in_min)) + out_min;
    	return ( ( (x - x_min)*(b-a) ) /(x_max-x_min)) + a;
    	//return (x-in_min) / (in_max-in_min) * (out_max - out_min) + out_min;
    }
    
	void Pcontroller() {
		
		//Calculate Error
		error = (double) (setpoint - Robot.navigation.ahrs.getFusedHeading());// - setpoint);
		if (error < -180){error += 360;}
		if (error > 180){error -= 360;}
		
		//error = setpoint - normerror;
		Pout = kp * error;

		//Fix output value to threshold
		if(Pout > threshold) 
			Pout=threshold ;
		if(Pout <-threshold)  
			Pout=-threshold;
	}
	void Icontroller(){
		Ierror = Ierror + error;
		Iout = ki * Ierror;
		
		if(Iout > threshold)
			Iout=threshold ;
		if(Iout <-threshold)  
			Iout=-threshold;

	}
	void Dcontroller(){
		if((count == 3) && (startD ==0)){
			startD ++;
			lastError = error;
		}
		if(startD > 1){
		Derror = (error - lastError)/count;
		lastError = error;
		Dout = kd * Derror;
		}
	}
}