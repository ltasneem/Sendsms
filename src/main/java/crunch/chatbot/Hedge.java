package crunch.chatbot;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Hedge {
	
	private Set<String> hedgeSet = new HashSet<String>();
	private Random rand = new Random();
	
	public Hedge(){
		hedgeSet.add("Please tell me more... I can hardly contain my excitement");
		hedgeSet.add("Many of my patients tell me the same thing");
		hedgeSet.add("Oh my god that is the funniest thing I have ever heard... sorry...");
		hedgeSet.add("I'm fairly certain you just made that up");
		hedgeSet.add("Ah, I didn't know that");
		hedgeSet.add("I had a feeling that this was the case");
		hedgeSet.add("Well there's no use crying about it");
		hedgeSet.add("I don't know what to say to that");
		hedgeSet.add("Hahahaha... Oh... you were being serious...");
		hedgeSet.add("Maybe you just need a special someone in your life");
		hedgeSet.add("Honestly, I really don't think I get paid enough to listen to this");
		hedgeSet.add("lol");
		hedgeSet.add("I won't tell anyone I promise");
		hedgeSet.add("Well, at least the weather is nice today");
		hedgeSet.add("Ew, you repulse me");
		hedgeSet.add("You're not the only one who feels this way");
		hedgeSet.add("Whatever you say sweetheart");
		hedgeSet.add("Maybe you should think of how much better off everybody else is");
		hedgeSet.add("That's just how life is sometimes");
		hedgeSet.add("Oh believe me, I know how you feel");
		hedgeSet.add("You tell such fascinating stories.. maybe we should focus on reality though");
		
	}
	
	public String get(){
		int index = rand.nextInt(hedgeSet.size());
		Iterator<String> iter = hedgeSet.iterator();
		for (int i = 0; i < index; i++) {
			iter.next();
		}
		return iter.next();
	}
	
	public void add(String hedge){
		hedgeSet.add(hedge);
	}
}
