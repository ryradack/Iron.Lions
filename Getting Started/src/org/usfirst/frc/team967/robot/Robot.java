package org.usfirst.frc.team967.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team967.robot.subsystems.*;
import org.usfirst.frc.team967.robot.commands.ReachDefencesAuto;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command reachDefencesAutonomousCommand;
	
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Navigation navigation;
	
//	RobotDrive myRobot;
//	Joystick stick;
//	int autoLoopCounter;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	reachDefencesAutonomousCommand = new ReachDefencesAuto();
    	drivetrain = new DriveTrain();
    	oi = new OI();
    	navigation = new Navigation();
    	
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	reachDefencesAutonomousCommand.start();
  //  	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
  //  	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
	//	{
		//	myRobot.drive(-0.5, 0.0); 	// drive forwards half speed
			//autoLoopCounter++;
//			} else {
	//		myRobot.drive(0.0, 0.0); 	// stop robot
//		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	
    	reachDefencesAutonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
    public void log(){
    	drivetrain.log();
    	navigation.log();
    	SmartDashboard.putData(drivetrain);
    	SmartDashboard.putData(navigation);
    	
    	
    }
}
