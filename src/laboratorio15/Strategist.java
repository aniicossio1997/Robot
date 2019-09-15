package laboratorio15;

public interface Strategist {
	public abstract void run(LaboRobot15 r);
	public abstract void onScannedRobot(LaboRobot15 r);
	public abstract void onHitByBullet(LaboRobot15 r);
	public abstract void onHitWall(LaboRobot15 r);
	public abstract void onHitRobot(LaboRobot15 r);
}
