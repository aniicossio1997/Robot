package laboratorio15;


public class UpDownStrategy extends Strategy {
	boolean lookingUp = false;
	
	@Override
	public void run(LaboRobot15 r) {
		super.run(r);
		if(!lookingUp) {
			r.turnTo(0);
			lookingUp= true;
		}
		r.ahead(1000);

	}


	@Override
	public void onHitByBullet(LaboRobot15 r) {

	}

	@Override
	public void onHitWall(LaboRobot15 r) {
		r.turnLeft(180);
//		r.ahead(1000);
		
	}
	
	public void onHitRobot(LaboRobot15 r) {
	}
	

}
