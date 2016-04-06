package org.usfirst.frc.team966.robot;

import org.usfirst.frc.team966.robot.commands.CurrentShoot;
import org.usfirst.frc.team966.robot.commands.MoveFlyWheel;
import org.usfirst.frc.team966.robot.commands.SaveShooterSpeed;
import org.usfirst.frc.team966.robot.commands.SetSpeed;
import org.usfirst.frc.team966.robot.commands.Shoot;
//import org.usfirst.frc.team966.robot.commands.ClimberDown;
//import org.usfirst.frc.team966.robot.commands.ClimberStopExtention;
//import org.usfirst.frc.team966.robot.commands.ClimberUp;
//import org.usfirst.frc.team966.robot.commands.IntakeArmSpeedSet;
//import org.usfirst.frc.team966.robot.commands.IntakeIn;
//import org.usfirst.frc.team966.robot.commands.IntakeOut;
//import org.usfirst.frc.team966.robot.commands.IntakeStopBelt;
//import org.usfirst.frc.team966.robot.commands.IntakeToggleNitro;
//import org.usfirst.frc.team966.robot.commands.PTOShiftOff;
//import org.usfirst.frc.team966.robot.commands.PTOShiftOn;
//import org.usfirst.frc.team966.robot.commands.PuncherIn;
//import org.usfirst.frc.team966.robot.commands.PuncherOut;
//import org.usfirst.frc.team966.robot.commands.ShiftDriveHigh;
//import org.usfirst.frc.team966.robot.commands.ShiftDriveLow;
import org.usfirst.frc.team966.robot.commands.SwitchArcadeDriveDirection;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
    private Joystick xbox1 = new Joystick(0);
    private Joystick xbox2 = new Joystick(1);
    private Joystick board = new Joystick(2);
    double leftTrigger;
    double rightTrigger;
    boolean switchDrive;
    boolean lastswitchDrive;
    boolean lol;
    public AxisButton xbox1_lT = new AxisButton(xbox1, 2, .75, 1);
    public AxisButton xbox2_y1 = new AxisButton(xbox2, 1, .2, 2);
    
    public POVButton xbox1povN = new POVButton(xbox1, 0, 0);
    public POVButton xbox1povNE = new POVButton(xbox1, 0, 45);
    public POVButton xbox1povE = new POVButton(xbox1, 0, 90);
    public POVButton xbox1povSE = new POVButton(xbox1, 0, 135);
    public POVButton xbox1povS = new POVButton(xbox1, 0, 180);
    public POVButton xbox1povSW = new POVButton(xbox1, 0, 225);
    public POVButton xbox1povW = new POVButton(xbox1, 0, 270);
    public POVButton xbox1povNW = new POVButton(xbox1, 0, 315);
    
    public POVButton xbox2povN = new POVButton(xbox2, 0, 0);
    public POVButton xbox2povNE = new POVButton(xbox2, 0, 45);
    public POVButton xbox2povE = new POVButton(xbox2, 0, 90);
    public POVButton xbox2povSE = new POVButton(xbox2, 0, 135);
    public POVButton xbox2povS = new POVButton(xbox2, 0, 180);
    public POVButton xbox2povSW = new POVButton(xbox2, 0, 225);
    public POVButton xbox2povW = new POVButton(xbox2, 0, 270);
    public POVButton xbox2povNW = new POVButton(xbox2, 0, 315);

    public OI() {
    	//	JoystickButton d_up = new JoystickButton(joy, 5);
    	JoystickButton xbox1_a = new JoystickButton(xbox1, 1);
    	JoystickButton xbox1_b = new JoystickButton(xbox1, 2);
    	JoystickButton xbox1_x = new JoystickButton(xbox1, 3);
    	JoystickButton xbox1_y = new JoystickButton(xbox1, 4);
    	JoystickButton xbox1_lb = new JoystickButton(xbox1, 5);
    	JoystickButton xbox1_rb = new JoystickButton(xbox1, 6);
    	JoystickButton xbox1_back = new JoystickButton(xbox1, 7);
    	JoystickButton xbox1_start = new JoystickButton(xbox1, 8);
    	JoystickButton xbox1_leftStickButton = new JoystickButton(xbox1, 9);
    	JoystickButton xbox1_rightStickButton = new JoystickButton(xbox1, 10);
    	//xbox1.getPOV();//0=north, 90=east, 180=south, 45=NE, ect.
    	
    	JoystickButton xbox2_a = new JoystickButton(xbox2, 1);
    	JoystickButton xbox2_b = new JoystickButton(xbox2, 2);
    	JoystickButton xbox2_x = new JoystickButton(xbox2, 3);
    	JoystickButton xbox2_y = new JoystickButton(xbox2, 4);
    	JoystickButton xbox2_lb = new JoystickButton(xbox2, 5);
    	JoystickButton xbox2_rb = new JoystickButton(xbox2, 6);
    	JoystickButton xbox2_back = new JoystickButton(xbox2, 7);
    	JoystickButton xbox2_start = new JoystickButton(xbox2, 8);
    	JoystickButton xbox2_leftStick = new JoystickButton(xbox2, 9);
    	JoystickButton xbox2_rightStick = new JoystickButton(xbox2, 10);
    	
/*    	JoystickButton board_1 = new JoystickButton(board, 1);
    	JoystickButton board_2 = new JoystickButton(board, 2);
    	JoystickButton board_3 = new JoystickButton(board, 3);
    	JoystickButton board_4 = new JoystickButton(board, 4);
    	JoystickButton board_5 = new JoystickButton(board, 5);
    	JoystickButton board_6 = new JoystickButton(board, 6);
    	JoystickButton board_7 = new JoystickButton(board, 7);
    	JoystickButton board_8 = new JoystickButton(board, 8);
    	JoystickButton board_9 = new JoystickButton(board, 9);
    	JoystickButton board_10 = new JoystickButton(board, 10);
  */  	
    	//*****************************************************
    	//Xbox1************************
//    	xbox1_start.whenPressed(new PTOShiftOn());
//    	xbox1_back.whenPressed(new PTOShiftOff());    	
//    	xbox1_lT.whenPressed(new ShiftDriveHigh());
//    	xbox1_lT.whenReleased(new ShiftDriveLow());
    	xbox1_y.whenPressed(new SwitchArcadeDriveDirection());
    	
    	
    	xbox1_x.whenPressed(new Shoot());
    	xbox1_x.whenReleased(new Shoot());
    	
    	xbox1_start.whenPressed(new SetSpeed());
    	
    	xbox1_a.whenPressed(new SaveShooterSpeed(true));//MoveFlyWheel(Robot.shooter.hold));
    	xbox1_a.whenReleased(new SaveShooterSpeed(false));
    	
    	xbox1_b.whenPressed(new Shoot());
    	xbox1_b.whenReleased(new MoveFlyWheel(0));
    	
    	xbox1povN.whenPressed(new MoveFlyWheel(1));
    	xbox1povN.whenReleased(new MoveFlyWheel(0));
    	
    	xbox1povS.whenPressed(new MoveFlyWheel(-1));
    	xbox1povS.whenReleased(new MoveFlyWheel(0));
    	//*****************************************************
    	//Xbox2************************
//    	xbox2_lb.whenPressed(new IntakeIn());
//    	xbox2_lb.whenReleased(new IntakeStopBelt());
    	
//    	xbox2_rb.whenPressed(new IntakeOut());
//    	xbox2_rb.whenReleased(new IntakeStopBelt());
    	
//    	xbox2_y1.whenPressed(new IntakeArmSpeedSet());
//    	xbox2_a.whenPressed(new IntakeToggleNitro());
    	
//    	xbox2_b.whenPressed(new PuncherOut());
//    	xbox2_b.whenReleased(new PuncherIn());
    	
//    	xbox2povN.whenPressed(new ClimberUp());
//    	xbox2povN.whenReleased(new ClimberStopExtention());
    	
//    	xbox2povS.whenPressed(new ClimberDown());
//    	xbox2povS.whenReleased(new ClimberStopExtention());
    }
    
    public void log(){
//    	SmartDashboard.putNumber("leftTrigger", xbox1.getRawAxis(2));
    	SmartDashboard.putNumber("Xbox1 y-axis", xbox1.getRawAxis(1));
//    	SmartDashboard.putNumber("Xbox1 x-axis", xbox1.getRawAxis(4));
//    	SmartDashboard.putData("Reach Defences Auto", new ReachDefencesAuto());
    }
    
    public Joystick getXbox1() {
    	return xbox1;
    }
    public Joystick getXbox2() {
    	return xbox2;
    }
    public Joystick getBoard() {
    	return board;
    }
}