package org.usfirst.frc.team2438.robot.subsystems;

import org.usfirst.frc.team2438.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private TalonSRX _left1;
	private TalonSRX _left2;
	
	private TalonSRX _right1;
	private TalonSRX _right2;
	
	public void init() {
		_left1 = new TalonSRX(RobotMap.leftWinch1);
		_left1.setInverted(true);
		_left2 = new TalonSRX(RobotMap.leftWinch2);
		_left2.setInverted(true);
		_left2.follow(_left1);
		
		_right1 = new TalonSRX(RobotMap.rightWinch1);
		_right1.follow(_left1);
		_right2 = new TalonSRX(RobotMap.rightWinch2);
		_right2.follow(_left1);
	}
	
	public void setPower(double power) {
		_left1.set(ControlMode.PercentOutput, power);
	}
	
	public void stop() {
		_left1.set(ControlMode.PercentOutput, 0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(null);
    }
}

