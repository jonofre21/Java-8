package lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

public class ReducingStreams {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	

		//1.	Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> tran2011 = transactions.stream()
									.filter(x->x.getYear()==2011)
									.sorted(comparing(Transaction::getValue))
									.collect(toList());
		System.out.println(tran2011);
		
		//2.	What are all the unique cities where the traders work?
		List<String> uniqueCities = transactions.stream()
										.map(x-> x.getTrader().getCity())
										.distinct()
										.collect(toList());
		System.out.println(uniqueCities);
		//3.	Find all traders from Cambridge and sort them by name.
		List<Trader> tradersName = transactions.stream()
									.filter(x->x.getTrader().getCity().equalsIgnoreCase("cambridge"))
									.map(x->x.getTrader())
									.distinct()
									.sorted(comparing(Trader::getName))
									.collect(toList());
		System.out.println(tradersName);
		//4.	Return a string of all traders’ names sorted alphabetically.
		String Stringname = transactions.stream()
									.map(x->x.getTrader().getName())
									.distinct()
									.reduce("", (x,y)->x+y);
									System.out.println(Stringname);
		//5.	Are any traders based in Milan?
					if(transactions.stream().anyMatch(x-> x.getTrader().getCity().equalsIgnoreCase("Milan")))	
							{
								System.out.println("There is at least one Trader in Milan");
							}
					else
					{
						System.out.println("There are not Traders in Milan");
					}
		//6.	Print all transactions’ values from the traders living in Cambridge.
					List<Integer> TranValue = transactions.stream()
									.filter(x->x.getTrader().getCity().equalsIgnoreCase("Cambridge"))
									.map(x-> x.getValue())
									.collect(toList());
					System.out.println(TranValue);
		//7.	What's the highest value of all the transactions?
					Optional<Integer> max = transactions.stream()
									.map(x->x.getValue())
									.reduce(Integer::max);
					System.out.println(max);
		//8.	Find the transaction with the smallest value.
					Optional<Integer> min = transactions.stream()
									.map(x->x.getValue())
									.reduce(Integer::min);
					System.out.println(min);
		//9.	For each trader, return the number of lowercase letters in the name 
					//(hint: look at the chars method on String).
					List<Long> nlower = transactions.stream()
							                 .map(x->x.getTrader().getName().chars().filter(Character::isLowerCase).count())
							                 .collect(toList());
					System.out.println(nlower);
		//10.	Find the city String with the largest number of lowercase letters from all the cities in the transaction list. 
		//Experiment with returning an Optional<String> to account for the case of an empty input list.
	
				String cityName=transactions.stream()

                                         .map(x->x.getTrader().getCity())

                                        .max(Comparator.comparingLong(o -> o.chars().filter(Character::isLowerCase).count()))
								.get();
								 
								 System.out.println(cityName);
						
						
					
	}

}
