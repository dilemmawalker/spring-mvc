package com.dilemmawalker.springMVCValidation.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
}
