import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> virtualPets = new HashMap<>();

	public void add(VirtualPet pet) {
		virtualPets.put(pet.getPetName(), pet);

	}

	public VirtualPet findPet(String petName) {
		return virtualPets.get(petName);
	}

	public Collection<VirtualPet> getAllPets() {
		return virtualPets.values();

	}

	public void remove(VirtualPet pet) {
		virtualPets.remove(pet.getPetName(), pet);

	}

	public void play(String petName) {
		VirtualPet playWithPet = findPet(petName);
		playWithPet.play();

	}

	// bring up Map keys of all the pets, loop through it, call method on each
	// iteration
	public void feedAllPets() {
		for (VirtualPet eachPet : virtualPets.values()) {
			eachPet.feed();
		}

	}

	// same as before, bring up the map, loop through it, call method on each
	// iteration
	public void waterAllPets() {
		for (VirtualPet eachPet : virtualPets.values()) {
			eachPet.water();
		}

	}

	// representing the passage of time when user does something with one or all
	// pets
	public void tickAllPets() {
		for (VirtualPet eachPet : virtualPets.values()) {
			eachPet.tick();

		}

	}
	
	}


