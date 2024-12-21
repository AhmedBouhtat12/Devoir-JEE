package demo.tp.springcloud.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RefreshScope
@Component
@ConfigurationProperties("mes-configs")
public class ApplicationPropertiesConfiguration
{

    private int limitDeProduits;
}
