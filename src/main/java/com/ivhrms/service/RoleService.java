package com.ivhrms.service;

import com.ivhrms.model.Role;
import com.ivhrms.model.User;
import com.ivhrms.model.UserRoleMapping;
import com.ivhrms.repository.RoleRepository;
import com.ivhrms.repository.UserRepository;
import com.ivhrms.repository.UserRoleMappingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserRoleMappingRepository mappingRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository,
                       UserRoleMappingRepository mappingRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.mappingRepository = mappingRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public void deleteRole(String roleName) {
        Role role = roleRepository.findByUserRole(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
        roleRepository.delete(role);
    }

    @Transactional
    public void assignRoles(String loginId, List<String> roleNames) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("User not found with login ID: " + loginId));

        for (String roleName : roleNames) {
            Role role = roleRepository.findByUserRole(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            UserRoleMapping mapping = new UserRoleMapping();
            mapping.setUserId(user.getEmployeeId());
            mapping.setRoleId(role.getRoleId());
            mappingRepository.save(mapping);
        }
    }

    @Transactional
    public void removeRoleFromUser(String loginId, String roleName) {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("User not found with login ID: " + loginId));
        Role role = roleRepository.findByUserRole(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
        mappingRepository.deleteByUserIdAndRoleId(user.getEmployeeId(), role.getRoleId());
    }
}
