package org.usfirst.frc.team967.robot;

import org.usfirst.frc.team967.robot.commands.ClimberDown;
import org.usfirst.frc.team967.robot.commands.ClimberUp;
import org.usfirst.frc.team967.robot.commands.IntakeIn;
import org.usfirst.frc.team967.robot.commands.IntakeOut;
import org.usfirst.frc.team967.robot.commands.PTOShiftOff;
import org.usfirst.frc.team967.robot.commands.PTOShiftOn;
import org.usfirst.frc.team967.robot.commands.ShiftDriveHigh;
import org.usfirst.frc.team967.robot.commands.ShiftDriveLow;
import org.usfirst.frc.team967.robot.commands.SwitchArcadeDriveDirection;

//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OI {
    private Joystick xbox1 = new Joystick(0);
    private Joystick xbox2 = new Joystick(1);
    private Joystick board = new Joystick(2);
    double leftTrigger;
    double rightTrigger;
    boolean switchDrive;
    boolean lastswitchDrive;
    boolean lol;
    public ShiftButton xbox1_lT = new ShiftButton(xbox1, 2);
    
    public POVButton xbox1povN = new POVButton(xbox1, 0, 0);
    public POVButton xbox1povE = new POVButton(xbox1, 0, 90);
    public POVButton xbox1povS = new POVButton(xbox1, 0, 180);
    public POVButton xbox1povW = new POVButton(xbox1, 0, 270);
    
    public POVButton xbox2povN = new POVButton(xbox2, 0, 0);
    public POVButton xbox2povNE = new POVButton(xbox2, 0, 45);
    public POVButton xbox2povE = new POVButton(xbox2, 0, 90);
    public POVButton xbox2povSE = new POVButton(xbox2, 0, 135);
    public POVButton xbox2povS = new POVButton(xbox2, 0, 180);
    public POVButton xbox2povSW = new POVButton(xbox2, 0, 225);
    public POVButton xbox2povW = new POVButton(xbox2, 0, 270);
    public POVButton xbox2povNW = new POVButton(xbox2, 0, 315);
    
//    boolean[] xbox2arr = new boolean[12];
//    boolean[] xbox1arrPOV = new boolean[8];
//    boolean[] xbox2arrPOV = new boolean[8];
//    boolean[] boardarr = new boolean[12];

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
    	
    	JoystickButton board_1 = new JoystickButton(board, 1);
    	JoystickButton board_2 = new JoystickButton(board, 2);
    	JoystickButton board_3 = new JoystickButton(board, 3);
    	JoystickButton board_4 = new JoystickButton(board, 4);
    	JoystickButton board_5 = new JoystickButton(board, 5);
    	JoystickButton board_6 = new JoystickButton(board, 6);
    	JoystickButton board_7 = new JoystickButton(board, 7);
    	JoystickButton board_8 = new JoystickButton(board, 8);
    	JoystickButton board_9 = new JoystickButton(board, 9);
    	JoystickButton board_10 = new JoystickButton(board, 10);
    	
    	//*****************************************************
    	//Xbox1************************
    	xbox1_start.whenPressed(new PTOShiftOn());
    	xbox1_back.whenPressed(new PTOShiftOff());    	
    	xbox1_lT.whenPressed(new ShiftDriveHigh());
    	xbox1_lT.whenReleased(new ShiftDriveLow());
    	xbox1_y.whenPressed(new SwitchArcadeDriveDirection());
    	
    	//*****************************************************
    	//Xbox2************************
    	xbox2_lb.whenPressed(new IntakeIn());
    	xbox2_rb.whenPressed(new IntakeOut());
    	
