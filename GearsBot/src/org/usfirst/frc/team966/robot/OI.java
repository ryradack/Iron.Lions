
package org.usfirst.frc.team966.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team966.robot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick xbox1 = new Joystick(0);
    private Joystick xbox2 = new Joystick(1);
    private Joystick board = new Joystick(2);
    
    boolean[] Xbox1arr = new boolean[12];
    boolean[] Xbox2arr = new boolean[12];
    boolean[] Xbox1arrPOV = new boolean[8];
    boolean[] Xbox2arrPOV = new boolean[8];
    boolean[] Boardarr = new boolean[12];
    
    
    
    //boolean tappedArray_xbox1[12]{false,false,false,false,false,false,false,false,false,false,false,false}; 
    public OI() {
    	// Put Some buttons on the SmartDashboard
//        SmartDashboard.putData("Elevator Bottom", new SetElevatorSetpoint(0));
//        SmartDashboard.putData("Elevator Platform", new SetElevatorSetpoint(0.2));
//        SmartDashboard.putData("Elevator Top", new SetElevatorSetpoint(0.3));
        
   //     SmartDashboard.putData("Wrist Horizontal", new SetWristSetpoint(0));
   //     SmartDashboard.putData("Raise Wrist", new SetWristSetpoint(-45));
        
        SmartDashboard.putData("Open Claw", new OpenClaw());
        SmartDashboard.putData("Close Claw", new CloseClaw());
        
        SmartDashboard.putData("Deliver Soda", new Autonomous());
        
        // Create some buttons    
        
        /** Connect the buttons to commands
        d_up.whenPressed(new SetElevatorSetpoint(0.2));
        d_down.whenPressed(new SetElevatorSetpoint(-0.2));
        d_right.whenPressed(new CloseClaw());
        d_left.whenPressed(new OpenClaw());
        
        r1.whenPressed(new PrepareToPickup());
        r2.whenPressed(new Pickup());
        l1.whenPressed(new Place());
        l2.whenPressed(new Autonomous());*/
    }

    
    public Joystick getJoystick(){
        return xbox1;
	}
    public double xbox1_y1() {
    	return xbox1.getRawAxis(1);
    }
    public double xbox1_x1() {
    	return xbox1.getRawAxis(0);
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
    public boolean xbox1_a() {
    	if (!xbox1.getRawButton(1)){
    		Xbox1arr[0] = false;
    	}
    	return xbox1.getRawButton(1);
    }
    public boolean xbox1_b() {
    	if (!xbox1.getRawButton(2)){
    		Xbox1arr[1] = false;
    	}
    	return xbox1.getRawButton(2);
    }
    public boolean xbox1_x() {
    	if (!xbox1.getRawButton(3)){
    		Xbox1arr[2] = false;
    	}
    	return xbox1.getRawButton(3);
    }
    boolean xbox1_y() {
    	if (!xbox1.getRawButton(4)){
    		Xbox1arr[3] = false;
    	}
    	return xbox1.getRawButton(4);
    }
    public boolean xbox1_rb() {
    	if (!xbox1.getRawButton(6)){
    		Xbox1arr[5] = false;
    	}
    	return xbox1.getRawButton(6);
    }
    public boolean xbox1_lb() {
    	if (!xbox1.getRawButton(5)){
    		Xbox1arr[4] = false;
    	}
    	return xbox1.getRawButton(5);
    }
    public boolean xbox1_back() {
    	if (!xbox1.getRawButton(7)){
    		Xbox1arr[6] = false;
    	}
    	return xbox1.getRawButton(7);
    }
    public boolean xbox1_start() {
    	if (!xbox1.getRawButton(8)){
    		Xbox1arr[7] = false;
    	}
    	return xbox1.getRawButton(8);
    }
    public boolean xbox1_lClick() {
    	if (!xbox1.getRawButton(9)){
    		Xbox1arr[8] = false;
    	}
    	return xbox1.getRawButton(9);
    }
    public boolean xbox1_rClick() {
    	if (!xbox1.getRawButton(10)){
    		Xbox1arr[9] = false;
    	}
    	return xbox1.getRawButton(10);
    }
    public boolean xbox1_aTapped() {
    	if(!xbox1.getRawButton(1)){
    		Xbox1arr[0] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[0]){
    			Xbox1arr[0] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_bTapped() {
    	if(!xbox1.getRawButton(2)){
    		Xbox1arr[1] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[1]){
    			Xbox1arr[1] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_xTapped() {
    	if(!xbox1.getRawButton(3)){
    		Xbox1arr[2] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[2]){
    			Xbox1arr[2] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_yTapped() {
    	if(!xbox1.getRawButton(4)){
    		Xbox1arr[3] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[3]){
    			Xbox1arr[3] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_lBTapped() {
    	if(!xbox1.getRawButton(5)){
    		Xbox1arr[4] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[4]){
    			Xbox1arr[4] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_rBTapped() {
    	if(!xbox1.getRawButton(6)){
    		Xbox1arr[5] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[5]){
    			Xbox1arr[5] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_backTapped() {
    	if(!xbox1.getRawButton(7)){
    		Xbox1arr[6] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[6]){
    			Xbox1arr[6] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_startTapped() {
    	if(!xbox1.getRawButton(8)){
    		Xbox1arr[7] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[7]){
    			Xbox1arr[7] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_lClickTapped() {
    	if(!xbox1.getRawButton(9)){
    		Xbox1arr[8] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[8]){
    			Xbox1arr[8] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_rClickTapped() {
    	if(!xbox1.getRawButton(10)){
    		Xbox1arr[9] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[9]){
    			Xbox1arr[9] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_lTTapped() {
    	if(xbox1.getRawAxis(2) <= .50){
    		Xbox1arr[10] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[10]){
    			Xbox1arr[10] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox1_rTTapped() {
    	if(xbox1.getRawAxis(3) <= .50){
    		Xbox1arr[11] = false;
    		return false;
    	}
    	else {
    		if (!Xbox1arr[11]){
    			Xbox1arr[11] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    int xbox1_POV(){
    	return xbox1.getPOV();
    }
    public boolean xbox1_POVN() {
    	if (xbox1.getPOV()!=0){
    		Xbox1arrPOV[0] = false;
    	}
    	return xbox1.getPOV()==0;
    }
    public boolean xbox1_POVNE() {
    	if (xbox1.getPOV()!=45){
    		Xbox1arrPOV[1] = false;
    	}
    	return xbox1.getPOV()==45;
    }
    public boolean xbox1_POVE() {
    	if (xbox1.getPOV()!=90){
    		Xbox1arrPOV[2] = false;
    	}
    	return xbox1.getPOV()==90;
    }
    public boolean xbox1_POVSE() {
    	if (xbox1.getPOV()!=135){
    		Xbox1arrPOV[3] = false;
    	}
    	return xbox1.getPOV()==135;
    }
    public boolean xbox1_POVS() {
    	if (xbox1.getPOV()!=180){
    		Xbox1arrPOV[4] = false;
    	}
    	return xbox1.getPOV()==180;
    }
    public boolean xbox1_POVSW() {
    	if (xbox1.getPOV()!=225){
    		Xbox1arrPOV[5] = false;
    	}
    	return xbox1.getPOV()==255;
    }
    public boolean xbox1_POVW() {
    	if (xbox1.getPOV()!=270){
    		Xbox1arrPOV[6] = false;
    	}
    	return xbox1.getPOV()==270;
    }
    public boolean xbox1_POVNW() {
    	if (xbox1.getPOV()!=315){
    		Xbox1arrPOV[7] = false;
    	}
    	return xbox1.getPOV()==315;
    }
    public boolean xbox1_POVNTapped() {
    	if (xbox1.getPOV()!=0){
    		Xbox1arrPOV[0] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[0]){
    			Xbox1arrPOV[0] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVNETapped() {
    	if (xbox1.getPOV()!=45){
    		Xbox1arrPOV[1] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[1]){
    			Xbox1arrPOV[1] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVETapped() {
    	if (xbox1.getPOV()!=90){
    		Xbox1arrPOV[2] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[2]){
    			Xbox1arrPOV[2] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVSETapped() {
    	if (xbox1.getPOV()!=135){
    		Xbox1arrPOV[3] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[3]){
    			Xbox1arrPOV[3] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVSTapped() {
    	if (xbox1.getPOV()!=180){
    		Xbox1arrPOV[4] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[4]){
    			Xbox1arrPOV[4] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVSWTapped() {
    	if (xbox1.getPOV()!=225){
    		Xbox1arrPOV[5] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[5]){
    			Xbox1arrPOV[5] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVWTapped() {
    	if (xbox1.getPOV()!=270){
    		Xbox1arrPOV[6] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[6]){
    			Xbox1arrPOV[6] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox1_POVNWTapped() {
    	if (xbox1.getPOV()!=315){
    		Xbox1arrPOV[7] = false;
    		return false;
    	}
    	else{
    		if (!Xbox1arrPOV[7]){
    			Xbox1arrPOV[7] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    
// 2nd xbox conroller************************************************************************    
    public boolean xbox2_a() {
    	if (!xbox2.getRawButton(1)){
    		Xbox2arr[0] = false;
    	}
    	return xbox2.getRawButton(1);
    }
    public boolean xbox2_b() {
    	if (!xbox2.getRawButton(2)){
    		Xbox2arr[1] = false;
    	}
    	return xbox2.getRawButton(2);
    }
    public boolean xbox2_x() {
    	if (!xbox2.getRawButton(4)){
    		Xbox2arr[3] = false;
    	}
    	return xbox2.getRawButton(4);
    }
    public boolean xbox2_y() {
    	if (!xbox2.getRawButton(5)){
    		Xbox2arr[4] = false;
    	}
    	return xbox2.getRawButton(5);
    }
    public boolean xbox2_rb() {
    	if (!xbox2.getRawButton(6)){
    		Xbox2arr[5] = false;
    	}
    	return xbox2.getRawButton(6);
    }
    public boolean xbox2_lb() {
    	if (!xbox2.getRawButton(5)){
    		Xbox2arr[4] = false;
    	}
    	return xbox2.getRawButton(5);
    }
    public boolean xbox2_back() {
    	if (!xbox2.getRawButton(7)){
    		Xbox2arr[6] = false;
    	}
    	return xbox2.getRawButton(7);
    }
    public boolean xbox2_start() {
    	if (!xbox2.getRawButton(8)){
    		Xbox2arr[7] = false;
    	}
    	return xbox2.getRawButton(8);
    }
    public boolean xbox2_lClick() {
    	if (!xbox2.getRawButton(9)){
    		Xbox2arr[8] = false;
    	}
    	return xbox2.getRawButton(9);
    }
    public boolean xbox2_rClick() {
    	if (!xbox2.getRawButton(10)){
    		Xbox2arr[9] = false;
    	}
    	return xbox2.getRawButton(10);
    }
    public boolean xbox2_lTTapped() {
    	if(xbox2.getRawAxis(2) <= .50){
    		Xbox2arr[10] = false;
    		return false;
    	}
    	else {
    		if (!Xbox2arr[10]){
    			Xbox2arr[10] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    public boolean xbox2_rTTapped() {
    	if(xbox2.getRawAxis(3) <= .50){
    		Xbox2arr[11] = false;
    		return false;
    	}
    	else {
    		if (!Xbox2arr[11]){
    			Xbox2arr[11] = true;
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	//return false;
    }
    int xbox2_POV(){
    	return xbox2.getPOV();
    }
    public boolean xbox2_POVN() {
    	if (xbox2.getPOV()!=0){
    		Xbox2arrPOV[0] = false;
    	}
    	return xbox2.getPOV()==0;
    }
    public boolean xbox2_POVNE() {
    	if (xbox2.getPOV()!=45){
    		Xbox2arrPOV[1] = false;
    	}
    	return xbox2.getPOV()==45;
    }
    public boolean xbox2_POVE() {
    	if (xbox2.getPOV()!=90){
    		Xbox2arrPOV[2] = false;
    	}
    	return xbox2.getPOV()==90;
    }
    public boolean xbox2_POVSE() {
    	if (xbox2.getPOV()!=135){
    		Xbox2arrPOV[3] = false;
    	}
    	return xbox2.getPOV()==135;
    }
    public boolean xbox2_POVS() {
    	if (xbox2.getPOV()!=180){
    		Xbox2arrPOV[4] = false;
    	}
    	return xbox2.getPOV()==180;
    }
    public boolean xbox2_POVSW() {
    	if (xbox2.getPOV()!=225){
    		Xbox2arrPOV[5] = false;
    	}
    	return xbox2.getPOV()==255;
    }
    public boolean xbox2_POVW() {
    	if (xbox2.getPOV()!=270){
    		Xbox2arrPOV[6] = false;
    	}
    	return xbox2.getPOV()==270;
    }
    public boolean xbox2_POVNW() {
    	if (xbox2.getPOV()!=315){
    		Xbox2arrPOV[7] = false;
    	}
    	return xbox2.getPOV()==315;
    }
    public boolean xbox2_POVNTapped() {
    	if (xbox2.getPOV()!=0){
    		Xbox2arrPOV[0] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[0]){
    			Xbox2arrPOV[0] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVNETapped() {
    	if (xbox2.getPOV()!=45){
    		Xbox2arrPOV[1] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[1]){
    			Xbox2arrPOV[1] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVETapped() {
    	if (xbox2.getPOV()!=90){
    		Xbox1arrPOV[2] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[2]){
    			Xbox2arrPOV[2] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVSETapped() {
    	if (xbox2.getPOV()!=135){
    		Xbox2arrPOV[3] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[3]){
    			Xbox2arrPOV[3] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVSTapped() {
    	if (xbox2.getPOV()!=180){
    		Xbox2arrPOV[4] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[4]){
    			Xbox2arrPOV[4] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVSWTapped() {
    	if (xbox2.getPOV()!=225){
    		Xbox2arrPOV[5] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[5]){
    			Xbox2arrPOV[5] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVWTapped() {
    	if (xbox2.getPOV()!=270){
    		Xbox2arrPOV[6] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[6]){
    			Xbox2arrPOV[6] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    public boolean xbox2_POVNWTapped() {
    	if (xbox2.getPOV()!=315){
    		Xbox2arrPOV[7] = false;
    		return false;
    	}
    	else{
    		if (!Xbox2arrPOV[7]){
    			Xbox2arrPOV[7] = true;
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    //	return false;
    }
    
}

/**
 * boolean xbox1_a(){
        	if (!xbox1.getRawButton(1)){
        		tappedArrayXbox1[0] = false;
        	}
        	return xbox1.getRawButton(1);
        }
 * 
 * 
 *         JoystickButton xbox1_y = new JoystickButton(xbox1, 4);
        JoystickButton xbox1_x = new JoystickButton(xbox1, 3);
        JoystickButton xbox1_a = new JoystickButton(xbox1, 1);
        JoystickButton xbox1_b = new JoystickButton(xbox1, 2);
        JoystickButton xbox1_rb = new JoystickButton(xbox1, 6);
        JoystickButton xbox1_lb = new JoystickButton(xbox1, 5);
        JoystickButton xbox1_back = new JoystickButton(xbox1, 7);
        JoystickButton xbox1_start = new JoystickButton(xbox1, 8);

        JoystickButton xbox2_y = new JoystickButton(xbox1, 4);
        JoystickButton xbox2_x = new JoystickButton(xbox1, 3);
        JoystickButton xbox2_a = new JoystickButton(xbox1, 1);
        JoystickButton xbox2_b = new JoystickButton(xbox1, 2);
        JoystickButton xbox2_rb = new JoystickButton(xbox1, 6);
        JoystickButton xbox2_lb = new JoystickButton(xbox1, 5);
        JoystickButton xbox2_back = new JoystickButton(xbox1, 7);
        JoystickButton xbox2_start = new JoystickButton(xbox1, 8);
        
        JoystickButton board1 = new JoystickButton(board, 1);
        JoystickButton board2 = new JoystickButton(board, 2);
        JoystickButton board3 = new JoystickButton(board, 3);
        JoystickButton board4 = new JoystickButton(board, 4);
        JoystickButton board5 = new JoystickButton(board, 5);
        JoystickButton board6 = new JoystickButton(board, 6);
        JoystickButton board7 = new JoystickButton(board, 7);
        JoystickButton board8 = new JoystickButton(board, 8);
        JoystickButton board9 = new JoystickButton(board, 9);
        JoystickButton board10 = new JoystickButton(board, 10);
        JoystickButton board11 = new JoystickButton(board, 11);
        JoystickButton board12 = new JoystickButton(board, 12);
        */


