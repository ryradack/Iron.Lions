/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team966.robot.commands;

import org.usfirst.frc.team966.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Have the robot drive tank style using the PS3 Joystick until interrupted.
 */
public class TankDriveWithJoystick extends Command {
    
	private int clawopen=0;
	private int grabberopen=0;
	
    public TankDriveWithJoystick() {
    	
    	
        requires(Robot.drivetrain);
        requires(Robot.claw);
    }

    // Called just before this Command runs the f iirst time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.drive(Robot.oi.getJoystick());
        if(Robot.oi.getJoystick().getRawButton(1)) {
        	if (clawopen==0){
        		Robot.claw.clawOpen();
        		try{
        		Thread.sleep(1000);
        		}catch (Exception e)
        		{}
        		clawopen=1;
	
        	}
        }
        if(Robot.oi.getJoystick().getRawButton(1)){
        	if (clawopen==1){
        		Robot.claw.clawClose();
        		try{
            	Thread.sleep(1000);
            	}catch (Exception e)
            	{}
        		clawopen=0;
        	}
        }
        if(Robot.oi.getJoystick().getRawButton(2)) {
        	if (grabberopen==0){
        		Robot.claw.grabberOpen();
        		try{
        		Thread.sleep(1000);
        		}catch (Exception e)
        		{}
        		grabberopen=1;
        	}
        }
        if(Robot.oi.getJoystick().getRawButton(2)){
        	if (grabberopen==1){
        		Robot.claw.grabberClose();
        		try{
            	Thread.sleep(1000);
            	}catch (Exception e)
            	{}
        		grabberopen=0;
        	}
        }        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
