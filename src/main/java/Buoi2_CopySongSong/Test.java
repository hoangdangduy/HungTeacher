package Buoi2_CopySongSong;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	//
	// public static ArrayList<String> listFilesForFolder(final File folder) {
	// ArrayList<String> listFile = new ArrayList<>();
	// for (final File fileEntry : folder.listFiles()) {
	// if (fileEntry.isDirectory()) {
	// listFilesForFolder(fileEntry);
	// } else {
	// listFile.add(folder + "/" + fileEntry.getName());
	// }
	// }
	// return listFile;
	// }
	//
	// public static void main(String[] args) throws IOException {
	//
	// final File folderIN = new File("/home/hoang/Downloads/Session01");
	//
	// final File folderOUT = new File("/home/hoang/Desktop/folder out");
	//
	// CopyFile cf;
	// for (int i = 0; i < listFilesForFolder(folderIN).size(); i++) {
	// cf = new CopyFile(folderIN, folderOUT,
	// listFilesForFolder(folderIN).get(i));
	// cf.start();
	// }
	// }

	public static void main(String[] args) {
		String folder1 = "/home/hoang/Downloads/Session01";
		String folder2 = "/home/hoang/Desktop/folder out";

		File[] listFile = new File(folder1).listFiles();

		CopyFileThread cft;
		for (int i = 0; i < listFile.length; i++) {
			cft = new CopyFileThread(listFile[i].getPath(), folder2 + "/" + listFile[i].getName());
			System.out.println(folder2 + listFile[i].getName());
			cft.start();
		}
	}

}
