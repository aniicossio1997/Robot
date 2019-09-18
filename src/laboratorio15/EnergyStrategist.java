package laboratorio15;

import static robocode.JuniorRobot.white;

public class EnergyStrategist implements Strategist {
	//clase anidada 
	//lea es mandon 

	private class SpinStrategy extends Strategy {

		private boolean inCenter = false;

		public int goToCenter(LaboRobot15 r) {
			// ver en que cuarto del mapa está
			if (r.robotX > (r.fieldWidth / 2)) {
				if (r.robotY > r.fieldHeight / 2) {
					// superior derecha
					r.turnTo(180);
					r.ahead(r.robotY - r.fieldHeight / 2);
					r.turnTo(270);
					r.ahead(r.robotX - r.fieldWidth / 2);

				} else {
					// inferior derecha
					r.turnTo(0);
					r.ahead(r.fieldHeight / 2 - r.robotY);
					r.turnTo(270);
					r.ahead(r.robotX - r.fieldWidth / 2);
				}
			} else {
				if (r.robotY > r.fieldHeight / 2) {
					// superior izquierda
					r.turnTo(180);
					r.ahead(r.robotY - r.fieldHeight / 2);
					r.turnTo(90);
					r.ahead(r.fieldWidth / 2 - r.robotX);
				} else {
					// inferior izquierda
					r.turnTo(0);
					r.ahead(r.fieldHeight / 2 - r.robotY);
					r.turnTo(90);
					r.ahead(r.fieldWidth / 2 - r.robotX);
				}

			}
			return 0;
		}

		@Override
		public void run(LaboRobot15 r) {
			if (inCenter == false) {
				this.goToCenter(r);
				inCenter = true;
				r.turnTo(0);
			}
			r.turnBackLeft(10000, 5000);
			r.setColors(white, white, white, white, white);

		}

		@Override
		public void onScannedRobot(LaboRobot15 r) {
			if (inCenter & r.energy > 5) {
				r.turnGunTo(r.scannedAngle - 20);
				r.fire(2);
			}

		}

		@Override
		public void onHitByBullet(LaboRobot15 r) {

		}

		@Override
		public void onHitWall(LaboRobot15 r) {
			r.turnAheadLeft(10000, 5000);

		}

		public void onHitRobot(LaboRobot15 r) {
			r.turnAheadLeft(10000, 5000);
		}

	}
	//fin SpinStrategy
	
//	Strategy upDown= new UpDownStrategy();
	Strategy moderated= new ModeratedStrategy();
	Strategy spin= new SpinStrategy();

	public Strategy chooseStrategy(LaboRobot15 r) {
		if (r.energy > 70) {
			return new RandomStrategy();
//			return upDown; ya no puede
		} else if (r.energy > 20) {
//			return new ModeratedStrategy();
			return moderated;
		} else {
			return spin;
		}
	}

}
