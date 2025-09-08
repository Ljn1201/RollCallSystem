package com.rollcall;

public class RollCallSystem {

    public static void main(String[] args) {
        // 1. 创建 3 个 Student 对象
        Student student1 = new Student("2024001", "张三");
        Student student2 = new Student("2024002", "李四");
        Student student3 = new Student("2024003", "王五");

        // 2. 将学生对象存入数组
        Student[] students = {student1, student2, student3};
        
        // 3. 创建 1 个 Teacher 对象
        Teacher teacher = new Teacher("T001", "赵老师", "Java一班");

        // 4. 第一次点名
        System.out.println("--- 场景一：常规点名 ---");
        teacher.callRoll(students);

        // 5. 模拟“迟到”场景：更新学生状态
        System.out.println("--- 场景二：张三迟到了，更新其状态 ---");
        student1.updateAttendance("迟到");
        
        // 6. 再次点名，观察结果变化
        System.out.println("\n--- 再次点名，查看更新后的状态 ---");
        teacher.callRoll(students);
        
        // 7. 使用 showInfo 方法查看单个学生完整信息
        System.out.println("--- 查看张三的详细信息 ---");
        student1.showInfo();

        //新场景
        System.out.println("\n--- 场景三：演示 getter 和 setter 方法 ---");
        
        // 1. 调用 student2 对象的 getId() 方法获取其学号
        // getId() 方法会返回一个 String 类型的值，我们需要用一个变量来接收它
        String lisiId = student2.getId();
        System.out.println("通过 getId() 方法获取到李四的学号是：" + lisiId);

        // 2. 调用 student2 对象的 setName() 方法，将其姓名修改为 "李小四"
        // setName() 方法需要传入一个新的名字作为参数
        System.out.println("准备将'李四'的姓名修改为'李小四'...");
        student2.setName("李小四");

        // 3. 验证姓名的修改是否成功，再次调用 showInfo() 查看最新信息
        System.out.println("姓名修改完毕，查看李四的最新信息：");
        student2.showInfo();
        
        System.out.println("\n*************** 辅导员功能演示 ***************");
        
        // 1. 创建一个 Counselor 对象
        Counselor counselorWang = new Counselor("C01", "王辅导员");
        
        // 2. 调用 showInfo 查看辅导员基本信息
        System.out.println("--- 辅导员基本信息 ---");
        counselorWang.showInfo();

        // 3. 为辅导员分配他需要管理的班级
        System.out.println("\n--- 为辅导员分配班级 ---");
        counselorWang.addClass("Java一班");
        counselorWang.addClass("Python进阶班");
        counselorWang.addClass("前端开发A班");

        // 4. 调用方法，显示他管理的所有班级
        counselorWang.showManagedClasses();

    }
}
    