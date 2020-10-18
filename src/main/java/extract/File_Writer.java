package extract;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_Writer {
	public void writeFileJson(String fileName, String json) {
		File file = new File("C:\\Users\\admin\\Desktop\\"+fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(json);
			fw.close();
			System.out.println("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeFileJson(String path, String fileName, String json) {
		File file = new File(path+fileName);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write(json);
			fw.close();
			System.out.println("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		File_Writer f = new File_Writer();
		f.writeFileJson("test.json", "{\"name\":\"Vinh\",\"salary\":1200.0,\"age\":27}");
		
	}
}
