package org.usfirst.frc.team967.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class POVButton extends Button {
	Joystick joy;
	int POV;
	int Direction;
	
	public POVButton(Joystick stick, int pov, int direction){
		joy = stick;
		POV = pov;
		Direction = direction;
	}
	public boolean get(){
		if(joy.getPOV(POV) == Direction){
			return true;
		}
		else {
			return false;
		}
	}
/*	public boolean getNorth(){
		if(joy.getPOV(POV) == 0){
			return true;
		}	
		else{
			return false;
		} 
	}
	public boolean getEast(){
		if(joy.getPOV(POV) == 90){
			return true;
		}	
		else{
			return false;
		} 
	}
	public boolean getSouth(){
		if(joy.getPOV(POV) == 180){
			return true;
		}	
		else{
			return false;
		} 
	}
	public boolean getWest(){
		if(joy.getPOV(POV) == 270){
			return true;
		}	
		else{
			return false;
		} 
	}*/
}
