																																																																					package org.usfirst.frc.team967.robot;

import org.usfirst.frc.team967.robot.commands.AutoDefenceAndBack;
import org.usfirst.frc.team967.robot.commands.AutoDriveForwardCount;
import org.usfirst.frc.team967.robot.commands.AutoDrivePID;
import org.usfirst.frc.team967.robot.commands.AutoLowBar;
import org.usfirst.frc.team967.robot.commands.AutoLowBarAndBack;
import org.usfirst.frc.team967.robot.subsystems.Climber;
import org.usfirst.frc.team967.robot.subsystems.DriveTrain;
import org.usfirst.frc.team967.robot.subsystems.Intake;
import org.usfirst.frc.team967.robot.subsystems.Navigation;
import org.usfirst.frc.team967.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	public static Shooter shooter;
	
	Command AutoToDefences, AutoPassLowBar, AutoLowBarAndBack, AutoDefenceAndBack, AutoPassDefence;
//	SendableChooser autoChooser;
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
    	shooter = new Shooter();
       	oi = new OI();
    	
    	AutoToDefences = new AutoDriveForwardCount(200);
//    	autoDrivePIDCommand = new AutoDrivePID();
    	AutoPassDefence = new AutoDriveForwardCount(800);
    	AutoPassLowBar = new AutoLowBar();
    	AutoLowBarAndBack = new AutoLowBarAndBack();
    	AutoDefenceAndBack = new AutoDefenceAndBack();
    	
//    	autoChooser = new SendableChooser();
//    	autoChooser.addDefault("Drive Past Defence", new AutoDriveForwardCount(800));
//    	autoChooser.addObject("Drive To Defence", new AutoDriveForwardCount(200));
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	drivetrain.ptoOff();
    	drivetrain.shiftLow();
    	switch(navigation.chooseAuto()){
    		case 1:
    			AutoPassLowBar.start();
    			break;
    		case 2:
    			AutoPassDefence.start();
    			break;
    		case 3:
    			AutoLowBarAndBack.start();
    			break;
    		case 4:
    			AutoDefenceAndBack.start();
    			break;
    		case 5:
    			AutoToDefences.start();
    		case 50:
    			
    			break;
    	}
//    	AutoPassLowBar.start();
//       	AutoPassDefence.start();
//    	AutonomousCommand = (Command) autoChooser.getSelected();
//    	AutonomousCommand.start();
//    	reachDefencesAutonomousCommand.start();
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
    	switch(navigation.chooseAuto()){
		case 1:
			AutoPassLowBar.cancel();
			break;
		case 2:
			AutoPassDefence.cancel();
			break;
		case 3:
			AutoLowBarAndBack.cancel();
			break;
		case 4:
			AutoDefenceAndBack.cancel();
			break;
		case 5:
			AutoToDefences.cancel();
		case 50:
			
			break;
    	}
    	drivetrain.ptoOff();
    	drivetrain.shiftLow();
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
    	shooter.log();
    	//Displays the command that is using the subsystem at that time
    	SmartDashboard.putData(drivetrain);
    	SmartDashboard.putData(intake);
    	SmartDashboard.putData(navigation);
    	SmartDashboard.putData(climber);
    	SmartDashboard.putData(Scheduler.getInstance());
    }
}
