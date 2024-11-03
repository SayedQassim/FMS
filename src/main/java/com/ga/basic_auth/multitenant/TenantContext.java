package com.ga.basic_auth.multitenant;

public class TenantContext {
  private static final ThreadLocal<Long> CURRENT_TENANT = new ThreadLocal<>();

  public static void setTenantId(Long tenantId) {
    System.out.println("Setting tenant ID: " + tenantId); // Debug log
    CURRENT_TENANT.set(tenantId);
  }

  public static Long getTenantId() {
    return CURRENT_TENANT.get();
  }

  public static void clear() {
    CURRENT_TENANT.remove();
  }
}
