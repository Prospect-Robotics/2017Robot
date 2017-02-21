package org.usfirst.frc.team2813.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MotorSubsystem extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public final SpeedController motor;

	public MotorSubsystem(SpeedController motor, String name) {
		super(name);
		this.motor = motor;
	}

	public MotorSubsystem(Class<? extends SpeedController> motorType, int motorPort, String name) {
		super(name);
		try {
			motor = motorType.getConstructor(Integer.TYPE).newInstance(motorPort);
		} catch (Exception e) {
			Error err = new Error("Constructor call failed");
			err.initCause(e);
			throw err;
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void set(double speed) {
		motor.set(speed);
	}
}