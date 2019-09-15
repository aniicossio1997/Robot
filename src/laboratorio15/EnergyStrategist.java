package laboratorio15;

public class EnergyStrategist implements Strategist {
	
	public Strategy chooseStrategy(LaboRobot15 r){
		if(r.energy > 70) {
			return new RandomStrategy();
		}else if (r.energy > 20) {
			return new ModeratedStrategy();
		}else {
			return new SpinStrategy();
		}
	}

}
