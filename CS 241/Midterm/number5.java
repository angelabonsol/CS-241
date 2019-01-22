import java.util.*;
import java.io.*;

public class number5 {
	public static void main (String[]args) {
	
	myQueue<String> q = new myQueue<String>; 
	Stack<String> s = new Stack<String>;
	
	s.push("Crown");
	s.push("Half penny");
	s.push("Farthing");
	s.push("Penny");
	s.push("Shilling");
	s.push("Sovereign");
	while (!s.isEmpty()) {
		System.out.println(s.pop());
		if (!s.isEmpty())
			q.enqueue(s.pop());
	}
	System.out.println(s.size());
	while(!q.isEmpty())
		System.out.println(q.dequeue());
	System.out.println(q.size());
	
	}
}
