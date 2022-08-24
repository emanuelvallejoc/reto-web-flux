package co.com.sofka.model.cookies;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Cookie {

    private String code;
    private String description;
}
