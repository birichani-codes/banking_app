package birichani.code.banking.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
A DTO (Data Transfer Object) is a lightweight object used to transfer data between layers in an application,
typically containing only fields and getters/setters without any business logic.
It helps ensure data consistency and reduces unnecessary data exposure between different components.
*/

@Data
@AllArgsConstructor
@Schema(description = "DTO representing an account with ID, account holder's name, and balance")
public class AccountDto {

    @Schema(description = "Unique identifier for the account", example = "1")
    private Long id;

    @Schema(description = "Name of the account holder", example = "John Doe")
    private String accountHolderName;

    @Schema(description = "Balance amount of the account", example = "1500.75")
    private double balance;
}
