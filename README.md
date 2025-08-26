<h1 align="center">
  ☕ Java OOP – Object-Oriented Programming  
  <br>
  <img src="https://media.giphy.com/media/du3J3cXyzhj75IOgvA/giphy.gif" width="80">
</h1>

📚 **Java OOP (Object-Oriented Programming) е основата на модерното програмиране на Java.  
Тя се базира на четири основни принципа, които правят кода по-структуриран, лесен за поддръжка и разширяем.**  

---

## 🔑 Четирите принципа на OOP:
<p align="center">
  <img src="https://raw.githubusercontent.com/your-username/your-repo/main/oop-principles-diagram.png" width="500" alt="OOP Principles Diagram">
</p>

---

### 1️⃣ **Encapsulation (Капсулация)**
✔ Скриване на вътрешното състояние на обекта и предоставяне на достъп чрез методи.  
✔ Използва **private полета** и **public getter/setter методи**.  
✔ Цел: Контрол върху данните и предпазване от неправилна употреба.  

✅ *Пример:*
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

