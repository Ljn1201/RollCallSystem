package com.rollcall;

//定义 Student 子类，继承自 Person
public class Student extends Person {
 // 1. 新增私有属性：出勤状态
 private String attendance;

 // 2. 无参构造方法
 public Student() {
     // super(); // 这行代码默认存在，表示调用父类的无参构造方法
 }

 // 3. 有参构造方法，用于初始化学号和姓名
 public Student(String id, String name) {
     // 使用 super 关键字调用父类的有参构造方法，初始化继承来的属性
     super(id, name);
     // 默认出勤状态为“出勤”
     this.attendance = "出勤";
 }

 // 4. attendance 属性的 getter 方法
 public String getAttendance() {
     return attendance;
 }
 
 // 5. 更新出勤状态的方法
 public void updateAttendance(String status) {
     // 校验状态的合法性
     if ("出勤".equals(status) || "迟到".equals(status) || "缺勤".equals(status)) {
         this.attendance = status;
         System.out.println(getName() + " 的状态已更新为：" + status);
     } else {
         System.out.println("错误：无效的状态值！请输入“出勤”、“迟到”或“缺勤”。");
     }
 }

 // 6. 重写（Override）父类的 showInfo 方法
 @Override
 public void showInfo() {
     // 首先调用父类的 showInfo 方法输出公共信息
     super.showInfo();
     // 然后输出子类特有的信息
     System.out.println("，出勤状态：" + this.attendance);
 }
}