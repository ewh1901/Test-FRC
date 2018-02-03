package org.usfirst.frc.team2438.robot.subsystems;

import org.usfirst.frc.team2438.robot.commands.OperateTankDrive;
import org.usfirst.frc.team2438.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drivetrain subsystem
 */
public class Drivetrain extends Subsystem {

	private TalonSRX _left1;
	private TalonSRX _left2;
	private TalonSRX _left3;
	private TalonSRX _right1;
	private TalonSRX _right2;
	private TalonSRX _right3;
	
	//private static final double WHEEL_DIAMETER_INCHES  = 8.0;
	//private static final double WHEEL_INCHES_PER_REV   = Math.PI * WHEEL_DIAMETER_INCHES;
	//private static final int    ENCODER_TICKS_PER_REV  = 128;
	//private static final int    ENCODER_PINION_TEETH   = 12;
	//private static final int    WHEEL_GEAR_TEETH       = 132;
	//private static final double ENCODER_INCHES_PER_REV = WHEEL_INCHES_PER_REV * ENCODER_PINION_TEETH / WHEEL_GEAR_TEETH;
	private static final double NATIVE_UNITS_PER_FOOT = 0;
	private static final int TIMEOUT = 20;
	
	public void init() {
		_left1 = new TalonSRX(RobotMap.leftDrive1);
		_left1.setInverted(true);
    	_left1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		_left1.setSelectedSensorPosition(0, 0, 0);
		_left1.setSensorPhase(true);
		_left1.config_kF(0, 0, TIMEOUT);
		_left1.config_kP(0, 0, TIMEOUT);
		_left1.config_kI(0, 0, TIMEOUT);
		_left1.config_kD(0, 0, TIMEOUT);
		_left1.configMotionCruiseVelocity(0, TIMEOUT);
		_left1.configMotionAcceleration(0, TIMEOUT);
		
		_left2 = new TalonSRX(RobotMap.leftDrive2);
		_left2.setInverted(true);
		_left2.follow(_left1);
		
		_left3 = new TalonSRX(RobotMap.leftDrive3);
		_left3.setInverted(true);
		_left3.follow(_left1);
		
		_right1 = new TalonSRX(RobotMap.rightDrive1);
		_right1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		_right1.setSelectedSensorPosition(0, 0, 0);
		_right1.config_kF(0, 0, TIMEOUT);
		_right1.config_kP(0, 0, TIMEOUT);
		_right1.config_kI(0, 0, TIMEOUT);
		_right1.config_kD(0, 0, TIMEOUT);
		_right1.configMotionCruiseVelocity(0, TIMEOUT);
		_right1.configMotionAcceleration(0, TIMEOUT);
		
		_right2 = new TalonSRX(RobotMap.rightDrive2);
		_right2.follow(_right1);
		
		_right3 = new TalonSRX(RobotMap.rightDrive3);
		_right3.follow(_right1);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new OperateTankDrive());
    }
    
    public void setTank(double left, double right)
    {
    	_left1.set(ControlMode.PercentOutput, left);
		_right1.set(ControlMode.PercentOutput, right);
    	
    	SmartDashboard.putNumber("Left power", left);
    	SmartDashboard.putNumber("Right power", right);
    }
    
    /**
     * Auto method to drive straight
     * @param power
     * @param distance
     */
    public void driveStraight(double distance) {
    	int nativeUnits = (int) Math.round(distance * NATIVE_UNITS_PER_FOOT);
    	
    	_left1.set(ControlMode.MotionMagic, nativeUnits);
    	_right1.set(ControlMode.MotionMagic, nativeUnits);
    }
    
    public void stop()
    {
    	_left1.set(ControlMode.PercentOutput, 0);
    	_right1.set(ControlMode.PercentOutput, 0);
    }
}

