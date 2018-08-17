package lab12;

import java.util.Arrays;
import java.util.Optional;

public class ClassOption {

	public static void main(String[] args) {
		
		Insurance Scotia = new Insurance("Scotia IS NICE TOO ...");
		Insurance HSBC = new Insurance("HSBC IS NICE");
		Insurance CambridgeInsurance = new Insurance(null);
		
		Car nissan = new Car(Scotia);
		Car toyota = new Car(HSBC);
		Car ford = new Car(HSBC);
		Car chevrolet = new Car(null);
		
		Person Sunit = new Person(toyota,30);
		Person Jesus = new Person(ford,31);
		Person Seneha = new Person(chevrolet,23);
		Person Alekia = new Person(null,25);
		
		Optional<Person> sc = Optional.of(Sunit);
		//Optional<Person> sc1 = Optional.of(Jesus);
		Optional<Person> sc1 = Optional.ofNullable(Jesus); 
		Optional<Person> sc2 = Optional.of(Alekia);
		//It returns an empty value of the Type car
		Optional<Car> optCar = Optional.empty();
		System.out.println(optCar);
		
		//Returns the car reference instead of null ...
		Optional<Car> optCar2 = Optional.ofNullable(ford);
		//Optional<Car> optCar2 = Optional.of(ford);
		System.out.println(optCar2);
		//This creates an Optional that can handle a Null value ...
		Optional<Car> optCar3 = Optional.ofNullable(chevrolet);
		System.out.println(optCar3);
		
		//This command traverse all the values ignoring the null ones ...
		Optional<Insurance> optInsurance = Optional.ofNullable(CambridgeInsurance); 
		Optional<String> name = optInsurance.map(Insurance::getName);
		System.out.println(name);
		
		String getCarInName = getCarInsuranceName(sc1);
		System.out.println(getCarInName);
		
		Insurance famousInsurance = findCheapestInsurance(Jesus,ford);
		System.out.println(famousInsurance);
		
		Optional<Insurance> famousInsurance2 = nullSafeFindCheapestInsurance(sc1, optCar2);
		System.out.println(famousInsurance2);
		
		Optional<Insurance> optInsurance2 = Optional.ofNullable(HSBC);
				optInsurance2.filter(insurance -> "CambridgeInsurance".equals(insurance.getName()))
		.ifPresent(x -> System.out.println("This shit doesnt make sense so far ..."));
				
		String getCarInName2 = getCarInsuranceName5(sc2,28);
		System.out.println(getCarInName2);
	}
	
	public static String getCarInsuranceName(Optional<Person> person)
	{
		return person.flatMap(Person::getCar)
				.flatMap(Car::GetInsurance)
				.map(Insurance::getName)
				.orElse("Fucking insane");
	}
	
	public static Optional<Insurance> nullSafeFindCheapestInsurance( Optional<Person> person, Optional<Car> car)
	{
		return person.flatMap(p->car.map(c->findCheapestInsurance(p,c)));
	}
	
	public static Insurance findCheapestInsurance(Person person, Car car) {
		// queries services provided by the different insurance companies
		// compare all those data
		
		return person.getCar().flatMap(m-> car.GetInsurance()).get();
		
		}
	
	public static String getCarInsuranceName5(Optional<Person> person, int minAge)
	{
		return person.filter(p-> p.getAge() >= minAge)
						.flatMap(Person::getCar)
						.flatMap(Car::GetInsurance)
				.map(Insurance::getName)
				.orElse("Fuck");
	}
	
	
	
	/*public Optional<Insurance> nullSafeFindCheapestInsurance( Optional<Person> person, Optional<Car> car) {
		if (person.isPresent() && car.isPresent()) { return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else { return Optional.empty();
		} }

	public static String getCarInsuranceName(Person person) 
	{ 
		return person.getCar().
	}*/
}
