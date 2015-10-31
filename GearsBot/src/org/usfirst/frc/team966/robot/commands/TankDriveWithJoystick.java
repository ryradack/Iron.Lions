/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team966.robot.commands;

import org.usfirst.frc.team966.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**

 */
public class TankDriveWithJoystick extends Command {
    
	private boolean tankDrive;
	
	private int clawopen=0;
	private int grabberopen=0;
	
    public TankDriveWithJoystick() {
    	
//    	requires(Robot.elevator);
        requires(Robot.drivetrain);
        requires(Robot.claw);
    }

    // Called just before this Command runs the f iirst time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	if (Robot.oi.xbox1_start()){
    		if (tankDrive = true){
    			tankDrive = false;
    		}
    		else {
    			tankDrive = true;
    		}
    	} 
    	if (tankDrive = true){
    		Robot.drivetrain.drive(Robot.oi.xbox1_y1(), Robot.oi.xbox1_y2());
    	}
    	else{
        	Robot.drivetrain.arcadeDrive(Robot.oi.xbox1_y1(), Robot.oi.xbox1_x2());
        }
    	
    	if(Robot.oi.xbox1_aTapped()) {
        	if (clawopen==0){
        		Robot.claw.clawOpen();
        		clawopen=1;
        	}
        	else{
        		Robot.claw.clawClose();
        		clawopen=0;
        	}
        }
        if(Robot.oi.xbox1_bTapped()) {
        	if (grabberopen==0){
        		Robot.claw.grabberOpen();
        		grabberopen=1;
        	}
        	else{
        		Robot.claw.grabberClose();
        		grabberopen=0;
        	}
        }
//        if(Robot.oi.xbox1_rT()){
//        	Robot.elevator.elevatorup();
//        }
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
