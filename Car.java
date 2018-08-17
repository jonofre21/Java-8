package lab12;

import java.util.Optional;

public class Car {
	
	private Insurance insurance;
	
	public Car(Insurance insurance)
	{
		this.insurance = insurance;
	}
	
	public Optional<Insurance> GetInsurance()
	{
		return Optional.ofNullable(insurance);
	}
}
