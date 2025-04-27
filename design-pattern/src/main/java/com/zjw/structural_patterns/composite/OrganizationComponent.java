package com.zjw.structural_patterns.composite;

/**
 * 组件接口
 * @author jw
 * @since 2025/04/24 04:34
 */
interface OrganizationComponent {
    String getName();

    void displayDetails(String prefix);

    void add(OrganizationComponent component);
}
