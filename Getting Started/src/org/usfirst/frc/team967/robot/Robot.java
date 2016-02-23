package org.usfirst.frc.team967.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team967.robot.subsystems.*;
import org.usfirst.frc.team967.robot.commands.ReachDefencesAuto;
import org.usfirst.frc.team967.robot.commands.AutoDrivePID;
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
	public static OI oi;
	public static DriveTrain drivetrain;
	public static Navigation navigation;
	public static Intake intake;
	public static Climber climber;
	
	Command reachDefencesAutonomousCommand;
	Command autoDrivePIDCommand;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drivetrain = new DriveTrain();
    	navigation = new Navigation();
    	intake = new Intake();
    	climber = new Climber();
       	oi = new OI();
    	
    	reachDefencesAutonomousCommand = new ReachDefencesAuto();
    	autoDrivePIDCommand = new AutoDrivePID();

    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
//    	reachDefencesAutonomousCommand.start();
    	autoDrivePIDCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	autoDrivePIDCommand.cancel();
    	drivetrain.ptoOff();
    	drivetrain.shiftLow();
//    	reachDefencesAutonomousCommand.cancel();
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
    	oi.log();
    	drivetrain.log();
    	navigation.log();
    	climber.log();
    	intake.log();
    	//Displays the command that is using the subsystem at that time
    	SmartDashboard.putData(drivetrain);
    	SmartDashboard.putData(intake);
    	SmartDashboard.putData(navigation);
    	SmartDashboard.putData(climber);
    }
}
