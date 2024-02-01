package com.vh.cleanarchproducts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.UnknownHostException;
import java.util.List;

@EnableWebMvc
@Configuration
public class SwaggerConfig {



    @Bean
    public OpenAPI myOpenAPI() throws UnknownHostException {

        Server server = new Server();
        server.setUrl("/");
        server.setDescription("Local");

        Contact contact = new Contact();
        contact.setEmail("hanelvinicius@gmail.com");
        contact.setName("Vinicius Hansel");

        Info info = new Info()
                .title("Clean Arch Products API")
                .version("1.0.0")
                .description("API to manage products")
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
