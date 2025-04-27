# 使用Lombok的@Builder注解创建生成器

通过反编译可以看到，Lombok的@Builder注解也是使用的静态内部类来创建生成器。这种使用注解的方式在开发中可以使代码看起来更加简洁。

```java
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;

    User(String firstName, String lastName, int age, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public String toString() {
        return "User(firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + ", phone=" + this.phone + ")";
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String phone;

        UserBuilder() {
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(this.firstName, this.lastName, this.age, this.phone);
        }

        public String toString() {
            return "User.UserBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + ", phone=" + this.phone + ")";
        }
    }
}
```