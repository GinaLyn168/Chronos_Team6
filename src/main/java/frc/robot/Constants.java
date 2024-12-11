package frc.robot;

public class Constants {
    public static double MaxSpeed = 1; //can be lowered during testing
    public static double MaxAngularRate = 3 * Math.PI; // 3/4 of a rotation per second max angular velocity
    
    public class Ports {
        // public static final int indexerM = 14;
        
        // public static final int shooterLeaderM = 13;
        // public static final int shooterFollowerM = 12;

        // public static final int intakeM = 11;

        public static final int frontLeftSteer = 1;
        public static final int frontLeftDrive = 2;

        public static final int backLeftSteer = 3;
        public static final int backLeftDrive = 4;

        public static final int backRightSteer = 5;
        public static final int backRightDrive = 6;

        public static final int frontRightSteer = 7;
        public static final int frontRightDrive = 8;

        public static final int frontLeftCancoder = 9;
        public static final int backLeftCancoder = 10;
        public static final int backRightCancoder = 11;
        public static final int frontRightCancoder = 12;


        public static final int intake = 40;

        public static final int leftIndexer = 21;
        public static final int rightIndexer = 22;

        public static final int leftShooter = 31;
        public static final int rightShooter = 32;
    }
}
