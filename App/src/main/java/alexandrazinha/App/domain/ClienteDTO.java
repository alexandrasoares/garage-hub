package alexandrazinha.App.domain;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotNull
    private Long id;
    @NotNull
    @Size(min = 3)
    private String nome;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
