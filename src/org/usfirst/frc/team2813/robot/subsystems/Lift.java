package org.usfirst.frc.team2813.robot.subsystems;

import org.usfirst.frc.team2813.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;

public class Lift extends MotorSubsystem {
	// public final Encoder encoder;

	public Lift() {
		super(Spark.class, RobotMap.liftPort, "Lift");
		// encoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB);
		// encoder.setDistancePerPulse(2 / 360);
		// 2mm per rotation, 360 pulses per rotation, 2/360 mm per pulse
	}
}