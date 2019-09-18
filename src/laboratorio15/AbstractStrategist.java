package laboratorio15;

import java.util.Random;

public abstract class AbstractStrategist implements Strategist {
	
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
	
	public class RandomStrategy extends Strategy {
		
		
		@Override
		public void run(LaboRobot15 r) {

			int option = new Random().nextInt(5 + 1) - 1;
			switch (option) {
			case 1:
				r.ahead(300);
				r.turnTo(new Random().nextInt(360 + 0) - 360);
				break;
			case 2:
				r.turnAheadLeft(200, 90);
				break;
			case 3:
				r.turnBackLeft(200, 90);
				break;
			case 4:
				r.turnAheadRight(200, 90);
				break;
			case 5:
				r.turnBackRight(200, 90);
				break;
			}
			super.run(r);
		}

		@Override
		public void onHitByBullet(LaboRobot15 r) {
		}

		@Override
		public void onHitWall(LaboRobot15 r) {
			r.turnBackLeft(200, 90);

		}

	}

	@Override
	public abstract Strategy chooseStrategy(LaboRobot15 r);
	

}
