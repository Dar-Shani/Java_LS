package core_ls_5;


import java.nio.file.*;

public class Archivist {
    private Path pathBackup = Path.of("C:\\Users\\RobotComp.ru\\Desktop\\Script\\Java_Core\\core_ls_5\\backup");
    private Path pathTarget = Path.of("C:\\Users\\RobotComp.ru\\Desktop\\Script\\Java_Core\\core_ls_5\\dir1");
    
    
    public void saveFile () {

        try (DirectoryStream<Path> file = Files.newDirectoryStream(pathTarget)) {
            Files.createDirectories(pathBackup);
            for(Path path: file) {
                if((!Files.isDirectory(path)) && (!Files.exists(pathBackup.resolve(path.getFileName())))) {
                    System.out.println("copy " + path.getFileName());
                    Files.copy(path, pathBackup.resolve(path.getFileName()));
                } else {
                    System.out.println("Имеется дубликат файла " + path.getFileName());
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка при копирование");
        }
    }
}
