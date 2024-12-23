package io.github.gustavocescon.arquiteturaspring;

import io.github.gustavocescon.arquiteturaspring.todos.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoAcessoEmail {

    @Autowired
    private AppProperties appProperties;

    //@Bean
    public MailSender mailSender(){
        return null;
    }
}
