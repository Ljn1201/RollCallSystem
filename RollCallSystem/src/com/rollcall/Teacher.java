package com.rollcall;

//定义 Teacher 子类，继承自 Person
public class Teacher extends Person {
 // 1. 新增私有属性：所带班级
 private String className;

 // 2. 构造方法
 public Teacher(String id, String name, String className) {
     super(id, name); // 调用父类构造方法初始化工号和姓名
     this.className = className;
 }

 // 3. className 属性的 getter 和 setter
 public String getClassName() {
     return className;
 }

 public void setClassName(String className) {
     this.className = className;
 }

 // 4. 点名方法
 public void callRoll(Student[] students) {
     System.out.println("\n===== " + getName() + "老师正在对 " + this.className + " 进行点名 =====");
     // 遍历学生数组
     for (Student student : students) {
         // 输出每个学生的点名结果
         System.out.println(student.getId() + " " + student.getName() + "：" + student.getAttendance());
     }
     System.out.println("================== 点名结束 ==================\n");
 }
}