//    	xbox2_y.whenPressed(new ClimberUp());//would like to use POV pad
    	xbox1povN.whenPressed(new ClimberUp());
    	xbox1povS.whenPressed(new ClimberDown());
    }
    
    public void log(){
    	SmartDashboard.putNumber("leftTrigger", xbox1.getRawAxis(2));
    	SmartDashboard.putNumber("Xbox1 y-axis", xbox1.getRawAxis(1));
    	SmartDashboard.putNumber("Xbox1 x-axis", xbox1.getRawAxis(4));
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

    
    //***********************************************
    // Axis for 2 xbox controllers and one board
    /*
    public double xbox1_x1() {
    	return xbox1.getRawAxis(0);
    }
    public double xbox1_y1() {
    	return xbox1.getRawAxis(1);
    }
    public double xbox1_lT() {
    	return xbox1.getRawAxis(2);
    }
    public double xbox1_rT() {
    	return xbox1.getRawAxis(3);
    }
    public double xbox1_x2() {
    	return xbox1.getRawAxis(4);
    }
    public double xbox1_y2() {
    	return xbox1.getRawAxis(5);
    }
    public double xbox2_x1() {
    	return xbox2.getRawAxis(0);
    }
    public double xbox2_y1() {
    	return xbox2.getRawAxis(1);
    }
    public double xbox2_lT() {
    	return xbox2.getRawAxis(2);
    }
    public double xbox2_rT() {
    	return xbox2.getRawAxis(3);
    }
    public double xbox2_x2() {
    	return xbox2.getRawAxis(4);
    }
    public double xbox2_y2() {
    	return xbox2.getRawAxis(5);
    }
    //************************************
    //
    // Buttons on xbox1 controller
    // True if pressed, false if released
    public boolean xbox1_a() {
    	if (!xbox1.getRawButton(1)){
    		xbox1arr[0] = false;
    	}
    	return xbox1.getRawButton(1);
    }
    public boolean xbox1_b() {
    	if (!xbox1.getRawButton(2)){
    		xbox1arr[1] = false;
    	}
    	return xbox1.getRawButton(2);
    }
    public boolean xbox1_x() {
    	if (!xbox1.getRawButton(3)){
    		xbox1arr[2] = false;
    	}
    	return xbox1.getRawButton(3);
    }
    public boolean xbox1_y() {
    	if (!xbox1.getRawButton(4)){
    		xbox1arr[3] = false;
    	}
    	return xbox1.getRawButton(4);
    }
    public boolean xbox1_rb() {
    	if (!xbox1.getRawButton(5)){
    		xbox1arr[4] = false;
    	}
    	return xbox1.getRawButton(5);
    }
    public boolean xbox1_lb() {
    	if (!xbox1.getRawButton(6)){
    		xbox1arr[5] = false;
    	}
    	return xbox1.getRawButton(6);
    }
    public boolean xbox1_back() {
    	if (!xbox1.getRawButton(7)){
    		xbox1arr[6] = false;
    	}
    	return xbox1.getRawButton(7);
    }
    public boolean xbox1_start() {
    	if (!xbox1.getRawButton(8)){
    		xbox1arr[7] = false;
    	}
    	return xbox1.getRawButton(8);
    }
    public boolean xbox1_lClick() {
    	if (!xbox1.getRawButton(9)){
    		xbox1arr[8] = false;
    	}
    	return xbox1.getRawButton(9);
    }
    public boolean xbox1_rClick() {
    	if (!xbox1.getRawButton(10)){
    		xbox1arr[9] = false;
    	}
    	return xbox1.getRawButton(10);
    }
    //********************************************
    //
    //Tapped functions for buttons on xbox1
    public boolean xbox1_aTapped() {
    	if(!xbox1.getRawButton(1)){
    		xbox1arr[0] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[0]){
    			xbox1arr[0] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_bTapped() {
    	if(!xbox1.getRawButton(2)){
    		xbox1arr[1] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[1]){
    			xbox1arr[1] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_xTapped() {
    	if(!xbox1.getRawButton(3)){
    		xbox1arr[2] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[2]){
    			xbox1arr[2] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_yTapped() {
    	if(!xbox1.getRawButton(4)){
    		xbox1arr[3] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[3]){
    			xbox1arr[3] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_lBTapped() {
    	if(!xbox1.getRawButton(5)){
    		xbox1arr[4] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[4]){
    			xbox1arr[4] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_rBTapped() {
    	if(!xbox1.getRawButton(6)){
    		xbox1arr[5] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[5]){
    			xbox1arr[5] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_backTapped() {
    	if(!xbox1.getRawButton(7)){
    		xbox1arr[6] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[6]){
    			xbox1arr[6] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_startTapped() {
    	if(!xbox1.getRawButton(8)){
    		xbox1arr[7] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[7]){
    			xbox1arr[7] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_lClickTapped() {
    	if(!xbox1.getRawButton(9)){
    		xbox1arr[8] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[8]){
    			xbox1arr[8] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_rClickTapped() {
    	if(!xbox1.getRawButton(10)){
    		xbox1arr[9] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[9]){
    			xbox1arr[9] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_lTapped() {
    	if(xbox1.getRawAxis(2) <= .50){
    		xbox1arr[10] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[10]){
    			xbox1arr[10] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_rTapped() {
    	if(xbox1.getRawAxis(3) <= .50){
    		xbox1arr[11] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[11]){
    			xbox1arr[11] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    //************************************************
    //
    //POV for xbox1
    int xbox1_POV(){
    	return xbox1.getPOV();
    }
    public boolean xbox1_POVN() {
    	if (xbox1.getPOV()!=0){
    		xbox1arrPOV[0] = false;
    	}
    	return xbox1.getPOV() == 0;
    }
    public boolean xbox1_POVNE() {
    	if (xbox1.getPOV()!=45){
    		xbox1arrPOV[1] = false;
    	}
    	return xbox1.getPOV() == 45;
    }
    public boolean xbox1_POVE() {
    	if (xbox1.getPOV()!=90){
    		xbox1arrPOV[2] = false;
    	}
    	return xbox1.getPOV() == 90;
    }
    public boolean xbox1_POVSE() {
    	if (xbox1.getPOV()!=135){
    		xbox1arrPOV[3] = false;
    	}
    	return xbox1.getPOV() == 135;
    }
    public boolean xbox1_POVS() {
    	if (xbox1.getPOV()!=180){
    		xbox1arrPOV[4] = false;
    	}
    	return xbox1.getPOV() == 180;
    }
    public boolean xbox1_POVSW() {
    	if (xbox1.getPOV()!=225){
    		xbox1arrPOV[5] = false;
    	}
    	return xbox1.getPOV() == 225;
    }
    public boolean xbox1_POVW() {
    	if (xbox1.getPOV()!=270){
    		xbox1arrPOV[6] = false;
    	}
    	return xbox1.getPOV() == 270;
    }
    public boolean xbox1_POVNW() {
    	if (xbox1.getPOV()!=315){
    		xbox1arrPOV[7] = false;
    	}
    	return xbox1.getPOV() == 315;
    }
    //***************************************
    //
    //POV tapped xbox1
    public boolean xbox1_POVNTapped() {
    	if (xbox1.getPOV()!=0){
    		xbox1arrPOV[0] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[0]){
    			xbox1arrPOV[0] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_POVNETapped() {
    	if (xbox1.getPOV()!=45){
    		xbox1arrPOV[1] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[1]){
    			xbox1arrPOV[1] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_POVETapped() {
    	if (xbox1.getPOV()!=90){
    		xbox1arrPOV[2] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[2]){
    			xbox1arrPOV[2] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_POVSETapped() {
    	if (xbox1.getPOV()!=135){
    		xbox1arrPOV[3] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[3]){
    			xbox1arrPOV[3] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_POVSTapped() {
    	if (xbox1.getPOV()!=180){
    		xbox1arrPOV[4] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[4]){
    			xbox1arrPOV[4] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_POVSWTapped() {
    	if (xbox1.getPOV()!=225){
    		xbox1arrPOV[5] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[5]){
    			xbox1arrPOV[5] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox1_POVWTapped() {
    	if (xbox1.getPOV()!=270){
    		xbox1arrPOV[6] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[6]){
    			xbox1arrPOV[6] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    //hiel stan lod of darkness
    public boolean xbox1_POVNWTapped() {
    	if (xbox1.getPOV()!=315){
    		xbox1arrPOV[7] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arrPOV[7]){
    			xbox1arrPOV[7] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
  //************************************
  //
  // Buttons on xbox2 controller
  // True if pressed, false if released
    public boolean xbox2_a() {
    	if (!xbox2.getRawButton(1)){
    		xbox2arr[0] = false;
    	}
    	return xbox2.getRawButton(1);
    }
    public boolean xbox2_b() {
    	if (!xbox2.getRawButton(2)){
    		xbox2arr[1] = false;
    	}
    	return xbox2.getRawButton(2);
    }
    public boolean xbox2_x() {
    	if (!xbox2.getRawButton(3)){
    		xbox2arr[2] = false;
    	}
    	return xbox2.getRawButton(3);
    }
    public boolean xbox2_y() {
    	if (!xbox2.getRawButton(4)){
    		xbox2arr[3] = false;
    	}
    	return xbox2.getRawButton(4);
    }
    public boolean xbox2_rb() {
    	if (!xbox2.getRawButton(5)){
    		xbox2arr[4] = false;
    	}
    	return xbox2.getRawButton(5);
    }
    public boolean xbox2_lb() {
    	if (!xbox2.getRawButton(6)){
    		xbox2arr[5] = false;
    	}
    	return xbox2.getRawButton(6);
    }
    public boolean xbox2_back() {
    	if (!xbox2.getRawButton(7)){
    		xbox2arr[6] = false;
    	}
    	return xbox2.getRawButton(7);
    }
    public boolean xbox2_start() {
    	if (!xbox2.getRawButton(8)){
    		xbox2arr[7] = false;
    	}
    	return xbox2.getRawButton(8);
    }
    public boolean xbox2_lClick() {
    	if (!xbox2.getRawButton(9)){
    		xbox2arr[8] = false;
    	}
    	return xbox2.getRawButton(9);
    }
    public boolean xbox2_rClick() {
    	if (!xbox2.getRawButton(10)){
    		xbox2arr[9] = false;
    	}
    	return xbox2.getRawButton(10);
    }
    //******************************************
    //
    //
    //Tapped functions for buttons on xbox2
    public boolean xbox2_aTapped() {
    	if(!xbox2.getRawButton(1)){
    		xbox2arr[0] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[0]){
    			xbox2arr[0] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_bTapped() {
    	if(!xbox2.getRawButton(2)){
    		xbox2arr[1] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[1]){
    			xbox2arr[1] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_xTapped() {
    	if(!xbox2.getRawButton(3)){
    		xbox2arr[2] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[2]){
    			xbox2arr[2] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_yTapped() {
    	if(!xbox2.getRawButton(4)){
    		xbox2arr[3] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[3]){
    			xbox2arr[3] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_lBTapped() {
    	if(!xbox2.getRawButton(5)){
    		xbox2arr[4] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[4]){
    			xbox2arr[4] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_rBTapped() {
    	if(!xbox2.getRawButton(6)){
    		xbox2arr[5] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[5]){
    			xbox2arr[5] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_backTapped() {
    	if(!xbox2.getRawButton(7)){
    		xbox2arr[6] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[6]){
    			xbox2arr[6] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_startTapped() {
    	if(!xbox2.getRawButton(8)){
    		xbox2arr[7] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[7]){
    			xbox2arr[7] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_lClickTapped() {
    	if(!xbox2.getRawButton(9)){
    		xbox2arr[8] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[8]){
    			xbox2arr[8] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_rClickTapped() {
    	if(!xbox2.getRawButton(10)){
    		xbox2arr[9] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arr[9]){
    			xbox2arr[9] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_lTapped() {
    	if(xbox1.getRawAxis(2) <= .50){
    		xbox1arr[10] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[10]){
    			xbox1arr[10] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_rTapped() {
    	if(xbox1.getRawAxis(3) <= .50){
    		xbox1arr[11] = false;
    		return false;
    	}
    	else {
    		if (!xbox1arr[11]){
    			xbox1arr[11] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }    
    //************************************************
    //
    //POV for xbox2
    int xbox2_POV(){
    	return xbox2.getPOV();
    }
    public boolean xbox2_POVN() {
    	if (xbox2.getPOV()!=0){
    		xbox2arrPOV[0] = false;
    	}
    	return xbox2.getPOV() == 0;
    }
    public boolean xbox2_POVNE() {
    	if (xbox2.getPOV()!=45){
    		xbox2arrPOV[1] = false;
    	}
    	return xbox2.getPOV() == 45;
    }
    public boolean xbox2_POVE() {
    	if (xbox2.getPOV()!=90){
    		xbox2arrPOV[2] = false;
    	}
    	return xbox2.getPOV() == 90;
    }
    public boolean xbox2_POVSE() {
    	if (xbox2.getPOV()!=135){
    		xbox2arrPOV[3] = false;
    	}
    	return xbox2.getPOV() == 135;
    }
    public boolean xbox2_POVS() {
    	if (xbox2.getPOV()!=180){
    		xbox2arrPOV[4] = false;
    	}
    	return xbox2.getPOV() == 180;
    }
    public boolean xbox2_POVSW() {
    	if (xbox2.getPOV()!=225){
    		xbox2arrPOV[5] = false;
    	}
    	return xbox2.getPOV() == 225;
    }
    public boolean xbox2_POVW() {
    	if (xbox2.getPOV()!=270){
    		xbox2arrPOV[6] = false;
    	}
    	return xbox2.getPOV() == 270;
    }
    public boolean xbox2_POVNW() {
    	if (xbox2.getPOV()!=315){
    		xbox2arrPOV[7] = false;
    	}
    	return xbox2.getPOV() == 315;
    }
    //***************************************
    //
    //POV tapped xbox2
    public boolean xbox2_POVNTapped() {
    	if (xbox2.getPOV()!=0){
    		xbox2arrPOV[0] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[0]){
    			xbox2arrPOV[0] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVNETapped() {
    	if (xbox2.getPOV()!=45){
    		xbox2arrPOV[1] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[1]){
    			xbox2arrPOV[1] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVETapped() {
    	if (xbox2.getPOV()!=90){
    		xbox2arrPOV[2] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[2]){
    			xbox2arrPOV[2] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVSETapped() {
    	if (xbox2.getPOV()!=135){
    		xbox2arrPOV[3] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[3]){
    			xbox2arrPOV[3] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVSTapped() {
    	if (xbox2.getPOV()!=180){
    		xbox2arrPOV[4] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[4]){
    			xbox2arrPOV[4] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVSWTapped() {
    	if (xbox2.getPOV()!=225){
    		xbox2arrPOV[5] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[5]){
    			xbox2arrPOV[5] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVWTapped() {
    	if (xbox2.getPOV()!=270){
    		xbox2arrPOV[6] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[6]){
    			xbox2arrPOV[6] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }
    public boolean xbox2_POVNWTapped() {
    	if (xbox2.getPOV()!=315){
    		xbox2arrPOV[7] = false;
    		return false;
    	}
    	else {
    		if (!xbox2arrPOV[7]){
    			xbox2arrPOV[7] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    }*/
}