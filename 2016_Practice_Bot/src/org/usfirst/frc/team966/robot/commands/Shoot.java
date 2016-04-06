package org.usfirst.frc.team966.robot.commands;

import org.usfirst.frc.team966.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Shoot extends Command {

	private double speed;
	
    public Shoot() {
    	speed = Robot.shooter.Speed;
    	requires(Robot.shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.hold){
    		Robot.shooter.moveflyWheel(Robot.shooter.Speed);
    	}
    	else{
    		Robot.shooter.moveflyWheel(Robot.oi.getXbox1().getRawAxis(1));
    		Robot.shooter.Speed = Robot.oi.getXbox1().getRawAxis(1);
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
