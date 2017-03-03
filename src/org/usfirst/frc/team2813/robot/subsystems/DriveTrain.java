package org.usfirst.frc.team2813.robot.subsystems;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.commands.OperatorDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public final RobotDrive drive;
	public final Encoder encoder;
	private PIDController ctrl;
	private double pid_P, pid_I, pid_D;

	private enum Mode {
		CARTESIAN, POLAR;
	}

	private Mode mode = Mode.CARTESIAN;
	private double x = 0, y = 0;

	public void initDefaultCommand() {
		SmartDashboard.putNumber("p", 0.0);
		SmartDashboard.putNumber("i", 0.0);
		SmartDashboard.putNumber("d", 0.0);
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new OperatorDrive());
	}

	public DriveTrain() {
		drive = new RobotDrive(0, 1, 2, 3);
		encoder = new Encoder(0, 1);
		Robot.gyro.setPIDSourceType(PIDSourceType.kRate);
		ctrl = new PIDController(0, 0, 0, Robot.gyro, this::drive);
		ctrl.setOutputRange(-1, 1);
	}

	public synchronized void drive(double rotation) {
		if (pid_P != SmartDashboard.getNumber("p", 0.0) || pid_I != SmartDashboard.getNumber("i", 0.0) || pid_D != SmartDashboard.getNumber("d", 0.0)) {
			pid_P = SmartDashboard.getNumber("p", 0.0);
			pid_I = SmartDashboard.getNumber("i", 0.0);
			pid_D = SmartDashboard.getNumber("d", 0.0);
			ctrl.setPID(pid_P, pid_I, pid_D);
		}
		switch (mode) {
		case CARTESIAN:
			drive.mecanumDrive_Cartesian(x, y, rotation, Robot.gyro.getAngle());
		case POLAR:
			drive.mecanumDrive_Polar(x, y - Robot.gyro.getAngle(), rotation);
		}
	}

	public synchronized void mecanumDriveCartesian(double x, double y, double rotation) {
		ctrl.setSetpoint(rotation);
		mode = Mode.CARTESIAN;
		this.x = x;
		this.y = y;
	}

	public synchronized void mecanumDrivePolar(double mag, double angle, double rotation) {
		ctrl.setSetpoint(rotation);
		mode = Mode.POLAR;
		this.x = mag;
		this.y = angle;
	}
}