package com.example.beanvalidationmongo.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Document
public class Users {

    @Id
    @Digits(integer = 4, fraction = 0)
    @Min(1000)
    @Max(5000)
    private int id;

    @JsonProperty("name")
    @JsonPropertyDescription("Amdocs WFXTechLogin passed by Amdocs - WFX")
//    @ApiModelProperty(required=true, dataType="string", position=1, value="Amdocs WFXTechLogin passed by Amdocs - WFX", example="ORION")
    @Size(min=1, max=50)
    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Designation is required")
    private String designation;

    @NotNull(message = "Salary is required")
    private Long salary;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message="Mobile number is invalid")
    @NotNull
    private String mobilePhone;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private List<@NotEmpty String> hobbies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Users()
    {
        super();
    }

    public Users(Integer id, @NotEmpty(message = "Name is required") String name, @NotEmpty(message = "Designation is required") String designation, Long salary, @NotEmpty(message = "Email is required") @Email String email, @NotEmpty(message = "Phone number is required") @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
            message = "Mobile number is invalid") String mobilePhone, @Past LocalDate birthday, List<@NotEmpty String> hobbies) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.birthday = birthday;
        this.hobbies = hobbies;
    }
}
