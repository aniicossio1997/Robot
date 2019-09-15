package laboratorio15;

public class EnergyStrategist {
	
	public Strategist chooseStrategy(LaboRobot15 r){
		if(r.energy > 70) {
			return new RandomStrategy();
		}else if (r.energy > 20) {
			return new ModeratedStrategy();
		}else {
			return new SpinStrategy();
		}
	}

}
