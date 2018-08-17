package lab11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;


public class GroupingTran {

	 public static List<Transaction> transactions = Arrays.asList( new Transaction(Currency.EUR, 1500.0),
             new Transaction(Currency.USD, 2300.0),
             new Transaction(Currency.GBP, 9900.0),
             new Transaction(Currency.EUR, 1100.0),
             new Transaction(Currency.JPY, 7800.0),
             new Transaction(Currency.CHF, 6700.0),
             new Transaction(Currency.EUR, 5600.0),
             new Transaction(Currency.USD, 4500.0),
             new Transaction(Currency.CHF, 3400.0),
             new Transaction(Currency.GBP, 3200.0),
             new Transaction(Currency.USD, 4600.0),
             new Transaction(Currency.JPY, 5700.0),
             new Transaction(Currency.EUR, 6800.0) );
	
	public static void main(String[] args) {
		
		Optional<Double> tsum = transactions.stream().map(x->x.getValue()).reduce(Double::max);
		System.out.println(tsum);
		
		Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
				.collect(groupingBy(Transaction::getCurrency));
		
		System.out.println(transactionsByCurrencies);
		
								
	}
	
	
	
	
	
	public enum Currency {
	        EUR, USD, JPY, GBP, CHF
	    }
}
