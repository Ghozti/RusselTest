// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */

  CANSparkMax leftneo, leftneo2, leftneo3;
  CANSparkMax rightneo, rightneo2, rightneo3;
  DifferentialDrive differentialDrive;
  Joystick joystick;
  //

  public Chassis() {
      leftneo = new CANSparkMax(0,MotorType.kBrushless);
      leftneo2 = new CANSparkMax(0,MotorType.kBrushless);
      leftneo2.follow(leftneo);
      leftneo3 = new CANSparkMax(0,MotorType.kBrushless);
      leftneo3.follow(leftneo);


      rightneo = new CANSparkMax(0,MotorType.kBrushless);
      rightneo2 = new CANSparkMax(0,MotorType.kBrushless);
      rightneo2.follow(rightneo);
      rightneo3 = new CANSparkMax(0,MotorType.kBrushless);
      rightneo3.follow(rightneo);

      differentialDrive = new DifferentialDrive(leftneo, rightneo);
      joystick = new Joystick(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    differentialDrive.arcadeDrive(joystick.getX(), -joystick.getY());
  }
}
