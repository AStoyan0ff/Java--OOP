<h1 align="center">
  ☕ Java OOP – Object-Oriented Programming  
  <br>
  <img src="https://media.giphy.com/media/du3J3cXyzhj75IOgvA/giphy.gif" width="80">
</h1>

📚 **Java OOP (Object-Oriented Programming) е основата на модерното програмиране на Java.  
Тя се базира на четири основни принципа, които правят кода по-структуриран, лесен за поддръжка и разширяем.**  

---

## 🔑 Четирите принципа на OOP:

---

### <span style="color:#1E90FF; font-weight:bold;">1️⃣ Encapsulation (Капсулация)</span>

✔ **Скриване на вътрешното състояние на обекта и предоставяне на достъп чрез методи.**  
✔ **Използва `private` полета и `public getter/setter` методи.**  
✔ **Цел: Контрол върху данните и предпазване от неправилна употреба.**  

✅ **Пример:**
```java
public class Person {
    private String name; // скрито поле

    public String getName() { // getter
        return name;
    }

    public void setName(String name) { // setter
        this.name = name;
    }
}

```
---

<span style="color:#1E90FF; font-weight:bold;">2️⃣ Inheritance (Наследяване)</span>

✔ Позволява на един клас да наследи полета и методи от друг.
✔ Използва ключовата дума extends.
✔ Цел: Повторна употреба на код и създаване на йерархия.

✅ **Пример:**
```java
class Animal {
    public void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    public void bark() {
        System.out.println("Barking...");
    }
}
```
---

### <span style="color:#1E90FF; font-weight:bold;">3️⃣ Polymorphism (Полиморфизъм)</span>

✔ **Едно действие – различно поведение.**
✔ **Използва method overriding и interfaces.**
✔ **Цел: Гъвкавост и динамика в поведението на обектите.**

✅ **Пример:**
```java
class Animal {
    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof!");
    }
}

```
---

### <span style="color:#1E90FF; font-weight:bold;">4️⃣ Abstraction (Абстракция)</span>

✔ **Скрива сложността и показва само необходимото.**
✔ **Използва abstract класове и интерфейси.**
✔ **Цел: Дефиниране на общи характеристики без детайли за имплементация.**

✅ **Пример:**
```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}
```

