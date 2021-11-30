package QuanLyCacLoaiTramDo.config;

import QuanLyCacLoaiTramDo.entity.DeviceValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeviceConfig {
    @Bean
    public DeviceValidator validator() {
        return new DeviceValidator();
    }
}
