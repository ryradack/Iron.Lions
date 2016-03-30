package org.usfirst.frc.team967.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import java.util.Timer;

/**
 *
 */
public class Delay extends Command {
	private long seconds;
	private long start;
	private boolean timeUp;
//	Timer timer = new Timer();
    
	public Delay(long sec) {
		seconds = sec;
        
		// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	start = System.currentTimeMillis();
    	timeUp = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(System.currentTimeMillis() > (start + seconds*1000)){
    		timeUp = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timeUp;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
