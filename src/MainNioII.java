
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainNioII {

	public static void main(String[] args) {
		Path path = Paths.get("Test.txt");
		System.out.println("Chemin absolu : " +path.toAbsolutePath());
		System.out.println("Existe : " +Files.exists(path));
		System.out.println("Nom : " +path.getFileName());
		System.out.println("Répertoire : " +Files.isDirectory(path));
		
		Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
		for(Path chemin : roots) {
			System.out.println(chemin);
			
			try (DirectoryStream<Path> listing = Files.newDirectoryStream(chemin, "*.Bin")) {
				for(Path nom : listing) {
					System.out.println("\t\t" + ((Files.isDirectory(nom)) ? nom+"/" : nom));
				}
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
