package com.dilemmawalker.springMVCValidation.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
    private String firstName;

    @NotNull(message="is required field")
    @Size(min=1, message="is required in specific format")
    private String lastName;

    @Min(value=0, message="must be greater than or equal to 0")
    @Max(value=10, message="must be less than or equal to 10")
    private int freePass;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 chars/digits allowed")
    private String postalCode;
}
