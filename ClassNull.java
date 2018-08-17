package apps;

public class ClassNull {

	public static void main(String[] args) {
		
		Person per = new Person();
		
		String getCarInsuName = getCarInsuranceName(per);
		System.out.println(getCarInsuName);

	}
	
	/*public static String getCarInsuranceName(Person person) 
	{ 
		return person.getCar().getInsurance().getName();
	}*/
	
	public static String getCarInsuranceName(Person person) 
	{ 
		if(person!=null) {
			Car car = person.getCar();
		
		if(car!=null)
		{
			Insurance insu = car.getInsurance();
		if(insu!=null)
		{
			return insu.getName();
		}
		}
	}
return "Unknown";
	}
}
