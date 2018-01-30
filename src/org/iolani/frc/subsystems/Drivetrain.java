package org.iolani.frc.subsystems;

import org.iolani.frc.RobotMap;
import org.iolani.frc.commands.OperateTankDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private TalonSRX _left1;
	private TalonSRX _left2;
	private TalonSRX _left3;
	private TalonSRX _right1;
	private TalonSRX _right2;
	private TalonSRX _right3;
	
	private static final double WHEEL_DIAMETER_INCHES  = 8.0;
	private static final double WHEEL_INCHES_PER_REV   = Math.PI * WHEEL_DIAMETER_INCHES;
	private static final int    ENCODER_TICKS_PER_REV  = 128;
	private static final int    ENCODER_PINION_TEETH   = 12;
	private static final int    WHEEL_GEAR_TEETH       = 132;
	private static final double ENCODER_INCHES_PER_REV = WHEEL_INCHES_PER_REV * ENCODER_PINION_TEETH / WHEEL_GEAR_TEETH;
	
	public void init() {
		_left1 = new TalonSRX(RobotMap.left1);
    	_left1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		_left1.setSelectedSensorPosition(0, 0, 0);
		
		_left2 = new TalonSRX(RobotMap.left2);
		_left2.follow(_left1);
		
		_left3 = new TalonSRX(RobotMap.left3);
		_left3.follow(_left1);
		
		_right1 = new TalonSRX(RobotMap.right1);
		_right1.setInverted(true);
		_right1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		_right1.setSelectedSensorPosition(0, 0, 0);
		
		_right2 = new TalonSRX(RobotMap.right2);
		_right2.setInverted(true);
		_right2.follow(_right1);
		
		_right3 = new TalonSRX(RobotMap.right3);
		_right3.setInverted(true);
		_right3.follow(_right1);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new OperateTankDrive());
    }
    
    public void drive(double left, double right)
    {
    	_left1.set(ControlMode.PercentOutput, left);
    	_left2.set(ControlMode.PercentOutput, left);
    	_left3.set(ControlMode.PercentOutput, left);
		
		_right1.set(ControlMode.PercentOutput, right);
		_right2.set(ControlMode.PercentOutput, right);
    	_right3.set(ControlMode.PercentOutput, right);
    	
    	SmartDashboard.putNumber("Left power", left);
    	SmartDashboard.putNumber("Right power", right);
    }
    
    public void stop()
    {
    	_left1.set(ControlMode.PercentOutput, 0);
    	_left2.set(ControlMode.PercentOutput, 0);
    	_left3.set(ControlMode.PercentOutput, 0);
    	_right1.set(ControlMode.PercentOutput, 0);
    	_right2.set(ControlMode.PercentOutput, 0);
    	_right3.set(ControlMode.PercentOutput, 0);
    }
}

