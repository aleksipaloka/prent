package gr.hua.dit.ds.prent.Payload.Request;

import gr.hua.dit.ds.prent.Entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class SignUpRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String personalPW;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private Set<String> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPersonalPW() {
        return personalPW;
    }

    public void setPersonalPW(String personalPW) {
        this.personalPW = personalPW;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

}
