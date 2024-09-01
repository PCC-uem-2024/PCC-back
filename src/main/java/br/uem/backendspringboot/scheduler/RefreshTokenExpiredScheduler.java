package br.uem.backendspringboot.scheduler;

import br.uem.backendspringboot.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RefreshTokenExpiredScheduler {

    @Autowired
    private final RefreshTokenService service;

    @Scheduled(cron = "0 0 0 * * *")
    public void removeExpiredTokens() {
        service.removeExpiredTokens();
    }

}
