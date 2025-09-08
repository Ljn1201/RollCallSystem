package com.rollcall;

// 为了使用 List 集合，需要导入相应的包
import java.util.ArrayList;
import java.util.List;

// 辅导员类，同样继承自 Person
public class Counselor extends Person {

    // 1. 新增私有属性：使用 List<String> 来存储管理的多个班级名
    private List<String> managedClasses;

    // 2. 构造方法
    public Counselor(String id, String name) {
        // 调用父类的构造方法，初始化工号和姓名
        super(id, name);
        // 初始化用于存储班级列表的 ArrayList
        this.managedClasses = new ArrayList<>();
    }

    // 3. 新增方法：添加管理的班级
    public void addClass(String className) {
        this.managedClasses.add(className);
        System.out.println(getName() + " 辅导员现在开始管理班级：" + className);
    }

    // 4. 新增方法：显示所有管理的班级
    public void showManagedClasses() {
        System.out.println("\n===== " + getName() + " 辅导员管理的所有班级列表 =====");
        if (managedClasses.isEmpty()) {
            System.out.println("该辅导员暂未管理任何班级。");
        } else {
            for (String className : managedClasses) {
                System.out.println("- " + className);
            }
        }
        System.out.println("==========================================");
    }

    // 5. 重写 showInfo 方法，以显示辅导员的特定信息
    @Override
    public void showInfo() {
        super.showInfo(); // 调用父类方法显示“编号”和“姓名”
        System.out.println("，角色：辅导员"); // 附加角色信息
    }
}