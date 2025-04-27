package com.zjw.creational_patterns.builder.demo2;

/**
 * 使用静态静态内部类构建者来创建对象
 */
public class Computer {
    // 必选参数
    private final String cpu;
    private final String ram;
    
    // 可选参数
    private final String usb;
    private final String keyboard;
    private final String display;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usb = builder.usb;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", usb='" + usb + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    /**
     * 静态内部类生成器
     */
    public static class Builder {
        // 必选参数
        private final String cpu;
        private final String ram;
        
        // 可选参数
        private String usb = "默认USB";
        private String keyboard = "默认键盘";
        private String display = "默认显示器";

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setUsb(String usb) {
            this.usb = usb;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}