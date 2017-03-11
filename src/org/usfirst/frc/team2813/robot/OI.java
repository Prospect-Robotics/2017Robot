package org.usfirst.frc.team2813.robot;

import org.usfirst.frc.team2813.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public final Joystick joystick = new Joystick(0);
	public final Joystick buttons = new Joystick(1);
	private final JoystickButton button1 = new JoystickButton(buttons, 1);
	private final JoystickButton button2 = new JoystickButton(buttons, 5);
	private final JoystickButton button3 = new JoystickButton(buttons, 2);
	private final JoystickButton button4 = new JoystickButton(buttons, 6);
	private final JoystickButton button5 = new JoystickButton(buttons, 3);
	private final JoystickButton button6 = new JoystickButton(buttons, 7);
	private final JoystickButton button7 = new JoystickButton(buttons, 4);
	private final JoystickButton button8 = new JoystickButton(buttons, 8);
	private final JoystickButton button9 = new JoystickButton(buttons, 9);
	private final JoystickButton button11 = new JoystickButton(buttons, 11);
	private final JoystickButton button12 = new JoystickButton(buttons, 12);

	public OI() {
		final Robot robot = Robot.getInstance();
		button1.toggleWhenPressed(new RunMotor(robot.intake, -1.0));
		button2.toggleWhenPressed(new RunMotor(robot.intake, 1.0));
		button3.toggleWhenPressed(new RunMotor(robot.belt, 0.6));
		button4.toggleWhenPressed(new RunMotor(robot.belt, -0.6));
		button5.whenPressed(new RunMotor(robot.intake, -1.0));
		button5.whenPressed(new RunMotor(robot.belt, 0.6));
		button6.whenPressed(new RunMotor(robot.intake, 1.0));
		button6.whenPressed(new RunMotor(robot.belt, -0.6));
		button7.toggleWhenPressed(new RunMotor(robot.lift, 0.3, 15));
		button8.toggleWhenPressed(new RunMotor(robot.lift, -0.3, 15));
		button9.whileHeld(new RunMotor(robot.climber, 1.0));
		button11.whenPressed(new RunMotor(robot.intake, 0.0));
		button11.whenPressed(new RunMotor(robot.belt, 0.0));
		button12.whenPressed(new ResetGyro());
	}
}