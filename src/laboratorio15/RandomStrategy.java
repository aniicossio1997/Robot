package laboratorio15;

import java.util.Random;

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
