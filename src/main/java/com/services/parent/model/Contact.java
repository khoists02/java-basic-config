package com.services.parent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import javax.validation.constraints.Email;
import java.util.Objects;

@Entity(name = "contacts")
@Getter
@Setter
public class Contact extends BaseEntity {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String Email;
    private String phone;

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getClass());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return ((Contact) o).getId().equals(this.getId());
    }
}
