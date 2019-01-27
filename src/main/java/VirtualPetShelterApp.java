import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		// creating a new shelter and pets
		VirtualPetShelter myVirtualPetShelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Hastur", 75, 75, 34, "seems more yellow today than usual.");
		VirtualPet pet2 = new VirtualPet("Byatis", 100, 60, 50, "has an extra tentacle today!");
		VirtualPet pet3 = new VirtualPet("Azathoth", 45, 45, 70, "is asleep....maybe we should leave him that way.");
		VirtualPet pet4 = new VirtualPet("Cthulhu", 50, 50, 5, "looks extra angry!");

		// adding the pets we've created to the shelter
		myVirtualPetShelter.add(pet1);
		myVirtualPetShelter.add(pet2);
		myVirtualPetShelter.add(pet3);
		myVirtualPetShelter.add(pet4);

		// creating a collection based on our current pets and shelter
		Collection<VirtualPet> currentPetCollection = myVirtualPetShelter.getAllPets();

		// giving the first bit of user interface here
		System.out.println("Welcome to HP Lovecraft's Virtual Pet Shelter!");
		System.out.println("Here are all of our adoptable pets:");

		// looping through the map and displaying all of the values we want to display, may want to format this?
		for (VirtualPet currentPet : myVirtualPetShelter.getAllPets()) {
			System.out.println("Name: " + currentPet.getPetName() + " Hunger Level: " + currentPet.getHungerLevel()
					+ " Thirst Level: " + currentPet.getThirstLevel() + " Happiness Level: "
					+ currentPet.getHappinessLevel());
		}

		// giving the user options
		System.out.println("What would you like to do with the pets?");
		System.out.println("Press 1 to feed all pets");
		System.out.println("Press 2 to water all pets");
		System.out.println("Press 3 to play with a pet");
		System.out.println("Press 4 to adopt a pet");
		System.out.println("Press 5 to admit a pet");
		System.out.println("Press 6 to see the statuses of all of the pets");
		System.out.println("Press any other number to leave the shelter");
		int userInput = Integer.parseInt(input.nextLine());

		// now our conditionals based on userInput, will have to loop this
		while (userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5
				|| userInput == 6) {
			switch (userInput) {

			// feeding all the pets
			case 1:
				System.out.println("You feed all of the pets!");
				myVirtualPetShelter.feedAllPets();
				myVirtualPetShelter.tickAllPets();
				break;

			// giving all of the pets water
			case 2:
				System.out.println("You give all of the pets water!");
				myVirtualPetShelter.waterAllPets();
				myVirtualPetShelter.tickAllPets();
				break;

			// picking a pet and playing with them
			case 3:
				System.out.println("Which pet do you want to play with?");
				for (VirtualPet currentPet : myVirtualPetShelter.getAllPets()) {
					System.out.println(currentPet.getPetName() + " " + currentPet.getDescription());
				}
				String userNameSelect = input.nextLine();
				VirtualPet userPetPlay = myVirtualPetShelter.findPet(userNameSelect);//creating a new instance of virtual pet
				if (currentPetCollection.contains(userPetPlay)) {   //checking to see if the current collection contains the new instance name
					myVirtualPetShelter.play(userNameSelect);
					System.out.println("You play with " + userPetPlay.getPetName() + ", they look happy!");
					myVirtualPetShelter.tickAllPets();
				} else {
					System.out.println("Not a valid selection, goodbye!");
					System.exit(0);
				}
				break;

			// picking a pet to adopt and removing them from the shelter
			case 4:
				System.out.println("Which pet would you like to adopt?");
				for (VirtualPet currentPet : myVirtualPetShelter.getAllPets()) {
					System.out.println(currentPet.getPetName());
				}
				userNameSelect = input.nextLine();
				VirtualPet userPetAdopt = myVirtualPetShelter.findPet(userNameSelect);
				if (currentPetCollection.contains(userPetAdopt)) {
					myVirtualPetShelter.play(userNameSelect);
					System.out.println("You have adopted " + userPetAdopt.getPetName()
							+ ", take good care of them and watch out for their teeth!");
					myVirtualPetShelter.remove(userPetAdopt);
					myVirtualPetShelter.tickAllPets();
				} else {
					System.out.println("Not a valid selection, goodbye!");
					System.exit(0);
				}
				break;

			// having the user create a pet to admit and adding pet
			case 5:
				System.out
						.println("Due to some of the pets eating the other, smaller pets, we have room for new pets!");
				System.out.println("What is the new pet's name?");
				userNameSelect = input.nextLine();
				System.out.println("What is their hunger level?");
				int userHungerSelect = Integer.parseInt(input.nextLine());
				System.out.println("How thirsty are they?");
				int userThirstSelect = Integer.parseInt(input.nextLine());
				System.out.println("How happy are they right now?");
				int userHappySelect = Integer.parseInt(input.nextLine());
				System.out.println("Give us a brief description of the pet");
				String userDescription = input.nextLine();
				
				//now we add that pet to the shelter using the user input
				myVirtualPetShelter.add(new VirtualPet(userNameSelect, userHungerSelect, userThirstSelect,
						userHappySelect, userDescription));
				System.out.println("Welcome, " + myVirtualPetShelter.findPet(userNameSelect).getPetName()
						+ ", we're sure they'll be just fine.....");
				myVirtualPetShelter.tickAllPets();
				break;

			// showing the statuses of all of the pets
			case 6:
				System.out.println("Here are the statuses of the pets: ");
				for (VirtualPet currentPet : myVirtualPetShelter.getAllPets()) {
					System.out.println("Name: " + currentPet.getPetName() + " Hunger Level: "
							+ currentPet.getHungerLevel() + " Thirst Level: " + currentPet.getThirstLevel()
							+ " Happiness Level: " + currentPet.getHappinessLevel());
				}
				break;

			// default for the switch, this should only occur if the while loop or switch
			// cases change
			default:
				System.out.println("Error, an unexpected value has occured");
				break;

			}
			System.out.println("What else would you like to do with the pets?");
			System.out.println("Press 1 to feed all pets");
			System.out.println("Press 2 to water all pets");
			System.out.println("Press 3 to play with a pet");
			System.out.println("Press 4 to adopt a pet");
			System.out.println("Press 5 to admit a pet");
			System.out.println("Press 6 to see the statuses of all of the pets");
			System.out.println("Press any other number to leave the shelter");
			userInput = Integer.parseInt(input.nextLine());
		}
		input.close();
		System.out.println("Goodbye, see you next time!");
		System.exit(0);
	}

}
