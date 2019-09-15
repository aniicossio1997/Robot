package laboratorio15;

public class ModeratedStrategy extends Strategy {

	private int lastScannedDistance = -1;

	@Override
	public void run(LaboRobot15 r) {

		r.ahead(150);
		super.run(r);

	}

	@Override
	public void onScannedRobot(LaboRobot15 r) {
		super.onScannedRobot(r);
		lastScannedDistance = r.scannedDistance;
		if (r.energy < 30) {
			r.doNothing(30);
		}

	}

	@Override
	public void onHitByBullet(LaboRobot15 r) {

		if (lastScannedDistance > 200) {
			r.turnGunTo(r.hitByBulletAngle);
			lastScannedDistance = -1;
		}

	}

	@Override
	public void onHitWall(LaboRobot15 r) {
		r.turnTo(r.heading + 90);

	}

}
