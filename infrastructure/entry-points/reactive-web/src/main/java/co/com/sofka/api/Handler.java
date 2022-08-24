package co.com.sofka.api;

import co.com.sofka.usecase.cookie.CookieUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private  final CookieUseCase useCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        var code = serverRequest.pathVariable("code");

        return useCase.findByCode(code)
                .flatMap(cookie -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cookie))
                .onErrorResume(error-> Mono.just(error.getMessage())
                .flatMap(serverResponse ->
                        ServerResponse.status(HttpStatus.NOT_FOUND)
                        .bodyValue("Galleta no encontrada con codigo ".concat(code))));

    }


}
