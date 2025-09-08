package com.rollcall;

import javax.swing.SwingUtilities;

public class RollCallSystem {

    public static void main(String[] args) {
        // 1. 准备数据模型 (和之前一样)
        Teacher teacher = new Teacher("T001", "赵老师", "Java一班");
        
        Student[] students = {
            new Student("2024001", "张三"),
            new Student("2024002", "李四"),
            new Student("2024003", "王五"),
            new Student("2024004", "赵六"),
            new Student("2024005", "孙七")
        };

        // 2. 启动图形用户界面 (GUI)
        // SwingUtilities.invokeLater 确保GUI在正确的线程上创建和显示，这是标准做法
        SwingUtilities.invokeLater(() -> {
            // 创建GUI窗口实例，并将数据传递进去
            RollCallGUI gui = new RollCallGUI(teacher, students);
            // 设置窗口为可见
            gui.setVisible(true);
        });
    }
}