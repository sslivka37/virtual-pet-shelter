

public class VirtualPet {
	
	

	private String petName;
	private int hungerLevel;
	private int thirstLevel;
	private int happinessLevel;
	private String description;
	

	public VirtualPet(String petName, int hungerLevel, int thirstLevel, int happinessLevel, String description) {
		this.petName = petName;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.happinessLevel = happinessLevel;
		this.description = description;
		
	}

	public String getPetName() {
		return petName;
	}
	
	public int getHungerLevel() {
		return hungerLevel;
	}
	
	public int getThirstLevel() {
		return thirstLevel;
	}
	
	public int getHappinessLevel() {
		// TODO Auto-generated method stub
		return happinessLevel;
	}
	
	public String getDescription() {
		return description;
	}

	public void play() {
		happinessLevel = happinessLevel + 25;
		hungerLevel = hungerLevel +3;
		thirstLevel = thirstLevel +3;
		
	}

	public void feed() {
		hungerLevel = hungerLevel -25;
		
		happinessLevel = happinessLevel +5;
	}

	public void water() {
		thirstLevel = thirstLevel -25;
				
	}

	public void tick() {
		hungerLevel = hungerLevel +2;
		thirstLevel = thirstLevel +2;
		happinessLevel = happinessLevel -2;
		
	}
	

}
