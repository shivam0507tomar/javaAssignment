import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"Jan", "Feb", "March", "Apr", "May","June","July","August","Sept","Oct","Nov","Dec"};

	      
	      List<String> list = Arrays.asList(array);
		try {
			HashMap<Integer,Integer> map = countOfFiles("E:\\Desktop\\MarkSheet");
			System.out.println(map);
			 Iterator<Entry<Integer, Integer>> hmIterator = map.entrySet().iterator();
			 while (hmIterator.hasNext()) { 
		            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
		             
		            System.out.println(list.get((int) mapElement.getKey()) + " : " + mapElement.getValue()); 
		            
		        } 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static HashMap<Integer,Integer> countOfFiles(final String directoryPath) throws IOException {
	    final List<File> files = Arrays.asList(new File(directoryPath).listFiles());
	    HashMap<Integer,Integer> map=new HashMap<>();
	    for (final File f : files) {
	    	
	    	Path filePath0 = f.toPath();
			BasicFileAttributes attributes0 = null;
			attributes0 =
			        Files.readAttributes(filePath0, BasicFileAttributes.class);
			Date creationDate0 =
                    new Date(attributes0.creationTime().to(TimeUnit.MILLISECONDS));
			
			if(map.containsKey(creationDate0.getMonth()))
			{
				int v=map.get(creationDate0.getMonth());
				v++;
				map.put(creationDate0.getMonth(),v);
			}
			else {
				map.put(creationDate0.getMonth(), 1);
			}
	    }    
		return map;
	}
}
