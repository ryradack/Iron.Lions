package org.usfirst.frc.team967.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team967.robot.Robot;

/**
 *
 */
public class ShiftDriveLow extends Command {

    public ShiftDriveLow() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	if(Robot.oi.getXbox1().getRawAxis(2) < .75){
        	Robot.drivetrain.shiftLow();
//        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return false;
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
