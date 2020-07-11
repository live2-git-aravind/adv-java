package java8;

import java.io.File;

public class FileFilterLambda {
public static void main(String[] args) {
	/*FileFilter fileFilter = new FileFilter() {
		
		@Override
		public boolean accept(File pathname) {
			// TODO Auto-generated method stub
			return pathname.getName().endsWith(".java");
		}
	};*/
	
	
	File directoryFile = new File("C:\\Users\\Aravind\\AdvancedJava\\ld01-java8-master\\src\\java8");
	/*File[] files=directoryFile.listFiles(fileFilter);
	for (File file : files) {
		System.out.println(file.getName());*/
	File[] files= directoryFile.listFiles( pathname -> pathname.getName().endsWith(".java"));
	for (File file : files) {
		System.out.println(file.getName());
	}
	}
	
}

