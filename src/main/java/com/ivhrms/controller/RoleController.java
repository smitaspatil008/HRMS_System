package com.ivhrms.controller;

import com.ivhrms.model.Role;
import com.ivhrms.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping("/createrole")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @DeleteMapping("/removerole/{role_name}")
    public ResponseEntity<Map<String, String>> deleteRole(@PathVariable("role_name") String roleName) {
        roleService.deleteRole(roleName);
        return ResponseEntity.ok(Map.of("message", "Role removed successfully"));
    }

    @PostMapping("/roleassign/{login_id}/roles")
    public ResponseEntity<Map<String, String>> assignRoles(@PathVariable("login_id") String loginId,
                                                           @RequestBody List<String> roleNames) {
        roleService.assignRoles(loginId, roleNames);
        return ResponseEntity.ok(Map.of("message", "Roles assigned successfully"));
    }

    @DeleteMapping("/roleunassign/{login_id}/roles/{role_name}")
    public ResponseEntity<Map<String, String>> removeRole(@PathVariable("login_id") String loginId,
                                                          @PathVariable("role_name") String roleName) {
        roleService.removeRoleFromUser(loginId, roleName);
        return ResponseEntity.ok(Map.of("message", "Role removed successfully"));
    }
}
