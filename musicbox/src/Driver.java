import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import com.musicbox.hosting.dao.Song;




public class Driver {

	public static void main(String[] args) {
		System.out.println("hello world!");
		
		ST hello = new ST("Hello, <name>");
		hello.add("name", "world!");
		System.out.println(hello.render());
		
		DatabaseService service = new DatabaseService();
		List<Song> songs = service.getAllSongs();
		for (Song s: songs){
			System.out.println("Title: " + s.getTitle() + " " + s.getPath());
		}
		
//		try {
//			Scanner keyboard = new Scanner(new File("file.txt"));
//			System.out.println("file: " + keyboard.nextLine());
//			keyboard.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

}
