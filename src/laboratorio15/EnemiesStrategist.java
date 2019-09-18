package laboratorio15;

public class EnemiesStrategist extends AbstractStrategist {

	public class UpDownStrategy extends Strategy {
		boolean start = true;
		boolean lookingUp = true;

		@Override
		public void run(LaboRobot15 r) {
			super.run(r);
			if (start) {
				r.turnTo(0);
				start = false;
			}
			r.ahead(1000);

		}

		@Override
		public void onHitByBullet(LaboRobot15 r) {

		}

		@Override
		public void onScannedRobot(LaboRobot15 r) {
			if (lookingUp) {
				r.turnGunTo(r.scannedAngle - 10);
			} else {
				r.turnGunTo(r.scannedAngle + 10);
			}
			r.fire(1);

		}

		@Override
		public void onHitWall(LaboRobot15 r) {
			r.turnLeft(180);
			r.turnGunLeft(180);
			lookingUp = false;

		}

		public void onHitRobot(LaboRobot15 r) {
		}

	}

	UpDownStrategy upDown = new UpDownStrategy();
	Strategy moderated= new ModeratedStrategy();

	@Override
	public Strategy chooseStrategy(LaboRobot15 r) {
		if (r.others > 4) {
			return upDown;

		} else {
			return moderated;
		}
	}

}
