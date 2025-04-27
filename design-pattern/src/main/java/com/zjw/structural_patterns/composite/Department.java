package com.zjw.structural_patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合节点 - 部门
 * @author jw
 * @since 2025/04/24 04:34
 */
class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayDetails(String prefix) {
        System.out.println(prefix + "└─ 部门: " + name);
        for (OrganizationComponent member : members) {
            member.displayDetails(prefix + "    ");
        }
    }

    @Override
    public void add(OrganizationComponent component) {
        members.add(component);
    }
}
