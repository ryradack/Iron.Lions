package org.usfirst.frc.team967.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class ShiftButton extends Button {
	Joystick joy;
	int Axis;
	
	public ShiftButton(Joystick stick, int axis){
		joy = stick;
		Axis = axis;
	}
	
	public boolean get(){
		if(joy.getRawAxis(Axis) > .75){
			return true;
		}	
		else{
			return false;
		} 
	}
}
