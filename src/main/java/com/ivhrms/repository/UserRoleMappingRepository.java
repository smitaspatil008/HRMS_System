package com.ivhrms.repository;

import com.ivhrms.model.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, UserRoleMapping.UserRoleMappingId> {
    List<UserRoleMapping> findByUserId(String userId);
    void deleteByUserIdAndRoleId(String userId, Long roleId);
}
