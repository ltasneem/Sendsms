package crunch.chatbot;
import java.util.*;
import java.io.*;
import java.nio.file.Paths;


/*
 * Created by Lubaba Nuzhat Tasneem
 * */

public class Conversation {

	private String path;

	/*Constructor
	 * */

	public Conversation()
	{
		initialize_directory();
	}

	/*
	 * initializes the parent directory
	 */
	public void initialize_directory()
	{

		File root = new File(Paths.get(".").toAbsolutePath().normalize().toString());

		while(!root.getName().equals("Sendsms")){
		 	root = root.getParentFile();
		}
		path = root.getAbsolutePath()+"/Patients/";
		try{
			if(!(new File(path)).isDirectory())
			{
				
				boolean success = (new File(path)).mkdir();
				if (success) {
				//	System.out.println("Directory: Patients created");
				}    

			}
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} 

	}
	/*
	 * Creates directory for each patient
	 * */

	public boolean create_patient_directory(String patientname)
	{
		try{
			if(!(new File(path + patientname)).isDirectory())
			{
				boolean success = (new File(path+patientname)).mkdir();
				if (success) {
	//				System.out.println("Directory: " + patientname + " created");
					return true;
				}  
			}

		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return false;
	}

	/*
	 * saves sessions in patient's directory as  txt files;
	 * */

	public void create_session(String patientname, ArrayList<String> file_s)
	{
		Iterator<String> iter1 = file_s.iterator();
		int num_session = new File(path+patientname).listFiles().length;
		PrintWriter writer=null;
		try {
			writer = new PrintWriter(new File(path+patientname+"/session"+num_session+".txt"));
			for (int i = 0; i < file_s.size(); i++) {
				String s=iter1.next();
				writer.println(s);
				//System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		writer.close();
	}

	/* load previous sessions
	 * */

	public HashMap<String,ArrayList<String>> load_sessions(String patientname) throws IOException
	{
		//ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
		HashMap<String,ArrayList<String>> table = new HashMap<String,ArrayList<String>>();

		int num_session = new File(path+patientname).listFiles().length;
		String line ="";

		for(int i=0;i<num_session;i++)
		{
			ArrayList<String> array = new ArrayList<String>();
			try {

				FileReader fileReader = new FileReader(path+patientname+"/session"+i+".txt");

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while((line = bufferedReader.readLine()) != null) {
					//System.out.println(line);
					array.add(line);
				}   

				bufferedReader.close();         
			}
			catch(FileNotFoundException ex) {
				System.out.println("Unable to open file 'session" + i + "'");                
			}
			table.put("session"+i,array);
		}

		return table;
	}

}
