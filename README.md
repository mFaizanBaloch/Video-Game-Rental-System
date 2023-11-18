# Semester Project : Video Game Rental System (Console based)
This project is a management system for shopkeepers that deal in Video Game rentals. Developed in Java using OOP concepts, with a menu-driven approach to make things easy for end-user.

**Code Components:**
 
    Number of lines (in total): 500+ and going
    Number of class: 4

**Class and their purpose:**

    Main: main class of the program containing code for all the menus 
    Staff: class to store data for Staff members such as their ID, Name and Rank
    Customers: stores data for customers by profiling them with their CNIC, Phone number etc; and the games that they have rented
    Game: storing all the Video Game data such as the Platform, Title, Rental price etc

    NOTE: Staff, Customer and Game class stores data for each entity in individual objects using ArrayList.

**Imports used:**

    import java.util.ArrayList
    import java.util.Scanner

**Programming Concepts Used:**
    
    Fundamentals (e.g Conditional statements)
    Classes
    Constructors
    Getter and Setter functions
    toString function
    Encapsulation using Access modifiers
    ArrayLists
    Scanner

**Linkage (Hierarchy) of Menus:**

    Main Menu:
      Video Game Menu:
        Adding a Video Game
        Removing a Video Game
        Updating a Video Game's data
        Searching and Displaying
        Return to Main Menu
    
      Customer Menu:
        Adding a Customer Profile
        Removing a Customer Profile
        Updating a Customer's profile
        Searching and Displaying
        Return to Main Menu
        
      Staff Menu:
        Adding a Staff member
        Removing a Staff member
        Updating a Staff member
        Searching and Displaying
        Return to Main Menu
        
      Transaction recording
      
      Exiting the Program
