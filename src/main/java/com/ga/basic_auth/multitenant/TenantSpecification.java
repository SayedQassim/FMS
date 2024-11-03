package com.ga.basic_auth.multitenant;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;


public class TenantSpecification<T> implements Specification<T> {
  @Override
  public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    String tenantId = TenantContext.getTenantId();
    if (tenantId == null) {
      throw new IllegalStateException("Tenant ID is not set");
    }
    return criteriaBuilder.equal(root.get("family").get("id"), tenantId);
  }
}
