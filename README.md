# 22122017-MDS273L-JAVA
Question

Below is an encryption/decryption standard in which the letters in the message will be replaced with the letters in the cypher row

Plain

A
B
C
D
E
F
G
H
I
J
K
L
M
N
O
P
Q
R
S
T
U
V
W
X
Y
Z

Cypher
X
Y
Z
A
B
C
D
E
F
G
H
I
J
K
L
M
N
O
P
Q
R
S
T
U
V
W

Plaintext:  THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG

Ciphertext: QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD

You are supposed to create a menu-driven program that can encrypt or decrypt a message that the user wishes to transfer.
Your program should have two functions, one for encryption and another for decryption. Each function will accept a string message and return the encrypted or decrypted message.

# Explanation :
EncryptionDecryption.java
 The program uses a menu system that allows the user to choose whether they want to encrypt or decrypt a message, or exit the program.

Running the program
To run the program, compile and run the EncryptionDecryption.java file. The program will then prompt the user with a menu and ask for input based on the user's selection.

The encrypt function
The encrypt function takes a message as input and returns the encrypted message. It does this by using a substitution cipher, where each letter in the message is replaced by the letter three positions ahead of it in the alphabet. For example, "A" would be replaced by "D", "B" by "E", and so on.

The decrypt function
The decrypt function takes an encrypted message as input and returns the decrypted message. It does this by using the same substitution cipher as the encrypt function, but in reverse. Each letter in the encrypted message is replaced by the letter three positions behind it in the alphabet.

The menu system
The program uses a while loop to continually prompt the user with a menu system. The user can select option 1 to encrypt a message, option 2 to decrypt a message, or option 3 to exit the program.

If the user selects option 1, they are prompted to enter a message to encrypt. The program then calls the encrypt function and displays the encrypted message.

If the user selects option 2, they are prompted to enter an encrypted message to decrypt. The program then calls the decrypt function and displays the decrypted message.

If the user selects option 3, the program exits the loop and ends.
If the user selects an invalid option, the program displays an error message and prompts the user to choose again.
