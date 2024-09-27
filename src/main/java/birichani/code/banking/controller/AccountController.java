package birichani.code.banking.controller;

import birichani.code.banking.dto.AccountDto;
import birichani.code.banking.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@Tag(
        name = "Account Resource",
        description = "CRUD REST APIs for managing accounts"
)
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(
            summary = "Create a new Account",
            description = "Create a new account by providing account details in the request body",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Account successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid account details provided")
            }
    )
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Account by ID",
            description = "Retrieve the details of a specific account using its unique ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account retrieved successfully"),
                    @ApiResponse(responseCode = "404", description = "Account not found with the given ID")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @Operation(
            summary = "Deposit into Account",
            description = "Deposit a specific amount into the account using the account ID and amount in the request body",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Amount deposited successfully"),
                    @ApiResponse(responseCode = "404", description = "Account not found with the given ID"),
                    @ApiResponse(responseCode = "400", description = "Invalid deposit amount")
            }
    )
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @Operation(
            summary = "Withdraw from Account",
            description = "Withdraw a specific amount from the account using the account ID and amount in the request body",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Amount withdrawn successfully"),
                    @ApiResponse(responseCode = "404", description = "Account not found with the given ID"),
                    @ApiResponse(responseCode = "400", description = "Invalid withdrawal amount")
            }
    )
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

    @Operation(
            summary = "Get All Accounts",
            description = "Retrieve all accounts stored in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All accounts retrieved successfully"),
            }
    )
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @Operation(
            summary = "Delete Account",
            description = "Delete an account from the database using its unique ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Account successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Account not found with the given ID")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }
}
