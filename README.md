**Ying Pei  A13595990**

**Program**

Part 1:  Caesar cipher is an encryption method that allows us to encrypt code by right shift each character by a constant. For instance, if we encrypt "ABCD" by a constant 1, then it will be “BCDE”. Moreover, the turtle animation allows us to visually display the letter. The animation and the encryption are linked in a way which the turtle receives the letter from the caesar cipher encryption method and then draws that letter on the animation.

Part 2: StringBuilder class is a type of data structure. It contains a reference to the first "node". The Node reference points to the next Node, and this series continues until the series ends. The last Node’s nextNode reference is null to signify the end of the list. This means that all instantiated node references always point to the location of the next node and we will always know when the list ends (by checking for null). This is beneficial for us because based on this relationship between nodes, we can implement many methods: such as add, change and remove the element by changing the reference to the node. As a result, we can easily manipulate the String without the need to create new String.

**Testing**

Part 1: Both encryption methods require one or multiple turtles to draw the encrypted letter. In order to ensure the correctness of both cases, I drew the memory model of the method. Using the memory model, I can easily trace what the method is doing and debug what went wrong. Then,  I tested different scenarios. I tested invalid input first(lower case letters, empty strings, symbols). Then I tested the capital letters and made sure that the animation looks like the animation in the PA.

Part 2: In MyStringBuilder class, I tested the change method though changing the element at different position( when position = -2, 0 and when the position is bigger than the size of the list). Through this way, I know if I made a mistake, I know which part of the body method I need to improve. Then, I did the same thing for the remove method. For the add method and toString method, I rely on drawing memory model and the given tester. On a scale of 0-10, I am 80% confident about my data structure. 

**Conceptual Question**

In the context of encryptMT(), given a legal 8-character String and a maximum of two threads running simultaneously, and assuming every character takes the same amount of time to encrypt and draw, how long will the encryption take to finish the drawing? The unit of time is charTime, the amount of time it takes to encrypt and draw one character.

Assume the delay is: 30. (0.03 seconds)

0.03 * 4 =0.12 s

