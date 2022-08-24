package co.com.sofka.model.cookies.gateways;

import co.com.sofka.model.cookies.Cookie;
import reactor.core.publisher.Mono;

public interface CookieRepository {

    Mono<Cookie> findByCode(String code);
}
