package com.ivhrms.service;

import com.ivhrms.model.User;
import com.ivhrms.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("User not found with login ID: " + loginId));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Transactional
    public void deleteUser(String loginId) {
        User user = getUserByLoginId(loginId);
        userRepository.delete(user);
    }

    @Transactional
    public User disableUser(String loginId) {
        User user = getUserByLoginId(loginId);
        user.setUserStatus("Inactive");
        return userRepository.save(user);
    }

    @Transactional
    public User enableUser(String loginId) {
        User user = getUserByLoginId(loginId);
        user.setUserStatus("Active");
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(String loginId, Map<String, Object> updates) {
        User user = getUserByLoginId(loginId);

        updates.forEach((key, value) -> {
            String val = value != null ? value.toString() : null;
            switch (key) {
                case "firstName" -> user.setFirstName(val);
                case "lastName" -> user.setLastName(val);
                case "email" -> user.setEmail(val);
                case "jobTitle" -> user.setJobTitle(val);
                case "managerID" -> user.setManagerId(val);
                case "department" -> user.setDepartment(val);
                case "costCenter" -> user.setCostCenter(val);
                case "country" -> user.setCountry(val);
                case "city" -> user.setCity(val);
                case "region" -> user.setRegion(val);
                case "manager" -> user.setManager(val);
                case "hireDate" -> user.setHireDate(val);
                case "isRehire" -> user.setIsRehire(val);
                case "terminationDate" -> user.setTerminationDate(val);
                case "userStatus" -> user.setUserStatus(val);
                case "employeeType" -> user.setEmployeeType(val);
                case "userCareerLevel" -> user.setUserCareerLevel(val);
                case "mobileNumber" -> user.setMobileNumber(val);
                case "address" -> user.setAddress(val);
                case "nationality" -> user.setNationality(val);
                case "gender" -> user.setGender(val);
                case "postalCode" -> user.setPostalCode(val);
                case "vacationStartDate" -> user.setVacationStartDate(val);
                case "vacationEndDate" -> user.setVacationEndDate(val);
                case "proxyID" -> user.setProxyId(val);
            }
        });

        return userRepository.save(user);
    }
}
