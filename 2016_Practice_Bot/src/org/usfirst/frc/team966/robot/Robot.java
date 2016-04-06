package org.usfirst.frc.team966.robot;

//import org.usfirst.frc.team966.robot.commands.AutoDrivePID;
//import org.usfirst.frc.team966.robot.commands.AutoTurnPID;
//import org.usfirst.frc.team966.robot.commands.PuncherOut;
//import org.usfirst.frc.team966.robot.commands.ReachDefencesAuto;
import org.usfirst.frc.team966.robot.subsystems.Climber;
import org.usfirst.frc.team966.robot.subsystems.DriveTrain;
import org.usfirst.frc.team966.robot.subsystems.Intake;
import org.usfirst.frc.team966.robot.subsystems.Navigation;
import org.usfirst.frc.team966.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	public StringBuilder message;
	
	Command AutonomousCommand;
	SendableChooser autoChooser;
//	Command autoDrivePIDCommand;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	StringBuilder message = new StringBuilder();
    	drivetrain = new DriveTrain();
    	navigation = new Navigation();
    	intake = new Intake();
    	climber = new Climber();
    	shooter = new Shooter();
       	oi = new OI();
    	
//    	AutonomousCommand = new ReachDefencesAuto();
//    	autoDrivePIDCommand = new AutoDrivePID();
    	
    	autoChooser = new SendableChooser();
//    	autoChooser.addDefault("Default Program", new PuncherOut());
//    	autoChooser.addObject("Drive To Defence", new AutoTurnPID());
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	AutonomousCommand = (Command) autoChooser.getSelected();
    	AutonomousCommand.start();
//    	reachDefencesAutonomousCommand.start();
//    	autoDrivePIDCommand.start();
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
//    	autoDrivePIDCommand.cancel();
//    	drivetrain.ptoOff();
//    	drivetrain.shiftLow();
//    	AutonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	log();
    	
   /* 	message.append("\tout:");
    	message.append(shooter.Output);
    	message.append("\tspd:");
    	message.append(shooter.flyWheel.getSpeed() );
    	
    	message.append("\terr:");
		message.append(shooter.flyWheel.getClosedLoopError());
		message.append("\ttrg:");
		message.append(shooter.Target);
		
		System.out.println(message.toString());
		message.setLength(0);
    */	
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
