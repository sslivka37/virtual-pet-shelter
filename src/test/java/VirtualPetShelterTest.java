
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;


import org.junit.Before;
import org.junit.Test;



public class VirtualPetShelterTest {
	
	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;
	
	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Henry", 100, 100, 50, "Has too many legs");
		pet2 = new VirtualPet("Fiona", 80, 80, 50, "is very soft");
	}
	
	
	
	@Test
	public void shouldBeAbleToAddPet() {
		underTest.add(pet1);
		VirtualPet retrievedPet = underTest.findPet("Henry");
		assertThat(retrievedPet, is (pet1));
	}
	
	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertEquals(2, allPets.size());
	}
	
	@Test
	public void shouldBeAbleToRemoveAPet() {
		underTest.add(pet1);
		underTest.remove(pet1);
		VirtualPet retrievedPet = underTest.findPet(pet1.getPetName());
		assertThat(retrievedPet, is (nullValue()));
	}
	
	
	@Test
	public void shouldBeAbleToPlayWithOnePet() {
		underTest.add(pet1);
		underTest.play(pet1.getPetName());
		assertEquals(75, pet1.getHappinessLevel());
	}
	
		
	@Test
	public void shouldBeAbleToFeedAllPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.feedAllPets();
		assertEquals(75, pet1.getHungerLevel());
		assertEquals(55, pet2.getHungerLevel());
		
	}
	
	@Test
	public void shouldBeAbleToWaterAllPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.waterAllPets();
		assertEquals(75, pet1.getThirstLevel());
		assertEquals(55, pet2.getThirstLevel());
	}
	
	@Test
	public void shouldHaveTimeGoByWhenInteracting() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.tickAllPets();
		assertEquals(48, pet1.getHappinessLevel());
		assertEquals(82, pet2.getThirstLevel());
		
	}
	
	

}
