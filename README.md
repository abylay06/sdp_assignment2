# Assignment #2 — Factory Method & Abstract Factory

**Student:** Abylay Altynbassov
**Topic:** Programming Languages and IDEs

## 1. Factory Method

The **Factory Method** pattern separates object creation from object usage. The Creator defines a factory method, while Concrete Creators decide which Concrete Product to create.

### Product

```java
interface ProgrammingLanguage {
    void work();
}
```

### Concrete Products

```java
class Java implements ProgrammingLanguage {
    public void work() {
        System.out.println("Java working!");
    }
}

class Python implements ProgrammingLanguage {
    public void work() {
        System.out.println("Python working!");
    }
}
```

### Creator

```java
abstract class ProgLangFactory {
    public abstract ProgrammingLanguage getProgLang();

    public void planWork() {
        ProgrammingLanguage progLang = getProgLang();
        progLang.work();
    }
}
```

### Concrete Creators

```java
class JavaFactory extends ProgLangFactory {
    public ProgrammingLanguage getProgLang() {
        return new Java();
    }
}

class PythonFactory extends ProgLangFactory {
    public ProgrammingLanguage getProgLang() {
        return new Python();
    }
}
```

**Result:** `JavaFactory` creates `Java`, while `PythonFactory` creates `Python`.

---

## 2. Abstract Factory

The **Abstract Factory** creates families of related products. In this project, the families are:

* Java + IntelliJ
* Python + PyCharm

### Abstract Products

```java
interface ProgrammingLanguage {
    void work();
}

interface IDE {
    void open();
}
```

### Concrete Products

```java
class IntelliJ implements IDE {
    public void open() {
        System.out.println("Opening IntelliJ");
    }
}

class PyCharm implements IDE {
    public void open() {
        System.out.println("Opening PyCharm");
    }
}
```

`Java` and `Python` from Part 1 are also Concrete Products.

### Abstract Factory

```java
interface ProgLangFactory {
    ProgrammingLanguage createProgrammingLanguage();
    IDE createIDE();
}
```

### Concrete Factories

```java
class JavaFactory implements ProgLangFactory {
    public ProgrammingLanguage createProgrammingLanguage() {
        return new Java();
    }

    public IDE createIDE() {
        return new IntelliJ();
    }
}

class PythonFactory implements ProgLangFactory {
    public ProgrammingLanguage createProgrammingLanguage() {
        return new Python();
    }

    public IDE createIDE() {
        return new PyCharm();
    }
}
```

### Client

```java
ProgLangFactory factory = new JavaFactory();

ProgrammingLanguage language =
        factory.createProgrammingLanguage();

IDE ide = factory.createIDE();

language.work();
ide.open();
```

The client uses only the **Abstract Factory** and **Abstract Product** interfaces and does not directly instantiate concrete products.

---

## 3. Clean Code Principles

### 1. Meaningful Names

**Before:**

```java
IDE x;
```

**After:**

```java
IDE ide;
```

Names such as `createIDE()` and `createProgrammingLanguage()` clearly describe their purpose.

### 2. Small Methods

Each factory method performs one task:

```java
public IDE createIDE() {
    return new IntelliJ();
}
```

### 3. Single Responsibility

Each class has one main responsibility: products represent products, while factories create them.

### 4. Programming to Interfaces

```java
ProgrammingLanguage language =
    factory.createProgrammingLanguage();
```

The client depends on the interface rather than a concrete class.

### 5. Consistent Formatting

Classes and methods follow consistent Java naming, indentation, and structure, keeping the code readable and maintainable.

---

## 4. Conclusion

**Factory Method** creates one product type while allowing subclasses to choose the concrete product.

**Abstract Factory** creates a complete family of related products.

```text
Factory Method:
Factory → Java / Python

Abstract Factory:
JavaFactory   → Java + IntelliJ
PythonFactory → Python + PyCharm
```

The project demonstrates both patterns while reducing direct dependencies between the client and concrete products.
