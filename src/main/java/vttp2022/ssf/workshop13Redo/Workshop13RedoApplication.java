package vttp2022.ssf.workshop13Redo;

import java.util.List;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static vttp2022.ssf.workshop13Redo.utils.IOUtil.*;

@SpringBootApplication
public class Workshop13RedoApplication {

	public static final String DATA_DIR = "dataDir";
	public static void main(String[] args) {
		// SpringApplication.run(Workshop13RedoApplication.class, args);

		SpringApplication app = new SpringApplication(Workshop13RedoApplication.class);
        DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

        List<String> optsval = appArgs.getOptionValues("dataDir");

        if (optsval != null) {
            createDir((String)optsval.get(0));
        } else {
			System.exit(1);
        }

		app.run(args);
	}

}
