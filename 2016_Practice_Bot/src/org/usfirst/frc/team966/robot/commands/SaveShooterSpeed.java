package org.usfirst.frc.team966.robot.commands;

import org.usfirst.frc.team966.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SaveShooterSpeed extends Command {
	private boolean Hold;
	
    public SaveShooterSpeed(boolean hold) {
        requires(Robot.shooter);
        Hold = hold;
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.hold = Hold;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
