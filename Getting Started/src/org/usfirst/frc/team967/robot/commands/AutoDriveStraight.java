package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveStraight extends Command {
	private int Distance;
	private double zero;
	private double currentAngle;
	
    public AutoDriveStraight(int distance) {
    	this.Distance = distance;
		requires(Robot.drivetrain);
    	requires(Robot.navigation);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	zero = Robot.navigation.getRawZAngle();
    	Robot.drivetrain.move(.8, .8);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = Robot.navigation.getRawZAngle();
    	if(currentAngle > zero){
    		
    	}
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
}
