package lab3;

public class AnonymusClass {

	public final int x=5;
	
	public void Print()
	{
		int x=9;
		
		Runnable  r = new Runnable()
				{
				public final int x=10;
					
					public void run() {
					
						int x =7;
						System.out.println(this.x);
						
					}
			
				};
				
				r.run();
	}
	
	public static void main(String[] args) 
	{
		AnonymusClass an = new AnonymusClass();
		for(int h=0;h<5;h++)
		an.Print();

	}

}
