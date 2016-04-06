package org.usfirst.frc.team967.robot.commands;

import org.usfirst.frc.team967.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeArmMove extends Command {

    public IntakeArmMove() {
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.intake.nitro == true && Robot.intake.ClimbMode == false){
    		Robot.intake.armMove(-Robot.oi.getXbox2().getRawAxis(1));
    	}
    	else if(Robot.intake.nitro == false && Robot.intake.ClimbMode == false){
    		Robot.intake.armMove(-Robot.oi.getXbox2().getRawAxis(1)/2);
    	}
    	else if(Robot.intake.ClimbMode == true){
    		
    	}
    	Robot.intake.CheckForBall();
    	//Robot.intake.armMove(Robot.intake.armSpeed);
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
