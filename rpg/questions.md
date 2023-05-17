# Question 1

In step 1, you were asked to create a `Room` class with a description, which will be printed if inspected. Two software developers proposed two different implementations for the `Room` class.

The first developer proposed one implementation:
```java
public class Room {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
```
 
The second developer proposed another implementation:
```java
public class Room {
    public String description;
}
```
 
Both developers are discussing which implementation is better and why. Please answer the following question:

Which of these two implementations would you select? And why?

Justify your answer in at least 250 words. Please explain the consequences, benefits and drawbacks of each implementation and support it with an example.

___

Answer:
The first implementation makes use of encapsulation, shielding (hiding) the class field "description", by making it private. This means that it can only be accessed from within the class. In this case, getter and setter methods have been created to indirectly access and mutate the description field. 

The other implementation leaves the description field public, thus it can be accessed or mutated in any way from anywhere in the code.

The primary advantage of the first implementation is that special behavior can be defined in the getters and setters that dictates how the description variable is accessed an mutated. Therefore as the description field is set, some code can be added to verify that the new description meets some requirement that the programmer decides on. Furthermore, it might be the case that the programmer wants to add these checks late in the program developement. If the check is added to the setter, then it applies to all places where the description is set. However with the second implementation, the checks on the description would have to be added in every place where the description field is directly mutated. This produces a lot of duplicated code.
___

# Question 2

In step 2, you are asked to create two interfaces: `Inspectable` and `Interactable`.
Interfaces by definition do not have implementations. They consist of method signatures:

```java
interface Inspectable {
    void inspect();
}
```
A software developer claims that interfaces are not useful, because they do not contain implementations. Thus, we should just use classes, and we do not need to define empty interfaces.

What do you think about this opinion? Do you agree or disagree with this opinion?

Please justify your answer in at least 250 words, and support your justifications with an example.

___

Answer:

___

# Question 3

To save your game state, you were asked to use Java classes `FileOutputStream` and `ObjectOutputStream`.
These two classes are part of the Java libraries, and they are designed based on a specific design pattern.

Which design pattern do `FileOutputStream` and `ObjectOutputStream` implement?

Explain the roles of this design pattern and how `FileOutputStream` and `ObjectOutputStream` implement it. Also explain the benefit of implementing this design pattern.

___

Answer:

___