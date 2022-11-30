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

  //Mako has 6 neos in it's chassis. They all use SPARK MAX motor controllers, hence why we use the CANSparkMax class from the rev library.
  CANSparkMax leftneo, leftneo2, leftneo3;
  CANSparkMax rightneo, rightneo2, rightneo3;
  DifferentialDrive differentialDrive; //We use the DifferentialDrive class to automatically control the motors in the transmision using joysticck input
  Joystick joystick;//The joystick class is used to communicate with the joysticks physicially connected to the computer 

  public Chassis() {
      leftneo = new CANSparkMax(0,MotorType.kBrushless);//The constructor for SPARK MAXES take the ID of the controller (configured using the rev hardware client) and the motor type for the motor being used (Brushed or brushless) (remember that NEOS will always be brushless)
      leftneo2 = new CANSparkMax(0,MotorType.kBrushless);
      leftneo2.follow(leftneo);//use the .follow method to automatically set a speed controller to follow another's output. 
      leftneo3 = new CANSparkMax(0,MotorType.kBrushless);
      leftneo3.follow(leftneo);


      rightneo = new CANSparkMax(0,MotorType.kBrushless);
      rightneo2 = new CANSparkMax(0,MotorType.kBrushless);
      rightneo2.follow(rightneo);
      rightneo3 = new CANSparkMax(0,MotorType.kBrushless);
      rightneo3.follow(rightneo);

      differentialDrive = new DifferentialDrive(leftneo, rightneo);// the differential drive constructor will take the left leader controller and the right leader controller. (remember to set the followers otherwise they will not move)
      joystick = new Joystick(0);// the joystick constructor takes in the ID of the joystick (check the ID by going into driver station then USB devices)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    differentialDrive.arcadeDrive(joystick.getX(), -joystick.getY());//the arcadeDrive method will take in an x and y (or z value) X being left/right and y being forward or back (sometimes depending on the joystick you need to invert the Y)
  }
}
