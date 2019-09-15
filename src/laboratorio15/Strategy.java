package laboratorio15;

import java.util.Random;

import static robocode.JuniorRobot.*;

public abstract class Strategy  {
	
	public abstract void onHitByBullet(LaboRobot15 r);
	public abstract void onHitWall(LaboRobot15 r);
	
	protected int lastScannedAngle = -1;
	
	public void run(LaboRobot15 r) {

		if (lastScannedAngle == -1) {
			r.turnGunRight(180);
		} else {
			r.turnGunTo(lastScannedAngle);
			lastScannedAngle = -1;

		}
	}
	
	public void onScannedRobot(LaboRobot15 r) {
		if (r.scannedDistance > 400 & r.scannedVelocity > 0) {
			r.setColors(blue, yellow, yellow, yellow,white);
			r.turnGunTo(r.scannedAngle + new Random().nextInt(10 + 10) - 10);
			r.fire(1);
		} else {
			r.setColors(blue, yellow, yellow, red, red);
			r.turnGunTo(r.scannedAngle);
			r.fire(3);
		}
		lastScannedAngle = r.scannedAngle;
	}
	
	public void onHitRobot(LaboRobot15 r) {
		r.turnGunTo(r.hitRobotAngle);
		r.fire(3);
		lastScannedAngle = r.scannedAngle;

	}

}
