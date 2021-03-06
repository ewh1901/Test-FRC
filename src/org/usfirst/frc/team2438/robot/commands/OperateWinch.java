package org.usfirst.frc.team2438.robot.commands;

/**
 *
 */
public class OperateWinch extends CommandBase {
	
	private double power = 0;

    public OperateWinch(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(winch);
    	
    	this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	winch.setPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	winch.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
