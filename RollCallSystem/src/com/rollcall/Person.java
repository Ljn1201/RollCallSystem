package com.rollcall;

//定义 Person 父类
public class Person {
 // 1. 封装私有属性：编号和姓名
 private String id;
 private String name;

 // 2. 提供无参构造方法
 public Person() {
     System.out.println("Person类的无参构造方法被调用");
 }

 // 3. 提供有参构造方法
 public Person(String id, String name) {
     this.id = id;
     this.name = name;
 }

 // 4. 提供 getter 和 setter 方法
 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 // 5. 提供 showInfo 方法
 public void showInfo() {
     System.out.print("编号：" + this.id + "，姓名：" + this.name);
 }
}
