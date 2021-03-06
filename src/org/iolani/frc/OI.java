package org.iolani.frc;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private final Joystick _lStick = new Joystick(2);
	private final Joystick _rStick = new Joystick(3);
	
	public OI() {
		
	}
	
	public Joystick getLeftStick(){
		return _lStick;
	}
	
	public Joystick getRightStick(){
		return _rStick;
	}
}
