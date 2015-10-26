/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team966.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger motors, you should probably use a sensor so that the
 * motors don't stall. 
 */
public class Claw extends Subsystem {
    private DoubleSolenoid clawSolenoid;
    private DoubleSolenoid grabberSolenoid;
    
    public Claw() {
        super();
        clawSolenoid = new DoubleSolenoid(2,5);
        grabberSolenoid = new DoubleSolenoid(3,4);

		// Let's show everything on the LiveWindow
        LiveWindow.addActuator("Claw", "Claw Solenoid", clawSolenoid);
        LiveWindow.addActuator("Grabber", "grabber Solenoid", grabberSolenoid);
    }

    public void initDefaultCommand() {}
    public void log() {}
    
    /**
     * Open the claw
     */
    public void clawOpen() {
        clawSolenoid.set(Value.kReverse);
    }
    /**
     * Close the claw
     */
    public void clawClose() {
        clawSolenoid.set(Value.kForward);
    }
    public void grabberOpen() {
        grabberSolenoid.set(Value.kReverse);
    }
    public void grabberClose() {
        grabberSolenoid.set(Value.kForward);
    }

    
    	
    
    
    // Turn off the claw
    public void clawOff(){
    	clawSolenoid.set(Value.kOff);
}
    public void grabberOff(){
    	grabberSolenoid.set(Value.kOff);
    }
}
