package com.ivhrms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "employee_id")
    @JsonProperty("employeeID")
    private String employeeId;

    @Column(name = "login_id")
    @JsonProperty("loginID")
    private String loginId;

    @Column(name = "first_name")
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "job_title")
    @JsonProperty("jobTitle")
    private String jobTitle;

    @Column(name = "manager_id")
    @JsonProperty("managerID")
    private String managerId;

    @Column(name = "department")
    private String department;

    @Column(name = "cost_center")
    @JsonProperty("costCenter")
    private String costCenter;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "manager")
    private String manager;

    @Column(name = "hire_date")
    @JsonProperty("hireDate")
    private String hireDate;

    @Column(name = "is_rehire")
    @JsonProperty("isRehire")
    private String isRehire;

    @Column(name = "termination_date")
    @JsonProperty("terminationDate")
    private String terminationDate;

    @Column(name = "user_status")
    @JsonProperty("userStatus")
    private String userStatus;

    @Column(name = "employee_type")
    @JsonProperty("employeeType")
    private String employeeType;

    @Column(name = "user_career_level")
    @JsonProperty("userCareerLevel")
    private String userCareerLevel;

    @Column(name = "mobile_number")
    @JsonProperty("mobileNumber")
    private String mobileNumber;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "gender")
    private String gender;

    @Column(name = "postal_code")
    @JsonProperty("postalCode")
    private String postalCode;

    @Column(name = "vacation_start_date")
    @JsonProperty("vacationStartDate")
    private String vacationStartDate;

    @Column(name = "vacation_end_date")
    @JsonProperty("vacationEndDate")
    private String vacationEndDate;

    @Column(name = "proxy_id")
    @JsonProperty("proxyID")
    private String proxyId;

    @Column(name = "user_role")
    @JsonProperty("userRole")
    private String userRole;

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public String getManagerId() { return managerId; }
    public void setManagerId(String managerId) { this.managerId = managerId; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getCostCenter() { return costCenter; }
    public void setCostCenter(String costCenter) { this.costCenter = costCenter; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getManager() { return manager; }
    public void setManager(String manager) { this.manager = manager; }
    public String getHireDate() { return hireDate; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }
    public String getIsRehire() { return isRehire; }
    public void setIsRehire(String isRehire) { this.isRehire = isRehire; }
    public String getTerminationDate() { return terminationDate; }
    public void setTerminationDate(String terminationDate) { this.terminationDate = terminationDate; }
    public String getUserStatus() { return userStatus; }
    public void setUserStatus(String userStatus) { this.userStatus = userStatus; }
    public String getEmployeeType() { return employeeType; }
    public void setEmployeeType(String employeeType) { this.employeeType = employeeType; }
    public String getUserCareerLevel() { return userCareerLevel; }
    public void setUserCareerLevel(String userCareerLevel) { this.userCareerLevel = userCareerLevel; }
    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
    public String getVacationStartDate() { return vacationStartDate; }
    public void setVacationStartDate(String vacationStartDate) { this.vacationStartDate = vacationStartDate; }
    public String getVacationEndDate() { return vacationEndDate; }
    public void setVacationEndDate(String vacationEndDate) { this.vacationEndDate = vacationEndDate; }
    public String getProxyId() { return proxyId; }
    public void setProxyId(String proxyId) { this.proxyId = proxyId; }
    public String getUserRole() { return userRole; }
    public void setUserRole(String userRole) { this.userRole = userRole; }
}
