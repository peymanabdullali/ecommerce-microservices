package az.msproductservice.validation;

import az.msproductservice.exception.UnauthorizedUserException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

    @Aspect
    @Component
    public class CheckPermissionValidation {

        @Pointcut("@annotation(roleCheck)")
        public void roleCheckMethods(CheckPermission roleCheck) {}

        @Before(value = "roleCheckMethods(roleCheck)", argNames = "roleCheck")
        public void checkRole(CheckPermission roleCheck) {
            String requiredRole = roleCheck.value();
            String userRole = getUserRoleFromHeader();

            if (!requiredRole.equals(userRole)) {
                throw new UnauthorizedUserException("User role is not allowed.");
            }
        }
        private String getUserRoleFromHeader() {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String role = attributes.getRequest().getHeader("Role");
            return role != null ? role : "";
        }
    }
