package vttp2022.ssf.workshop13Redo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
// import java.util.List;
import java.util.Set;

// import org.springframework.boot.DefaultApplicationArguments;
// import org.springframework.boot.SpringApplication;

// import vttp2022.ssf.workshop13Redo.Workshop13RedoApplication;

public class IOUtil {
    

    public static void createDir(String path) {
        File dir = new File(path);
        dir.mkdirs();

        String osName = System.getProperty("os.name");

        if(!osName.contains("Windows")) {
            try {
                String perm = "rwxrwx--";
                Set<PosixFilePermission> permissions = PosixFilePermissions.fromString(perm);
                Files.setPosixFilePermissions(dir.toPath(), permissions);
            } catch (IOException e) {

            }
        }
        
         
    }
}
