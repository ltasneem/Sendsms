package crunch.chatbot;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Replacements {

	private HashMap<String,String> repMap;
	
	public Replacements() {
		repMap = new HashMap<String, String>();
		repMap.put("i", "you");
		repMap.put("me", "you");
		repMap.put("my", "your");
		repMap.put("am", "are");
		repMap.put("our", "all of your");
		repMap.put("we", "all of you");
		repMap.put("was", "were");
		repMap.put("you", "me");
		repMap.put("your", "my");
		repMap.put("are", "am");
		repMap.put("all of your", "our");
		repMap.put("were", "was");
		repMap.put("you're","i'm");
		repMap.put("i'm","you're");
		repMap.put("myself", "yourself");
		repMap.put("yourself", "myself");
	}
	
	public boolean addReplacement(String from, String to) {
		repMap.put(from, to);
		return true;
	}
	
	public String replace(String text) {
/*		Set<String> keys = repMap.keySet();
		Iterator<String> iter = keys.iterator();
		for (int i = 0; i < keys.size(); i++) {
			String key = iter.next();
			text = text.replaceAll("\\b" + key + "\\b", repMap.get(key));
		}
		return text;
	}
	*/

		//Ignores 2 word statements
		String[] words = text.split(" ");
		String fixed = "";
		for(int i = 0; i < words.length; i++){
		
			if(this.repMap.containsKey(words[i])){
				fixed = fixed.concat(this.repMap.get(words[i]));
			}
			else{
				fixed = fixed.concat(words[i]);
			}
			
			if(i != words.length - 1){
				fixed = fixed.concat(" ");
			}
		}
		
		return fixed;
	}
}
