package org.usfirst.frc.team2438.robot;

import org.usfirst.frc.team2438.robot.commands.OperateWinch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private final Joystick _lStick = new Joystick(2);
	private final Joystick _rStick = new Joystick(3);
	
	private final JoystickButton _windWinch = new JoystickButton(_lStick, 4);
	private final JoystickButton _retractWinch = new JoystickButton(_lStick, 5);
	
	public OI() {
		_windWinch.whileHeld(new OperateWinch(1.0));
		_retractWinch.whileHeld(new OperateWinch(-1.0));
	}
	
	public Joystick getLeftStick(){
		return _lStick;
	}
	
	public Joystick getRightStick(){
		return _rStick;
	}
}
