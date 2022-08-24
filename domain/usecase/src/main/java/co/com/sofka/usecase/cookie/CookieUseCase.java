package co.com.sofka.usecase.cookie;

import co.com.sofka.model.cookies.Cookie;
import co.com.sofka.model.cookies.gateways.CookieRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CookieUseCase {

    private final CookieRepository repository;

    public Mono<Cookie> findByCode(String code){
        return repository.findByCode(code);
    }
}
