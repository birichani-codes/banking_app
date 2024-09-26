package birichani.code.banking.mapper;

import birichani.code.banking.dto.AccountDto;
import birichani.code.banking.entity.Account;
/*
A Mapper is a utility class used to convert one object type to another, such as converting between entities and Data Transfer Objects (DTOs). This helps separate internal application models from external representations, like API responses.
- `mapToAccount(AccountDto accountDto)`:Converts a DTO into an `Account` entity.
- ‘mapToAccountDto(Account account)`: Converts an `Account` entity into a DTO for safe data exposure.
Using mappers keeps different layers of an application isolated, enhances security, and simplifies code management.
*/

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
          account.getId(),
          account.getAccountHolderName(),
          account.getBalance()
        );
        return accountDto;
    }
}
