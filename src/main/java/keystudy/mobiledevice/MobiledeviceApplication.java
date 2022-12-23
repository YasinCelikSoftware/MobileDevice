package keystudy.mobiledevice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import keystudy.mobiledevice.business.abstracts.MobileDeviceService;
import keystudy.mobiledevice.entities.concretes.MobileDevice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class MobiledeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobiledeviceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    @Bean
    CommandLineRunner runner(MobileDeviceService mobileDeviceService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<MobileDevice>> typeReference = new TypeReference<List<MobileDevice>>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/devices.json");
            try {
                List<MobileDevice> mobileDevices = mapper.readValue(inputStream, typeReference);
                mobileDeviceService.save(mobileDevices);
                System.out.println("Mobile Devices Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }

}
