package org.usfirst.frc.team2813.robot;

import org.usfirst.frc.team2813.robot.commands.ResetGyro;
import org.usfirst.frc.team2813.robot.commands.RunMotor;
import org.usfirst.frc.team2813.robot.commands.SetServo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public final Joystick joystick = new Joystick(0);
	public final Joystick buttons = new Joystick(1);
	// JoystickButton button1 = new JoystickButton(joystick, 1);
	// JoystickButton button2 = new JoystickButton(joystick, 2);
	// JoystickButton button3 = new JoystickButton(joystick, 3);
	// JoystickButton button4 = new JoystickButton(joystick, 4);
	// JoystickButton button7 = new JoystickButton(joystick, 5);
	// JoystickButton button8 = new JoystickButton(joystick, 6);
	JoystickButton joystick1 = new JoystickButton(joystick, 10);
	JoystickButton button1 = new JoystickButton(buttons, 1);
	JoystickButton button2 = new JoystickButton(buttons, 5);
	JoystickButton button3 = new JoystickButton(buttons, 2);
	JoystickButton button4 = new JoystickButton(buttons, 6);
	JoystickButton button5 = new JoystickButton(buttons, 3);
	JoystickButton button6 = new JoystickButton(buttons, 7);
	JoystickButton button7 = new JoystickButton(buttons, 4);
	JoystickButton button8 = new JoystickButton(buttons, 8);
	JoystickButton button9 = new JoystickButton(buttons, 9);
	JoystickButton button10 = new JoystickButton(buttons, 10);
	JoystickButton button11 = new JoystickButton(buttons, 11);
	JoystickButton button12 = new JoystickButton(buttons, 12);

	public OI() {
		button1.toggleWhenPressed(new RunMotor(Robot.intake, -1.0));
		button2.toggleWhenPressed(new RunMotor(Robot.intake, 1.0));
		button3.toggleWhenPressed(new RunMotor(Robot.belt, 0.6));
		button4.toggleWhenPressed(new RunMotor(Robot.belt, -0.6));
		button5.whenPressed(new RunMotor(Robot.intake, -1.0));
		button5.whenPressed(new RunMotor(Robot.belt, 0.6));
		button6.whenPressed(new RunMotor(Robot.intake, 1.0));
		button6.whenPressed(new RunMotor(Robot.belt, -0.6));
		button7.toggleWhenPressed(new RunMotor(Robot.lift, 0.25));
		button8.toggleWhenPressed(new RunMotor(Robot.lift, -0.25));
		button11.whenPressed(new RunMotor(Robot.intake, 0.0));
		button11.whenPressed(new RunMotor(Robot.belt, 0.0));
		button9.whenPressed(new SetServo(Robot.gearHolderServo, 0));
		button10.whenPressed(new SetServo(Robot.gearHolderServo, 100));
		button12.toggleWhenPressed(new RunMotor(Robot.climber, 1.0));
		joystick1.whenPressed(new ResetGyro());
	}
}