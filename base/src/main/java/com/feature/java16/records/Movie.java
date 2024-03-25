package com.feature.java16.records;

/**
 * Record 记录
 * <p>
 * - Transparent modeling of data as data
 * <p>
 * - Superclass always {@link java.lang.Record}
 * <p>
 * - Cannot be extend, abstract, and implicitly final
 * <p>
 * - All fields are final (shallowly immutable)
 * <p>
 * - Cannot declare instance fields
 * <p>
 * - Accessors, hashCode(), toString(), equals(), automatically generated
 *
 * @author 朱俊伟
 * @since 2024/03/20 0:41
 */
public record Movie(String title, int releaseYear) { }

