package laboratorio15;


import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html

public class LaboRobot15 extends JuniorRobot {
//	private Strategist combatstrategy;
//	private EnergyStrategist estratega=new EnergyStrategist();;
	private Strategist estratega=new EnemiesStrategist();;
	

	@Override
	public void run() {
//		turnTo(0);
//		setColors(blue, yellow, yellow, yellow, blue);
//		combatstrategy = new RandomStrategy();
//		while (energy>70) {
//			combatstrategy.run(this);
//		}
//		setColors(black, black, yellow, yellow, blue);
//		combatstrategy = new ModeratedStrategy();
//		turnTo(0);
//		while(energy > 20) {
//			combatstrategy.run(this);
//		}
//		setColors(black, black, black, black, black);
//		combatstrategy= new SpinStrategy();
//		while(true) {
//			combatstrategy.run(this);
//		}
		estratega.chooseStrategy(this).run(this);
		
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	// @Override
	public void onScannedRobot() {
//		combatstrategy.onScannedRobot(this);
		estratega.chooseStrategy(this).onScannedRobot(this);

	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
//		combatstrategy.onHitByBullet(this);
		estratega.chooseStrategy(this).onHitByBullet(this);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
//		combatstrategy.onHitWall(this);
		estratega.chooseStrategy(this).onHitWall(this);

	}
	
	@Override
	public void onHitRobot() {
//		combatstrategy.onHitRobot(this);
		estratega.chooseStrategy(this).onHitRobot(this);

	}
	
	

}