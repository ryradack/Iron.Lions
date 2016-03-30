package org.usfirst.frc.team967.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team967.robot.subsystems.*;
import org.usfirst.frc.team967.robot.*;

/**
 *
 */
public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.drivetrain.reverse == false && Robot.drivetrain.PTOEngaged == false && Robot.drivetrain.halfDrive == false){
    		Robot.drivetrain.arcadeDrive(-Robot.oi.getXbox1().getRawAxis(1), (Robot.oi.getXbox1().getRawAxis(4))*.75);
    	}
    	else if(Robot.drivetrain.reverse == false && Robot.drivetrain.PTOEngaged == false && Robot.drivetrain.halfDrive == true){
    		Robot.drivetrain.arcadeDrive((-Robot.oi.getXbox1().getRawAxis(1))*.5, (Robot.oi.getXbox1().getRawAxis(4))*.75);
    	}
    	else if(Robot.drivetrain.PTOEngaged == false){
    		Robot.drivetrain.arcadeDrive(-Robot.oi.getXbox1().getRawAxis(1), (-Robot.oi.getXbox1().getRawAxis(4))*.75);
    	}
    	else{
    		Robot.drivetrain.arcadeDrive(Robot.oi.getXbox1().getRawAxis(1), 0);
    	}
    }	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.drivetrain.move(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	end();
    }
}
