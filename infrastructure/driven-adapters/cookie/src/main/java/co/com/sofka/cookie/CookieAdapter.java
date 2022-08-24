package co.com.sofka.cookie;

import co.com.sofka.model.cookies.Cookie;
import co.com.sofka.model.cookies.gateways.CookieRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class CookieAdapter implements CookieRepository {


    @Override
    public Mono<Cookie> findByCode(String code) {
        return getGalletas().filter(cookie -> cookie.getCode().equalsIgnoreCase(code))
                .last();
    }

    private static Flux<Cookie> getGalletas(){
        return Flux.fromIterable(List.of(
                Cookie.builder().code("001").description("oreo").build(),
                Cookie.builder().code("002").description("festival").build(),
                Cookie.builder().code("003").description("chokis").build(),
                Cookie.builder().code("004").description("muuu").build(),
                Cookie.builder().code("005").description("lecheritas").build(),
                Cookie.builder().code("006").description("saltinas").build(),
                Cookie.builder().code("007").description("ducales").build(),
                Cookie.builder().code("008").description("minichips").build(),
                Cookie.builder().code("009").description("galletas de avena").build(),
                Cookie.builder().code("010").description("navideñas").build()
                )

        );
    }


}
