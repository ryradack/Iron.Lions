package org.usfirst.frc.team966.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team966.robot.Robot;
import org.usfirst.frc.team966.robot.commands.TankDriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The DriveTrain subsystem incorporates the sensors and actuators attached to
 * the robots chassis. These include four drive motors, a left and right encoder
 * and a gyro.
 */
public class DriveTrain extends Subsystem {
	private SpeedController left_motor, right_motor, grab_motor_right, grab_motor_left;
	private RobotDrive drive;
	private Encoder left_encoder, right_encoder;
	private AnalogInput rangefinder;
	private Gyro gyro;

	public DriveTrain() {
		super();
		left_motor = new Talon(1);
		right_motor = new Talon(2);
		grab_motor_right = new Talon(3);
		grab_motor_left = new Talon(4);
		drive = new RobotDrive(left_motor, right_motor);
		left_encoder = new Encoder(1, 2);
		right_encoder = new Encoder(3, 4);
		
		// Encoders may measure differently in the real world and in
		// simulation. In this example the robot moves 0.042 barleycorns
		// per tick in the real world, but the simulated encoders
		// simulate 360 tick encoders. This if statement allows for the
		// real robot to handle this difference in devices.
		if (Robot.isReal()) {
			left_encoder.setDistancePerPulse(0.042);
			right_encoder.setDistancePerPulse(0.042);
		} else {
			// Circumference in ft = 4in/12(in/ft)*PI
			left_encoder.setDistancePerPulse((4.0/12.0*Math.PI) / 360.0);
			right_encoder.setDistancePerPulse((4.0/12.0*Math.PI) / 360.0);
		}

		rangefinder = new AnalogInput(6);
		gyro = new Gyro(1);

		// Let's show everything on the LiveWindow
		LiveWindow.addActuator("Drive Train", "Left Motor", (Talon) left_motor);
		LiveWindow.addActuator("Drive Train", "Right Motor", (Talon) right_motor);
		LiveWindow.addActuator("Drive Train","Grabbing Right", (Talon) grab_motor_right);
		LiveWindow.addActuator("DriveTrain", "Grabbing Left", (Talon) grab_motor_left);
		LiveWindow.addSensor("Drive Train", "Left Encoder", left_encoder);
		LiveWindow.addSensor("Drive Train", "Right Encoder", right_encoder);
		LiveWindow.addSensor("Drive Train", "Rangefinder", rangefinder);
		LiveWindow.addSensor("Drive Train", "Gyro", gyro);
	}

	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Left Distance", left_encoder.getDistance());
		SmartDashboard.putNumber("Right Distance", right_encoder.getDistance());
		SmartDashboard.putNumber("Left Speed", left_encoder.getRate());
		SmartDashboard.putNumber("Right Speed", right_encoder.getRate());
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}

	/**
	 * Tank style driving for the DriveTrain. 
	 * @param left Speed in range [-1,1]
	 * @param right Speed in range [-1,1]
	 */
	public void drive(double left, double right) {
		//drive.tankDrive(left, right);
		double deadbandleft=left;	//Left value after considering deadband
		double deadbandright=right;  //Right value after considering deadband
		if(left > -.10 && left < .10){
			deadbandleft=0;
		}
		if(right > -.10 && right < .10){
			deadbandright=0;
		}
		left_motor.set(deadbandleft);
		right_motor.set(deadbandright);
	}
		
	
	/**
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
/**	public void drive(Joystick joy) {
		drive(-joy.getY(), -joy.getAxis(AxisType.kThrottle));
	}*/
	public void drive(Joystick xbox1) {
		drive(-xbox1.getRawAxis(1), xbox1.getRawAxis(5));
	}
/**	public void drive(Joystick xbox2) {
		drive(-xbox2.getY(), -xbox2.getAxis(AxisType.kThrottle));
	}
	/**
	 * @return The robots heading in degrees.
	 */
	public double getHeading() {
		return gyro.getAngle();
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		gyro.reset();
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}
	
	/**
	 * @return The distance to the obstacle detected by the rangefinder. 
	 */
	public double getDistanceToObstacle() {
		// Really meters in simulation since it's a rangefinder...
		return rangefinder.getAverageVoltage();
	}
}
