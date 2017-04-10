package ie.stairs.interview;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class StairsApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(StairsApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(true)
                .web(true).run(args);
    }
}
