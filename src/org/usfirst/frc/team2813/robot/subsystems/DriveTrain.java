package org.usfirst.frc.team2813.robot.subsystems;

import java.util.Hashtable;

import org.usfirst.frc.team2813.robot.Robot;
import org.usfirst.frc.team2813.robot.commands.OperatorDrive;
import org.usfirst.frc.team2813.robot.commands.TableMapper;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public final RobotDrive drive;
	// public final Encoder encoder;
	private PIDController ctrl;
	private static NetworkTable database = NetworkTable.getTable("SmartDashboard/DB");

	private enum Mode {
		CARTESIAN, POLAR;
	}

	private Mode mode = Mode.CARTESIAN;
	private double x = 0, y = 0;
	private boolean fieldOriented;

	public void initDefaultCommand() {
		// SmartDashboard.putNumber("p", 1.0);
		// SmartDashboard.putNumber("i", 0.0);
		// SmartDashboard.putNumber("d", 0.0);
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new OperatorDrive());
	}

	public DriveTrain() {
		final Robot robot = Robot.getInstance();
		drive = new RobotDrive(0, 1, 2, 3);
		// encoder = new Encoder(0, 1);
		robot.gyro.setPIDSourceType(PIDSourceType.kRate);
		ctrl = new PIDController(0, 0, 0, robot.gyro, this::drive);
		ctrl.setInputRange(-150, 150);
		ctrl.setOutputRange(-1, 1);
		Hashtable<String, String> mapping = new Hashtable<String, String>();
		mapping.put("p", "Slider 0");
		mapping.put("i", "Slider 1");
		mapping.put("d", "Slider 2");
		ctrl.initTable(new TableMapper(database, mapping));
		ctrl.enable();
	}

	public synchronized void drive(double rotation) {
		final Robot robot = Robot.getInstance();
		ctrl.updateTable();
		// dT = 0.05
		// double pid_P = ctrl.getTable().getNumber("p", 0.0), pid_I =
		// ctrl.getTable().getNumber("i", 0.0),
		// pid_D = ctrl.getTable().getNumber("d", 0.0);
		// ctrl.setPID(pid_P, pid_I, pid_D);
		switch (mode) {
		case CARTESIAN:
			drive.mecanumDrive_Cartesian(x, y, rotation, fieldOriented ? robot.gyro.getAngle() : 0);
		case POLAR:
			// drive.mecanumDrive_Polar(x, fieldOriented ? y -
			// robot.gyro.getAngle() : y, rotation);
		}
	}

	public synchronized void mecanumDriveCartesian(double x, double y, double rotation, boolean fieldOriented) {
		ctrl.setSetpoint(rotation);
		mode = Mode.CARTESIAN;
		this.x = x;
		this.y = y;
		this.fieldOriented = fieldOriented;
		if (!ctrl.isEnabled()) {
			drive(rotation);
		}
	}

	public synchronized void mecanumDrivePolar(double mag, double angle, double rotation, boolean fieldOriented) {
		ctrl.setSetpoint(rotation);
		mode = Mode.POLAR;
		this.x = mag;
		this.y = angle;
		this.fieldOriented = fieldOriented;
		if (!ctrl.isEnabled()) {
			drive(rotation);
		}
	}

	public void pidEnable() {
		ctrl.enable();
	}

	public void pidDisable() {
		ctrl.disable();
	}
}