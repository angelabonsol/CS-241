import java.util.*;

public class extSet<T> extends Set<T> {

	Set<T> setA;
	Set<T> setB;

	// union (EC)- Add items of both

	public static <T> Set<T> giveUnion(Set<T> set1, Set<T> set2) {
		
		Set<T> union = new Set<T>();
		
		while (!set1.isEmpty())
			union.add(set1.list);
		
		while (!set2.isEmpty())
			union.add(set2.getLast());
		
		return union;

	}

	// intersection (EC)

	public Set<T> giveIntersection(Set<T> set1, Set<T> set2) {
	
		Set<T> temp1 = new LinkedList<T>(set1);
		
		Set<T> intersection = new Set<T>();

		for (T x : set1)
		      if (set2.contains(x))
		        intersection.add(x);

		return set1;
	}

	// difference (EC)

	public Set<T> giveDifference(Set<T> set1, Set<T> set2) {

		return set1;
	}
	
	//private 

}
