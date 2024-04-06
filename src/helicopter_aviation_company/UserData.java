package helicopter_aviation_company;

import java.time.LocalDate;

public class UserData {
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String jobTitle;

    public UserData(String username, String password, LocalDate dateOfBirth, String jobTitle) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
    }

    // Getters for user data
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
