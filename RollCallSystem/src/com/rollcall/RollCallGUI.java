package com.rollcall;

import javax.swing.*; // 导入 Swing GUI 组件
import java.awt.*;    // 导入布局和颜色等工具

// GUI 类，继承自 JFrame，代表一个窗口
public class RollCallGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 持有教师和学生的数据
    private Teacher teacher;
    private Student[] students;

    // 构造方法，接收数据并初始化界面
    public RollCallGUI(Teacher teacher, Student[] students) {
        this.teacher = teacher;
        this.students = students;

        // 1. 设置窗口基本属性
        setTitle("班级点名系统"); // 设置窗口标题
        setSize(400, 300); // 设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口时程序退出
        setLocationRelativeTo(null); // 窗口居中显示

        // 2. 创建顶部面板，用于显示教师和班级信息
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel teacherInfoLabel = new JLabel("点名教师：" + teacher.getName() + " | 班级：" + teacher.getClassName());
        topPanel.add(teacherInfoLabel);
        add(topPanel, BorderLayout.NORTH); // 将顶部面板添加到窗口北部

        // 3. 创建中央面板，用于显示学生列表和操作按钮
        JPanel centerPanel = new JPanel();
        // 使用 BoxLayout，让每个学生信息垂直排列
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // 遍历学生数组，为每个学生创建一行信息和操作按钮
        for (Student student : students) {
            JPanel studentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            // 显示学生学号和姓名
            JLabel studentNameLabel = new JLabel(student.getId() + " " + student.getName());
            studentNameLabel.setPreferredSize(new Dimension(120, 20)); // 设置固定宽度以便对齐

            // 显示学生当前的出勤状态，这个 Label 将被实时更新
            JLabel statusLabel = new JLabel("状态：" + student.getAttendance());
            statusLabel.setPreferredSize(new Dimension(100, 20));

            // 创建状态设置按钮
            JButton presentButton = new JButton("出勤");
            JButton lateButton = new JButton("迟到");
            JButton absentButton = new JButton("缺勤");

            // --- 核心交互逻辑：为按钮添加点击事件监听器 ---
            presentButton.addActionListener(e -> {
                student.updateAttendance("出勤"); // 1. 更新后台学生对象的状态
                statusLabel.setText("状态：" + student.getAttendance()); // 2. 实时更新界面上的状态文本
            });

            lateButton.addActionListener(e -> {
                student.updateAttendance("迟到");
                statusLabel.setText("状态：" + student.getAttendance());
            });

            absentButton.addActionListener(e -> {
                student.updateAttendance("缺勤");
                statusLabel.setText("状态：" + student.getAttendance());
            });
            
            // 将所有组件添加到单行学生面板中
            studentPanel.add(studentNameLabel);
            studentPanel.add(statusLabel);
            studentPanel.add(presentButton);
            studentPanel.add(lateButton);
            studentPanel.add(absentButton);
            
            // 将这行学生面板添加到垂直排列的中央面板中
            centerPanel.add(studentPanel);
        }
        
        // 为了美观，将中央面板放入一个滚动窗格中（如果学生太多）
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        add(scrollPane, BorderLayout.CENTER); // 将滚动窗格添加到窗口中央
    }
}