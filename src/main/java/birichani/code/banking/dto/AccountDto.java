package birichani.code.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
A DTO (Data Transfer Object is a lightweight object used to transfer data between layers in an application, typically containing only fields and getters/setters without any business logic.
It helps ensure data consistency and reduces unnecessary data exposure between different components.
*/

@Data
@AllArgsConstructor

public class AccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
