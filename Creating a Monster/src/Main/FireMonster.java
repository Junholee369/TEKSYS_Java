package Main;

public class FireMonster extends Monster{

	public FireMonster(String name) {
		super(name);
	}

	@Override
	public String attack() {
		return name + " Attack with fire!";
	}

}